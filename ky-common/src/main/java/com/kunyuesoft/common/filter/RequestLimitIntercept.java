package com.kunyuesoft.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.kunyuesoft.common.annotation.RequestLimit;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.redis.RedisCache;
import com.kunyuesoft.common.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 请求拦截
 */
@Component
public class RequestLimitIntercept extends HandlerInterceptorAdapter {

    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * isAssignableFrom() 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口
         * isAssignableFrom()方法是判断是否为某个类的父类
         * instanceof关键字是判断是否某个类的子类
         */
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            //HandlerMethod 封装方法定义相关的信息,如类,方法,参数等
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 如果 方法上有注解就优先选择方法上的参数，否则类上的参数
            RequestLimit requestLimit = getTagAnnotation(method, RequestLimit.class);
            if(requestLimit != null){
                if(isLimit(request,requestLimit)){
                    resonseOut(response, ResultVOUtil.fail(ResultEnum.REQUST_LIMIT));
                    return false;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }
    //判断请求是否受限
    public boolean isLimit(HttpServletRequest request, RequestLimit requestLimit){
        // 受限的redis 缓存key ,因为这里用浏览器做测试，我就用sessionid 来做唯一key,如果是app ,可以使用 用户ID 之类的唯一标识。
        String limitKey = request.getServletPath()+request.getSession().getId();
        // 从缓存中获取，当前这个请求访问了几次
        Integer redisCount = (Integer) redisCache.getCacheObject(limitKey);
        if(redisCount == null){
            //初始 次数
            redisCache.setCacheObject(limitKey,1,requestLimit.second(), TimeUnit.SECONDS);
        }else{
            if(redisCount.intValue() >= requestLimit.maxCount()){
                return true;
            }
            // 次数自增
            redisCache.incr(limitKey,1);
        }
        return false;
    }

    /**
     * 获取目标注解
     * 如果方法上有注解就返回方法上的注解配置，否则类上的
     * @param method
     * @param annotationClass
     * @param <A>
     * @return
     */
    public <A extends Annotation> A getTagAnnotation(Method method, Class<A> annotationClass) {
        // 获取方法中是否包含注解
        Annotation methodAnnotate = method.getAnnotation(annotationClass);
        //获取 类中是否包含注解，也就是controller 是否有注解
        Annotation classAnnotate = method.getDeclaringClass().getAnnotation(annotationClass);
        return (A) (methodAnnotate!= null?methodAnnotate:classAnnotate);
    }

    /**
     * 回写给客户端
     * @param response
     * @param result
     * @throws IOException
     */
    private void resonseOut(HttpServletResponse response, ResultVO result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null ;
        String json = JSONObject.toJSON(result).toString();
        out = response.getWriter();
        out.append(json);
    }
}

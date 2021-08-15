package com.kunyuesoft.api.handle;

import com.alibaba.fastjson.JSON;
import com.kunyuesoft.api.base.LoginUserDTO;
import com.kunyuesoft.api.manager.AsyncFactory;
import com.kunyuesoft.api.manager.AsyncManager;
import com.kunyuesoft.common.constatnts.Constants;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.server.TokenService;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.common.utils.ServletUtils;
import com.kunyuesoft.common.utils.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 * 
 * @author kunyuesoft
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        LoginUserDTO loginUserDTO = tokenService.getLoginUser(request,LoginUserDTO.class);
        if (StringUtils.isNotNull(loginUserDTO))
        {
            String userName = loginUserDTO.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUserDTO.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(ResultVOUtil.fail(ResultEnum.SUCCESS.getCode(), "退出成功")));
    }
}

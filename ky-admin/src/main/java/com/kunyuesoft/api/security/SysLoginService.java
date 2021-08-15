package com.kunyuesoft.api.security;

import com.alibaba.fastjson.JSONObject;
import com.kunyuesoft.api.base.LoginUserDTO;
import com.kunyuesoft.api.manager.AsyncFactory;
import com.kunyuesoft.api.manager.AsyncManager;
import com.kunyuesoft.common.constatnts.Constants;
import com.kunyuesoft.common.constatnts.ErpConstants;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.exception.BtsException;
import com.kunyuesoft.common.server.TokenService;
import com.kunyuesoft.common.utils.DejcSecret;
import com.kunyuesoft.common.utils.MessageUtils;
import com.kunyuesoft.common.utils.StringUtils;
import com.kunyuesoft.service.system.SycErpUserService;
import com.kunyuesoft.service.system.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录校验方法
 * 
 * @author kunyuesoft
 */
@Slf4j
@Component
public class SysLoginService
{
    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SycErpUserService sycErpUserService;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid,String erpExtend)
    {
        LoginUserDTO loginUser;
        if(StringUtils.isEmpty(erpExtend)){
            loginUser = notErpLogin(username,password);
        } else {
            loginUser = erpLogin(erpExtend);
        }
        if(loginUser == null){
            throw new BtsException(ResultEnum.IS_ERROR.getCode(),MessageUtils.message("user.password.not.match"));
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 非直接从erp登录
     * */
    private LoginUserDTO notErpLogin(String username,String password){
        LoginUserDTO loginUser = null;
        String result = sycErpUserService.loginValid(username,password);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Boolean flag = jsonObject.getBoolean("flag");
        if(flag){
            loginUser = (LoginUserDTO) userDetailsService.loadUserByUsername(username);
        } else {
            // 用户验证
            Authentication authentication = null;
            try
            {
                // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
                authentication = authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(username, password));
            }
            catch (Exception e)
            {
                if (e instanceof BadCredentialsException)
                {
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                    throw new BtsException(ResultEnum.IS_ERROR.getCode(),MessageUtils.message("user.password.not.match"));
                }
                else
                {
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                    throw new BtsException(ResultEnum.IS_ERROR.getCode(),e.getMessage());
                }
            }
            loginUser = (LoginUserDTO) authentication.getPrincipal();
        }
        return loginUser;
    }

    /**
     * 直接从erp登录
     * @param erpExtend
     * */
    private LoginUserDTO erpLogin(String erpExtend){
        LoginUserDTO loginUser = null;
        Map<String, String> kvs = new HashMap<>();
        Arrays.asList(erpExtend.split("&"))
                .stream()
                .map(elem -> elem.split("="))
                .forEach(elem -> kvs.put(elem[0], elem[1]));
        String username = kvs.get(ErpConstants.ERP_USERNAME);
        String password = kvs.get(ErpConstants.ERP_PASSWORD);
        String key = kvs.get(ErpConstants.ERP_KEY);
        try {
            //password是加密后的,需解密
            password = new DejcSecret(ErpConstants.DEJC_SECRET_KEY+key).decrypt(password);
        } catch (Exception e){
            throw new BtsException(ResultEnum.IS_ERROR.getCode(),MessageUtils.message("user.password.not.match"));
        }
        String result = sycErpUserService.loginValid(username,password);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Boolean flag = jsonObject.getBoolean("flag");
        log.info("login验证:username={},password={},flag={}",username,password,flag);
        if(flag){
            SysUser sysUser = sysUserService.selectUserByUserName(username);
            if(sysUser == null){//用户不存在
                sysUser = new SysUser();
                sysUser.setUserName(username);
                sysUser.setPassword("$2a$10$0eyKN1MjxtQtO7xpu.R33.2bU83mo7CzXkHR5/CIP/iv.YVE1n.qu");
                sysUser.setNickName(username);
                sysUser.setCreateBy("system");
                sysUserService.insertUser(sysUser);
            }
            loginUser = (LoginUserDTO) userDetailsService.loadUserByUsername(username);
        }
        return loginUser;
    }
}

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
import com.kunyuesoft.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
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
    @Resource
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private SysUserService sysUserService;

    @Resource
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

}

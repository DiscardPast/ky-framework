package com.kunyuesoft.common.base;

import lombok.Data;
import lombok.ToString;

/**
 * 用户信息
 * 
 * @author kunyuesoft
 */
@Data
@ToString
public class UserInfoDTO
{

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;
}

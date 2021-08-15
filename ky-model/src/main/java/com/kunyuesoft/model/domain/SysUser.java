package com.kunyuesoft.model.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 用户信息对象 sys_user
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户Id */
    private Long userId;

    /** 部门Id */
    private String deptId;

    /** 岗位Id */
    private String postId;

    /** 用户名称 */
    private String userName;

    /** 用户昵称 */
    private String nickName;

    /** 用户类型 */
    private String userType;

    /** 用户邮箱 */
    private String userEmail;

    /** 用户手机号 */
    private String userPhone;

    /** 用户性别 */
    private String userSex;

    /** 用户头像 */
    private String userAvatar;

    /** 用户密码 */
    private String userPassword;

    /** 状态 */
    private String status;

    /** 删除标识 */
    private String isDeleted;

    /** 登录IP */
    private String loginIp;

    /** 登陆时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date loginTime;

    /** 部门对象 */
    private SysDept dept;

    /** 角色对象 */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private String[] postIds;

    /** 角色组 */
    private Long[] resourceRoleIds;

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}

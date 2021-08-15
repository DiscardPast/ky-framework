package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 用户资源角色关系对象 sys_user_resource_role
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysUserResourceRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户资源角色Id */
    private Long userResourceRoleid;

    /** 用户Id */
    private int userId;

    /** 资源角色Id */
    private int resourceRoleId;

}

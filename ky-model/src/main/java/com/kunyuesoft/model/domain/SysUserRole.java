package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 用户角色关系对象 sys_user_role
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysUserRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户Id */
    private int userId;

    /** 角色Id */
    private int roleId;

}

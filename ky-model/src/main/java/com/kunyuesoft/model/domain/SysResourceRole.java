package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 资源角色对象 sys_resource_role
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysResourceRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资源角色Id */
    private Long resourceRoleId;

    /** 资源角色名称 */
    private String resourceRoleName;

    /** 资源角色编码 */
    private String resourceRoleKey;

    /** 删除标识 */
    private String isDeleted;

}

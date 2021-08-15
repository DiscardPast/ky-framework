package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 资源角色关系对象 sys_resource_role_relation
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysResourceRoleRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资源角色关系Id */
    private Long id;

    /** 资源角色Id */
    private int resourceRoleId;

    /** 资源Id */
    private int resourceId;

}

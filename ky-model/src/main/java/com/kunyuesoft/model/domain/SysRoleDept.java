package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 角色部门关系对象 sys_role_dept
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysRoleDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 角色Id */
    private int roleId;

    /** 部门Id */
    private String deptId;

}

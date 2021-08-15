package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 角色信息对象 sys_role
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 角色Id */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色编码 */
    private String roleKey;

    /** 角色排序顺序 */
    private String roleSort;

    /** 角色数据范围 */
    private String dataScope;

    /** 状态 */
    private String status;

    /** 删除标识 */
    private String isDeleted;

}

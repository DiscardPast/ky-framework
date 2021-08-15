package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 部门信息对象 sys_dept
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门Id */
    private String deptId;

    /** 父级Id */
    private String parentId;

    /** 根部门 */
    private String ancestors;

    /** 部门名称 */
    private String deptName;

    /** 排序顺序 */
    private String orderNum;

    /** 部门领导 */
    private String leader;

    /** 电话 */
    private String phone;

    /** 邮件 */
    private String email;

    /** 状态 */
    private String status;

    /** 删除标识 */
    private String delFlag;

}

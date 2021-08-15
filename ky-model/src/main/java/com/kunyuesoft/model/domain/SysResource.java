package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 资源信息对象 sys_resource
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysResource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资源Id */
    private Long resourceId;

    /** 资源名称 */
    private String resourceName;

    /** 资源编号 */
    private String resourceNumber;

    /** 父级Id */
    private int parentId;

    /** 删除标识 */
    private String isDeleted;

}

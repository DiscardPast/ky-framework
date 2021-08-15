package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 岗位信息对象 sys_post
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 岗位Id */
    private String postId;

    /** 岗位编码 */
    private String postCode;

    /** 岗位名称 */
    private String postName;

    /** 岗位排序 */
    private String postSort;

    /** 状态 */
    private String status;

}

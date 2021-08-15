package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 用户岗位信息对象 sys_user_post
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysUserPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户Id */
    private String userId;

    /** 岗位Id */
    private String postId;

}

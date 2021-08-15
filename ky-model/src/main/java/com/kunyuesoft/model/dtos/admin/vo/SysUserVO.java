package com.kunyuesoft.model.dtos.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class SysUserVO {

    private String code;

    private String msg;

    List<SysRole> roles;

    List<SysPost> posts;

    List<SysResourceRole> resourceRoles;

    List<String> postIds;

    List<Integer> roleIds;

    List<Integer> resourceRoleIds;

    SysUser data;
}

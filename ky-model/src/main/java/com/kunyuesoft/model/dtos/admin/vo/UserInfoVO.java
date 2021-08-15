package com.kunyuesoft.model.dtos.admin.vo;

import lombok.Data;

import java.util.Set;

@Data
public class UserInfoVO {

    private SysUser user;

    private Set<String> roles;

    private Set<String> permissions;
}

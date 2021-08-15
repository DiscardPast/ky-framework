package com.kunyuesoft.model.dtos.admin.vo;

import lombok.Data;

@Data
public class ProfileVO {

    private SysUser user;

    private String roleGroup;

    private String postGroup;

}

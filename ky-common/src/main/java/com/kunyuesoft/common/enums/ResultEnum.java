package com.kunyuesoft.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    UNKNOW_ERROR("-1","未知异常"),
    REQUST_LIMIT("010000","请求次数受限"),
    NO_HANDLER_FOUND_ERROR("404","接口不存在"),
    SUCCESS("200", "成功"),
    PARAM_ERROR("301", "参数错误"),
    PARAM_FILE_IS_NOT_NULL("301001","上传文件不能为空"),
    PARAM_FILE_NAME_IS_NOT_NULL("301002","上传文件名不能为空"),
    DEPARTMENT_IS_STOP("401001","部门停用,不允许新增"),
    DICT_TYPE_IS_USE("401002","数据字典已分配,不能删除"),
    USER_ACCOUNT_IS_ERROR("402001","获取用户账户异常"),
    USER_INFO_IS_ERROR("402002","获取用户信息异常"),
    USER_IS_NOT_PERMITS("402003","用户没有权限"),
    USER_ROLE_IS_USE("402004","用户角色已分配,不能删除"),
    POST_IS_USE("403001","岗位已分配,不能删除"),
    IS_ERROR("500","系统异常")
    ;
    private String code;

    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

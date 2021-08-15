package com.kunyuesoft.model.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 操作信息对象 sys_oper_log
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysOperLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 操作信息Id */
    private Long operId;

    /** 标题 */
    private String title;

    /** 业务类型 */
    private String businessType;

    /** 执行方法 */
    private String method;

    /** 请求方法 */
    private String requestMethod;

    /** 操作类型 */
    private String operatorType;

    /** 操作人名称 */
    private String operName;

    /** 操作人部门 */
    private String deptName;

    /** 操作地址 */
    private String operUrl;

    /** 操作IP */
    private String operIp;

    /** 操作地点 */
    private String operLocation;

    /** 操作参数 */
    private String operParam;

    /** 操作结果 */
    private String jsonResult;

    /** 状态 */
    private String status;

    /** 错误信息 */
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date operTime;

}

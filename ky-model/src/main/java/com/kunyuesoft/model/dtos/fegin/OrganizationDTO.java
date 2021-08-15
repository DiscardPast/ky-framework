package com.kunyuesoft.model.dtos.fegin;


import lombok.Data;

@Data
public class OrganizationDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 部门Id
     */
    private String orgId;

    /**
     * 部门code
     */
    private String orgCode;

    /**
     * 部门名称
     */
    private String orgName;

    /**
     * 父Id
     */
    private String parentId;

    /**
     *
     */
    private String parentName;

    /**
     *
     */
    private String parentFullName;

    /**
     *
     */
    private String ifCompany;

    /**
     * 㼶
     */
    private String orgLevel;

    /**
     * 公司ID
     */
    private String compId;

    /**
     * 部门
     */
    private int empNum = 0;

    /**
     * 部门
     */
    private int allEmpNum = 0;
    private String org_tier_code;
    private String org_tier_name;


}
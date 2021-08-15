
package com.kunyuesoft.model.dtos.fegin;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     *     员工ID
     */
    public String empid;
    /**
     *     员工号
     */
    public String empNo;
    /**
     *     头像
     */
    private String imageURL;
    /**
     *     员工姓名
     */
    public String empName;
    /**
     *     员工id
     */
    public String compid;
    /**
     *     岗位ID
     */
    public String mainPostId;
    /**
     *     职位名称
     */
    public String mainPostName;
    /**
     *     身份证号
     */
    public String cerNo;
    /**
     *     电话
     */
    public String tel;
    /**
     *     email
     */
    public String offEmail;
    /**
     *     入职时间
     */
    public String entCorDate;
    /**
     *     证件类型
     */
    public String cerTypeId;
    /**
     *     性别
     */
    public String gender;
    /**
     *     学历
     */
    public String lastExper;

    /**
     *     部门ID
     */
    public String mainOrgId;



}

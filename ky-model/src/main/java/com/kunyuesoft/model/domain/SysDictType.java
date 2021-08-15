package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 字典类型信息对象 sys_dict_type
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysDictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字典Id */
    private Long dictId;

    /** 字典名称 */
    private String dictName;

    /** 字典类型 */
    private String dictType;

    /** 状态 */
    private String status;

}

package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 字典数据对象 sys_dict_data
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysDictData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字典编码 */
    private String dictCode;

    /** 字典排序 */
    private String dictSort;

    /** 字典标签 */
    private String dictLabel;

    /** 字典内容 */
    private String dictValue;

    /** 字典类型 */
    private String dictType;

    /** 样式类别 */
    private String cssClass;

    /** 列表类别 */
    private String listClass;

    /** 是否默认 */
    private String isDefault;

    /** 状态 */
    private String status;

}

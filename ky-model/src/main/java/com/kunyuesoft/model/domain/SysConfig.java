package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 配置信息对象 sys_config
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配置主键Id */
    private Long configId;

    /** 配置名称 */
    private String configName;

    /** 配置编码 */
    private String configKey;

    /** 配置内容 */
    private String configValue;

    /** 配置类型 */
    private String configType;

}

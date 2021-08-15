package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysConfig;

/**
 * 配置信息Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysConfigMapper 
{
    /**
     * 查询配置信息
     * 
     * @param configId 配置信息ID
     * @return 配置信息
     */
    public SysConfig selectSysConfigById(Long configId);

    /**
     * 查询配置信息列表
     * 
     * @param sysConfig 配置信息
     * @return 配置信息集合
     */
    public List<SysConfig> selectSysConfigList(SysConfig sysConfig);

    /**
     * 新增配置信息
     * 
     * @param sysConfig 配置信息
     * @return 执行结果
     */
    public int insertSysConfig(SysConfig sysConfig);

    /**
     * 修改配置信息
     * 
     * @param sysConfig 配置信息
     * @return 执行结果
     */
    public int updateSysConfig(SysConfig sysConfig);

    /**
     * 删除配置信息
     * 
     * @param configId 配置信息ID
     * @return 执行结果
     */
    public int deleteSysConfigById(Long configId);

    /**
     * 批量删除配置信息
     * 
     * @param configIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysConfigByIds(Long[] configIds);
}

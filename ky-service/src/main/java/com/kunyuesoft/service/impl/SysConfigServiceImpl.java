package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysConfigMapper;
import com.kunyuesoft.model.domain.SysConfig;
import com.kunyuesoft.service.SysConfigService;

/**
 * 配置信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysConfigServiceImpl implements SysConfigService
{
    @Resource
    private SysConfigMapper sysConfigMapper;

    /**
     * 查询配置信息
     * 
     * @param configId 配置信息ID
     * @return 配置信息
     */
    @Override
    public SysConfig selectSysConfigById(Long configId)
    {
        return sysConfigMapper.selectSysConfigById(configId);
    }

    /**
     * 查询配置信息列表
     * 
     * @param sysConfig 配置信息
     * @return 配置信息
     */
    @Override
    public List<SysConfig> selectSysConfigList(SysConfig sysConfig)
    {
        return sysConfigMapper.selectSysConfigList(sysConfig);
    }

    /**
     * 新增配置信息
     * 
     * @param sysConfig 配置信息
     * @return 执行结果
     */
    @Override
    public int insertSysConfig(SysConfig sysConfig)
    {
        sysConfig.setCreateTime(new Date());
        return sysConfigMapper.insertSysConfig(sysConfig);
    }

    /**
     * 修改配置信息
     * 
     * @param sysConfig 配置信息
     * @return 执行结果
     */
    @Override
    public int updateSysConfig(SysConfig sysConfig)
    {
        sysConfig.setUpdateTime(new Date());
        return sysConfigMapper.updateSysConfig(sysConfig);
    }

    /**
     * 批量删除配置信息
     * 
     * @param configIds 需要删除的配置信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysConfigByIds(Long[] configIds)
    {
        return sysConfigMapper.deleteSysConfigByIds(configIds);
    }

    /**
     * 删除配置信息信息
     * 
     * @param configId 配置信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysConfigById(Long configId)
    {
        return sysConfigMapper.deleteSysConfigById(configId);
    }
}

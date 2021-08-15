package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysResourceMapper;
import com.kunyuesoft.model.domain.SysResource;
import com.kunyuesoft.service.SysResourceService;

/**
 * 资源信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysResourceServiceImpl implements SysResourceService
{
    @Resource
    private SysResourceMapper sysResourceMapper;

    /**
     * 查询资源信息
     * 
     * @param resourceId 资源信息ID
     * @return 资源信息
     */
    @Override
    public SysResource selectSysResourceById(Long resourceId)
    {
        return sysResourceMapper.selectSysResourceById(resourceId);
    }

    /**
     * 查询资源信息列表
     * 
     * @param sysResource 资源信息
     * @return 资源信息
     */
    @Override
    public List<SysResource> selectSysResourceList(SysResource sysResource)
    {
        return sysResourceMapper.selectSysResourceList(sysResource);
    }

    /**
     * 新增资源信息
     * 
     * @param sysResource 资源信息
     * @return 执行结果
     */
    @Override
    public int insertSysResource(SysResource sysResource)
    {
        sysResource.setCreateTime(new Date());
        return sysResourceMapper.insertSysResource(sysResource);
    }

    /**
     * 修改资源信息
     * 
     * @param sysResource 资源信息
     * @return 执行结果
     */
    @Override
    public int updateSysResource(SysResource sysResource)
    {
        sysResource.setUpdateTime(new Date());
        return sysResourceMapper.updateSysResource(sysResource);
    }

    /**
     * 批量删除资源信息
     * 
     * @param resourceIds 需要删除的资源信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysResourceByIds(Long[] resourceIds)
    {
        return sysResourceMapper.deleteSysResourceByIds(resourceIds);
    }

    /**
     * 删除资源信息信息
     * 
     * @param resourceId 资源信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysResourceById(Long resourceId)
    {
        return sysResourceMapper.deleteSysResourceById(resourceId);
    }
}

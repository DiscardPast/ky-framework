package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysResourceRoleRelationMapper;
import com.kunyuesoft.model.domain.SysResourceRoleRelation;
import com.kunyuesoft.service.SysResourceRoleRelationService;

/**
 * 资源角色关系Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysResourceRoleRelationServiceImpl implements SysResourceRoleRelationService
{
    @Resource
    private SysResourceRoleRelationMapper sysResourceRoleRelationMapper;

    /**
     * 查询资源角色关系
     * 
     * @param id 资源角色关系ID
     * @return 资源角色关系
     */
    @Override
    public SysResourceRoleRelation selectSysResourceRoleRelationById(Long id)
    {
        return sysResourceRoleRelationMapper.selectSysResourceRoleRelationById(id);
    }

    /**
     * 查询资源角色关系列表
     * 
     * @param sysResourceRoleRelation 资源角色关系
     * @return 资源角色关系
     */
    @Override
    public List<SysResourceRoleRelation> selectSysResourceRoleRelationList(SysResourceRoleRelation sysResourceRoleRelation)
    {
        return sysResourceRoleRelationMapper.selectSysResourceRoleRelationList(sysResourceRoleRelation);
    }

    /**
     * 新增资源角色关系
     * 
     * @param sysResourceRoleRelation 资源角色关系
     * @return 执行结果
     */
    @Override
    public int insertSysResourceRoleRelation(SysResourceRoleRelation sysResourceRoleRelation)
    {
        return sysResourceRoleRelationMapper.insertSysResourceRoleRelation(sysResourceRoleRelation);
    }

    /**
     * 修改资源角色关系
     * 
     * @param sysResourceRoleRelation 资源角色关系
     * @return 执行结果
     */
    @Override
    public int updateSysResourceRoleRelation(SysResourceRoleRelation sysResourceRoleRelation)
    {
        return sysResourceRoleRelationMapper.updateSysResourceRoleRelation(sysResourceRoleRelation);
    }

    /**
     * 批量删除资源角色关系
     * 
     * @param ids 需要删除的资源角色关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysResourceRoleRelationByIds(Long[] ids)
    {
        return sysResourceRoleRelationMapper.deleteSysResourceRoleRelationByIds(ids);
    }

    /**
     * 删除资源角色关系信息
     * 
     * @param id 资源角色关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysResourceRoleRelationById(Long id)
    {
        return sysResourceRoleRelationMapper.deleteSysResourceRoleRelationById(id);
    }
}

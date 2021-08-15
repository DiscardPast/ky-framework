package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysResourceRoleMapper;
import com.kunyuesoft.model.domain.SysResourceRole;
import com.kunyuesoft.service.SysResourceRoleService;

/**
 * 资源角色Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysResourceRoleServiceImpl implements SysResourceRoleService
{
    @Resource
    private SysResourceRoleMapper sysResourceRoleMapper;

    /**
     * 查询资源角色
     * 
     * @param resourceRoleId 资源角色ID
     * @return 资源角色
     */
    @Override
    public SysResourceRole selectSysResourceRoleById(Long resourceRoleId)
    {
        return sysResourceRoleMapper.selectSysResourceRoleById(resourceRoleId);
    }

    /**
     * 查询资源角色列表
     * 
     * @param sysResourceRole 资源角色
     * @return 资源角色
     */
    @Override
    public List<SysResourceRole> selectSysResourceRoleList(SysResourceRole sysResourceRole)
    {
        return sysResourceRoleMapper.selectSysResourceRoleList(sysResourceRole);
    }

    /**
     * 新增资源角色
     * 
     * @param sysResourceRole 资源角色
     * @return 执行结果
     */
    @Override
    public int insertSysResourceRole(SysResourceRole sysResourceRole)
    {
        sysResourceRole.setCreateTime(new Date());
        return sysResourceRoleMapper.insertSysResourceRole(sysResourceRole);
    }

    /**
     * 修改资源角色
     * 
     * @param sysResourceRole 资源角色
     * @return 执行结果
     */
    @Override
    public int updateSysResourceRole(SysResourceRole sysResourceRole)
    {
        sysResourceRole.setUpdateTime(new Date());
        return sysResourceRoleMapper.updateSysResourceRole(sysResourceRole);
    }

    /**
     * 批量删除资源角色
     * 
     * @param resourceRoleIds 需要删除的资源角色ID
     * @return 执行结果
     */
    @Override
    public int deleteSysResourceRoleByIds(Long[] resourceRoleIds)
    {
        return sysResourceRoleMapper.deleteSysResourceRoleByIds(resourceRoleIds);
    }

    /**
     * 删除资源角色信息
     * 
     * @param resourceRoleId 资源角色ID
     * @return 执行结果
     */
    @Override
    public int deleteSysResourceRoleById(Long resourceRoleId)
    {
        return sysResourceRoleMapper.deleteSysResourceRoleById(resourceRoleId);
    }
}

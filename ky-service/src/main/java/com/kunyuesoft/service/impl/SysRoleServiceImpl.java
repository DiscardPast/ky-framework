package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysRoleMapper;
import com.kunyuesoft.model.domain.SysRole;
import com.kunyuesoft.service.SysRoleService;

/**
 * 角色信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysRoleServiceImpl implements SysRoleService
{
    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询角色信息
     * 
     * @param roleId 角色信息ID
     * @return 角色信息
     */
    @Override
    public SysRole selectSysRoleById(Long roleId)
    {
        return sysRoleMapper.selectSysRoleById(roleId);
    }

    /**
     * 查询角色信息列表
     * 
     * @param sysRole 角色信息
     * @return 角色信息
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole)
    {
        return sysRoleMapper.selectSysRoleList(sysRole);
    }

    /**
     * 新增角色信息
     * 
     * @param sysRole 角色信息
     * @return 执行结果
     */
    @Override
    public int insertSysRole(SysRole sysRole)
    {
        sysRole.setCreateTime(new Date());
        return sysRoleMapper.insertSysRole(sysRole);
    }

    /**
     * 修改角色信息
     * 
     * @param sysRole 角色信息
     * @return 执行结果
     */
    @Override
    public int updateSysRole(SysRole sysRole)
    {
        sysRole.setUpdateTime(new Date());
        return sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 批量删除角色信息
     * 
     * @param roleIds 需要删除的角色信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysRoleByIds(Long[] roleIds)
    {
        return sysRoleMapper.deleteSysRoleByIds(roleIds);
    }

    /**
     * 删除角色信息信息
     * 
     * @param roleId 角色信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysRoleById(Long roleId)
    {
        return sysRoleMapper.deleteSysRoleById(roleId);
    }
}

package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysUserResourceRoleMapper;
import com.kunyuesoft.model.domain.SysUserResourceRole;
import com.kunyuesoft.service.SysUserResourceRoleService;

/**
 * 用户资源角色关系Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysUserResourceRoleServiceImpl implements SysUserResourceRoleService
{
    @Resource
    private SysUserResourceRoleMapper sysUserResourceRoleMapper;

    /**
     * 查询用户资源角色关系
     * 
     * @param userResourceRoleid 用户资源角色关系ID
     * @return 用户资源角色关系
     */
    @Override
    public SysUserResourceRole selectSysUserResourceRoleById(Long userResourceRoleid)
    {
        return sysUserResourceRoleMapper.selectSysUserResourceRoleById(userResourceRoleid);
    }

    /**
     * 查询用户资源角色关系列表
     * 
     * @param sysUserResourceRole 用户资源角色关系
     * @return 用户资源角色关系
     */
    @Override
    public List<SysUserResourceRole> selectSysUserResourceRoleList(SysUserResourceRole sysUserResourceRole)
    {
        return sysUserResourceRoleMapper.selectSysUserResourceRoleList(sysUserResourceRole);
    }

    /**
     * 新增用户资源角色关系
     * 
     * @param sysUserResourceRole 用户资源角色关系
     * @return 执行结果
     */
    @Override
    public int insertSysUserResourceRole(SysUserResourceRole sysUserResourceRole)
    {
        return sysUserResourceRoleMapper.insertSysUserResourceRole(sysUserResourceRole);
    }

    /**
     * 修改用户资源角色关系
     * 
     * @param sysUserResourceRole 用户资源角色关系
     * @return 执行结果
     */
    @Override
    public int updateSysUserResourceRole(SysUserResourceRole sysUserResourceRole)
    {
        return sysUserResourceRoleMapper.updateSysUserResourceRole(sysUserResourceRole);
    }

    /**
     * 批量删除用户资源角色关系
     * 
     * @param userResourceRoleids 需要删除的用户资源角色关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserResourceRoleByIds(Long[] userResourceRoleids)
    {
        return sysUserResourceRoleMapper.deleteSysUserResourceRoleByIds(userResourceRoleids);
    }

    /**
     * 删除用户资源角色关系信息
     * 
     * @param userResourceRoleid 用户资源角色关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserResourceRoleById(Long userResourceRoleid)
    {
        return sysUserResourceRoleMapper.deleteSysUserResourceRoleById(userResourceRoleid);
    }
}

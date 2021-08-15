package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysUserRoleMapper;
import com.kunyuesoft.model.domain.SysUserRole;
import com.kunyuesoft.service.SysUserRoleService;

/**
 * 用户角色关系Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService
{
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询用户角色关系
     * 
     * @param userId 用户角色关系ID
     * @return 用户角色关系
     */
    @Override
    public SysUserRole selectSysUserRoleById(int userId)
    {
        return sysUserRoleMapper.selectSysUserRoleById(userId);
    }

    /**
     * 查询用户角色关系列表
     * 
     * @param sysUserRole 用户角色关系
     * @return 用户角色关系
     */
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole)
    {
        return sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
    }

    /**
     * 新增用户角色关系
     * 
     * @param sysUserRole 用户角色关系
     * @return 执行结果
     */
    @Override
    public int insertSysUserRole(SysUserRole sysUserRole)
    {
        return sysUserRoleMapper.insertSysUserRole(sysUserRole);
    }

    /**
     * 修改用户角色关系
     * 
     * @param sysUserRole 用户角色关系
     * @return 执行结果
     */
    @Override
    public int updateSysUserRole(SysUserRole sysUserRole)
    {
        return sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 批量删除用户角色关系
     * 
     * @param userIds 需要删除的用户角色关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserRoleByIds(int[] userIds)
    {
        return sysUserRoleMapper.deleteSysUserRoleByIds(userIds);
    }

    /**
     * 删除用户角色关系信息
     * 
     * @param userId 用户角色关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserRoleById(int userId)
    {
        return sysUserRoleMapper.deleteSysUserRoleById(userId);
    }
}

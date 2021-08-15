package com.kunyuesoft.service;

import java.util.List;
import com.kunyuesoft.model.domain.SysRole;

/**
 * 角色信息Service接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysRoleService
{
    /**
     * 查询角色信息
     * 
     * @param roleId 角色信息ID
     * @return 角色信息
     */
    public SysRole selectSysRoleById(Long roleId);

    /**
     * 查询角色信息列表
     * 
     * @param sysRole 角色信息
     * @return 角色信息集合
     */
    public List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 新增角色信息
     * 
     * @param sysRole 角色信息
     * @return 执行结果
     */
    public int insertSysRole(SysRole sysRole);

    /**
     * 修改角色信息
     * 
     * @param sysRole 角色信息
     * @return 执行结果
     */
    public int updateSysRole(SysRole sysRole);

    /**
     * 批量删除角色信息
     * 
     * @param roleIds 需要删除的角色信息ID
     * @return 执行结果
     */
    public int deleteSysRoleByIds(Long[] roleIds);

    /**
     * 删除角色信息信息
     * 
     * @param roleId 角色信息ID
     * @return 执行结果
     */
    public int deleteSysRoleById(Long roleId);
}

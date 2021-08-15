package com.kunyuesoft.service;

import java.util.List;
import com.kunyuesoft.model.domain.SysRoleMenu;

/**
 * 角色菜单Service接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysRoleMenuService
{
    /**
     * 查询角色菜单
     * 
     * @param roleId 角色菜单ID
     * @return 角色菜单
     */
    public SysRoleMenu selectSysRoleMenuById(int roleId);

    /**
     * 查询角色菜单列表
     * 
     * @param sysRoleMenu 角色菜单
     * @return 角色菜单集合
     */
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);

    /**
     * 新增角色菜单
     * 
     * @param sysRoleMenu 角色菜单
     * @return 执行结果
     */
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 修改角色菜单
     * 
     * @param sysRoleMenu 角色菜单
     * @return 执行结果
     */
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 批量删除角色菜单
     * 
     * @param roleIds 需要删除的角色菜单ID
     * @return 执行结果
     */
    public int deleteSysRoleMenuByIds(int[] roleIds);

    /**
     * 删除角色菜单信息
     * 
     * @param roleId 角色菜单ID
     * @return 执行结果
     */
    public int deleteSysRoleMenuById(int roleId);
}

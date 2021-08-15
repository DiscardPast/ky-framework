package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysRoleMenuMapper;
import com.kunyuesoft.model.domain.SysRoleMenu;
import com.kunyuesoft.service.SysRoleMenuService;

/**
 * 角色菜单Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService
{
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 查询角色菜单
     * 
     * @param roleId 角色菜单ID
     * @return 角色菜单
     */
    @Override
    public SysRoleMenu selectSysRoleMenuById(int roleId)
    {
        return sysRoleMenuMapper.selectSysRoleMenuById(roleId);
    }

    /**
     * 查询角色菜单列表
     * 
     * @param sysRoleMenu 角色菜单
     * @return 角色菜单
     */
    @Override
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.selectSysRoleMenuList(sysRoleMenu);
    }

    /**
     * 新增角色菜单
     * 
     * @param sysRoleMenu 角色菜单
     * @return 执行结果
     */
    @Override
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.insertSysRoleMenu(sysRoleMenu);
    }

    /**
     * 修改角色菜单
     * 
     * @param sysRoleMenu 角色菜单
     * @return 执行结果
     */
    @Override
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.updateSysRoleMenu(sysRoleMenu);
    }

    /**
     * 批量删除角色菜单
     * 
     * @param roleIds 需要删除的角色菜单ID
     * @return 执行结果
     */
    @Override
    public int deleteSysRoleMenuByIds(int[] roleIds)
    {
        return sysRoleMenuMapper.deleteSysRoleMenuByIds(roleIds);
    }

    /**
     * 删除角色菜单信息
     * 
     * @param roleId 角色菜单ID
     * @return 执行结果
     */
    @Override
    public int deleteSysRoleMenuById(int roleId)
    {
        return sysRoleMenuMapper.deleteSysRoleMenuById(roleId);
    }
}

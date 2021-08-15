package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysMenuMapper;
import com.kunyuesoft.model.domain.SysMenu;
import com.kunyuesoft.service.SysMenuService;

/**
 * 菜单信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysMenuServiceImpl implements SysMenuService
{
    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询菜单信息
     * 
     * @param menuId 菜单信息ID
     * @return 菜单信息
     */
    @Override
    public SysMenu selectSysMenuById(Integer menuId)
    {
        return sysMenuMapper.selectSysMenuById(menuId);
    }

    /**
     * 查询菜单信息列表
     * 
     * @param sysMenu 菜单信息
     * @return 菜单信息
     */
    @Override
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu)
    {
        return sysMenuMapper.selectSysMenuList(sysMenu);
    }

    /**
     * 新增菜单信息
     * 
     * @param sysMenu 菜单信息
     * @return 执行结果
     */
    @Override
    public int insertSysMenu(SysMenu sysMenu)
    {
        sysMenu.setCreateTime(new Date());
        return sysMenuMapper.insertSysMenu(sysMenu);
    }

    /**
     * 修改菜单信息
     * 
     * @param sysMenu 菜单信息
     * @return 执行结果
     */
    @Override
    public int updateSysMenu(SysMenu sysMenu)
    {
        sysMenu.setUpdateTime(new Date());
        return sysMenuMapper.updateSysMenu(sysMenu);
    }

    /**
     * 批量删除菜单信息
     * 
     * @param menuIds 需要删除的菜单信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysMenuByIds(Integer[] menuIds)
    {
        return sysMenuMapper.deleteSysMenuByIds(menuIds);
    }

    /**
     * 删除菜单信息信息
     * 
     * @param menuId 菜单信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysMenuById(Integer menuId)
    {
        return sysMenuMapper.deleteSysMenuById(menuId);
    }
}

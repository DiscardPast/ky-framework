package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysMenu;

/**
 * 菜单信息Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysMenuMapper 
{
    /**
     * 查询菜单信息
     * 
     * @param menuId 菜单信息ID
     * @return 菜单信息
     */
    public SysMenu selectSysMenuById(Integer menuId);

    /**
     * 查询菜单信息列表
     * 
     * @param sysMenu 菜单信息
     * @return 菜单信息集合
     */
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    /**
     * 新增菜单信息
     * 
     * @param sysMenu 菜单信息
     * @return 执行结果
     */
    public int insertSysMenu(SysMenu sysMenu);

    /**
     * 修改菜单信息
     * 
     * @param sysMenu 菜单信息
     * @return 执行结果
     */
    public int updateSysMenu(SysMenu sysMenu);

    /**
     * 删除菜单信息
     * 
     * @param menuId 菜单信息ID
     * @return 执行结果
     */
    public int deleteSysMenuById(Integer menuId);

    /**
     * 批量删除菜单信息
     * 
     * @param menuIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysMenuByIds(Integer[] menuIds);
}

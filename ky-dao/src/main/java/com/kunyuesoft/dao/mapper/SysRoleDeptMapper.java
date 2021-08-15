package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysRoleDept;

/**
 * 角色部门关系Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysRoleDeptMapper 
{
    /**
     * 查询角色部门关系
     * 
     * @param roleId 角色部门关系ID
     * @return 角色部门关系
     */
    public SysRoleDept selectSysRoleDeptById(int roleId);

    /**
     * 查询角色部门关系列表
     * 
     * @param sysRoleDept 角色部门关系
     * @return 角色部门关系集合
     */
    public List<SysRoleDept> selectSysRoleDeptList(SysRoleDept sysRoleDept);

    /**
     * 新增角色部门关系
     * 
     * @param sysRoleDept 角色部门关系
     * @return 执行结果
     */
    public int insertSysRoleDept(SysRoleDept sysRoleDept);

    /**
     * 修改角色部门关系
     * 
     * @param sysRoleDept 角色部门关系
     * @return 执行结果
     */
    public int updateSysRoleDept(SysRoleDept sysRoleDept);

    /**
     * 删除角色部门关系
     * 
     * @param roleId 角色部门关系ID
     * @return 执行结果
     */
    public int deleteSysRoleDeptById(int roleId);

    /**
     * 批量删除角色部门关系
     * 
     * @param roleIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysRoleDeptByIds(int[] roleIds);
}

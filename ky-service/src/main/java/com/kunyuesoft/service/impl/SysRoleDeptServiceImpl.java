package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysRoleDeptMapper;
import com.kunyuesoft.model.domain.SysRoleDept;
import com.kunyuesoft.service.SysRoleDeptService;

/**
 * 角色部门关系Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService
{
    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;

    /**
     * 查询角色部门关系
     * 
     * @param roleId 角色部门关系ID
     * @return 角色部门关系
     */
    @Override
    public SysRoleDept selectSysRoleDeptById(int roleId)
    {
        return sysRoleDeptMapper.selectSysRoleDeptById(roleId);
    }

    /**
     * 查询角色部门关系列表
     * 
     * @param sysRoleDept 角色部门关系
     * @return 角色部门关系
     */
    @Override
    public List<SysRoleDept> selectSysRoleDeptList(SysRoleDept sysRoleDept)
    {
        return sysRoleDeptMapper.selectSysRoleDeptList(sysRoleDept);
    }

    /**
     * 新增角色部门关系
     * 
     * @param sysRoleDept 角色部门关系
     * @return 执行结果
     */
    @Override
    public int insertSysRoleDept(SysRoleDept sysRoleDept)
    {
        return sysRoleDeptMapper.insertSysRoleDept(sysRoleDept);
    }

    /**
     * 修改角色部门关系
     * 
     * @param sysRoleDept 角色部门关系
     * @return 执行结果
     */
    @Override
    public int updateSysRoleDept(SysRoleDept sysRoleDept)
    {
        return sysRoleDeptMapper.updateSysRoleDept(sysRoleDept);
    }

    /**
     * 批量删除角色部门关系
     * 
     * @param roleIds 需要删除的角色部门关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysRoleDeptByIds(int[] roleIds)
    {
        return sysRoleDeptMapper.deleteSysRoleDeptByIds(roleIds);
    }

    /**
     * 删除角色部门关系信息
     * 
     * @param roleId 角色部门关系ID
     * @return 执行结果
     */
    @Override
    public int deleteSysRoleDeptById(int roleId)
    {
        return sysRoleDeptMapper.deleteSysRoleDeptById(roleId);
    }
}

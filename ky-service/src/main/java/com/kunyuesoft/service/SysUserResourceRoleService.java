package com.kunyuesoft.service;

import java.util.List;
import com.kunyuesoft.model.domain.SysUserResourceRole;

/**
 * 用户资源角色关系Service接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysUserResourceRoleService
{
    /**
     * 查询用户资源角色关系
     * 
     * @param userResourceRoleid 用户资源角色关系ID
     * @return 用户资源角色关系
     */
    public SysUserResourceRole selectSysUserResourceRoleById(Long userResourceRoleid);

    /**
     * 查询用户资源角色关系列表
     * 
     * @param sysUserResourceRole 用户资源角色关系
     * @return 用户资源角色关系集合
     */
    public List<SysUserResourceRole> selectSysUserResourceRoleList(SysUserResourceRole sysUserResourceRole);

    /**
     * 新增用户资源角色关系
     * 
     * @param sysUserResourceRole 用户资源角色关系
     * @return 执行结果
     */
    public int insertSysUserResourceRole(SysUserResourceRole sysUserResourceRole);

    /**
     * 修改用户资源角色关系
     * 
     * @param sysUserResourceRole 用户资源角色关系
     * @return 执行结果
     */
    public int updateSysUserResourceRole(SysUserResourceRole sysUserResourceRole);

    /**
     * 批量删除用户资源角色关系
     * 
     * @param userResourceRoleids 需要删除的用户资源角色关系ID
     * @return 执行结果
     */
    public int deleteSysUserResourceRoleByIds(Long[] userResourceRoleids);

    /**
     * 删除用户资源角色关系信息
     * 
     * @param userResourceRoleid 用户资源角色关系ID
     * @return 执行结果
     */
    public int deleteSysUserResourceRoleById(Long userResourceRoleid);
}

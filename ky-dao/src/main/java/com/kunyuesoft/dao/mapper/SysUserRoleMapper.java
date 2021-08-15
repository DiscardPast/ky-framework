package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysUserRole;

/**
 * 用户角色关系Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysUserRoleMapper 
{
    /**
     * 查询用户角色关系
     * 
     * @param userId 用户角色关系ID
     * @return 用户角色关系
     */
    public SysUserRole selectSysUserRoleById(int userId);

    /**
     * 查询用户角色关系列表
     * 
     * @param sysUserRole 用户角色关系
     * @return 用户角色关系集合
     */
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

    /**
     * 新增用户角色关系
     * 
     * @param sysUserRole 用户角色关系
     * @return 执行结果
     */
    public int insertSysUserRole(SysUserRole sysUserRole);

    /**
     * 修改用户角色关系
     * 
     * @param sysUserRole 用户角色关系
     * @return 执行结果
     */
    public int updateSysUserRole(SysUserRole sysUserRole);

    /**
     * 删除用户角色关系
     * 
     * @param userId 用户角色关系ID
     * @return 执行结果
     */
    public int deleteSysUserRoleById(int userId);

    /**
     * 批量删除用户角色关系
     * 
     * @param userIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysUserRoleByIds(int[] userIds);
}

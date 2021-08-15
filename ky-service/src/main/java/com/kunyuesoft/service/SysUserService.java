package com.kunyuesoft.service;

import java.util.List;
import com.kunyuesoft.model.domain.SysUser;

/**
 * 用户信息Service接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysUserService
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public SysUser selectSysUserById(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param sysUser 用户信息
     * @return 用户信息集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 新增用户信息
     * 
     * @param sysUser 用户信息
     * @return 执行结果
     */
    public int insertSysUser(SysUser sysUser);

    /**
     * 修改用户信息
     * 
     * @param sysUser 用户信息
     * @return 执行结果
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户信息ID
     * @return 执行结果
     */
    public int deleteSysUserByIds(Long[] userIds);

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 执行结果
     */
    public int deleteSysUserById(Long userId);
}

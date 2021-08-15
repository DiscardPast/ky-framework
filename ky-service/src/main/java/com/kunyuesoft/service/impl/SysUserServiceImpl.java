package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysUserMapper;
import com.kunyuesoft.model.domain.SysUser;
import com.kunyuesoft.service.SysUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysUserServiceImpl implements SysUserService
{
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public SysUser selectSysUserById(Long userId)
    {
        return sysUserMapper.selectSysUserById(userId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param sysUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser)
    {
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /**
     * 新增用户信息
     * 
     * @param sysUser 用户信息
     * @return 执行结果
     */
    @Override
    public int insertSysUser(SysUser sysUser)
    {
        sysUser.setCreateTime(new Date());
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 修改用户信息
     * 
     * @param sysUser 用户信息
     * @return 执行结果
     */
    @Override
    public int updateSysUser(SysUser sysUser)
    {
        sysUser.setUpdateTime(new Date());
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserByIds(Long[] userIds)
    {
        return sysUserMapper.deleteSysUserByIds(userIds);
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserById(Long userId)
    {
        return sysUserMapper.deleteSysUserById(userId);
    }
}

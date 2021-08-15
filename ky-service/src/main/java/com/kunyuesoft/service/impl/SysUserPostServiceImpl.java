package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysUserPostMapper;
import com.kunyuesoft.model.domain.SysUserPost;
import com.kunyuesoft.service.SysUserPostService;

/**
 * 用户岗位信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysUserPostServiceImpl implements SysUserPostService
{
    @Resource
    private SysUserPostMapper sysUserPostMapper;

    /**
     * 查询用户岗位信息
     * 
     * @param userId 用户岗位信息ID
     * @return 用户岗位信息
     */
    @Override
    public SysUserPost selectSysUserPostById(String userId)
    {
        return sysUserPostMapper.selectSysUserPostById(userId);
    }

    /**
     * 查询用户岗位信息列表
     * 
     * @param sysUserPost 用户岗位信息
     * @return 用户岗位信息
     */
    @Override
    public List<SysUserPost> selectSysUserPostList(SysUserPost sysUserPost)
    {
        return sysUserPostMapper.selectSysUserPostList(sysUserPost);
    }

    /**
     * 新增用户岗位信息
     * 
     * @param sysUserPost 用户岗位信息
     * @return 执行结果
     */
    @Override
    public int insertSysUserPost(SysUserPost sysUserPost)
    {
        return sysUserPostMapper.insertSysUserPost(sysUserPost);
    }

    /**
     * 修改用户岗位信息
     * 
     * @param sysUserPost 用户岗位信息
     * @return 执行结果
     */
    @Override
    public int updateSysUserPost(SysUserPost sysUserPost)
    {
        return sysUserPostMapper.updateSysUserPost(sysUserPost);
    }

    /**
     * 批量删除用户岗位信息
     * 
     * @param userIds 需要删除的用户岗位信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserPostByIds(String[] userIds)
    {
        return sysUserPostMapper.deleteSysUserPostByIds(userIds);
    }

    /**
     * 删除用户岗位信息信息
     * 
     * @param userId 用户岗位信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysUserPostById(String userId)
    {
        return sysUserPostMapper.deleteSysUserPostById(userId);
    }
}

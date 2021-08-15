package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysPostMapper;
import com.kunyuesoft.model.domain.SysPost;
import com.kunyuesoft.service.SysPostService;

/**
 * 岗位信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysPostServiceImpl implements SysPostService
{
    @Resource
    private SysPostMapper sysPostMapper;

    /**
     * 查询岗位信息
     * 
     * @param postId 岗位信息ID
     * @return 岗位信息
     */
    @Override
    public SysPost selectSysPostById(String postId)
    {
        return sysPostMapper.selectSysPostById(postId);
    }

    /**
     * 查询岗位信息列表
     * 
     * @param sysPost 岗位信息
     * @return 岗位信息
     */
    @Override
    public List<SysPost> selectSysPostList(SysPost sysPost)
    {
        return sysPostMapper.selectSysPostList(sysPost);
    }

    /**
     * 新增岗位信息
     * 
     * @param sysPost 岗位信息
     * @return 执行结果
     */
    @Override
    public int insertSysPost(SysPost sysPost)
    {
        sysPost.setCreateTime(new Date());
        return sysPostMapper.insertSysPost(sysPost);
    }

    /**
     * 修改岗位信息
     * 
     * @param sysPost 岗位信息
     * @return 执行结果
     */
    @Override
    public int updateSysPost(SysPost sysPost)
    {
        sysPost.setUpdateTime(new Date());
        return sysPostMapper.updateSysPost(sysPost);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param postIds 需要删除的岗位信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysPostByIds(String[] postIds)
    {
        return sysPostMapper.deleteSysPostByIds(postIds);
    }

    /**
     * 删除岗位信息信息
     * 
     * @param postId 岗位信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysPostById(String postId)
    {
        return sysPostMapper.deleteSysPostById(postId);
    }
}

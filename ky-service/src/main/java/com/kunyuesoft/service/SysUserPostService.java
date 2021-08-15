package com.kunyuesoft.service;

import java.util.List;
import com.kunyuesoft.model.domain.SysUserPost;

/**
 * 用户岗位信息Service接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysUserPostService
{
    /**
     * 查询用户岗位信息
     * 
     * @param userId 用户岗位信息ID
     * @return 用户岗位信息
     */
    public SysUserPost selectSysUserPostById(String userId);

    /**
     * 查询用户岗位信息列表
     * 
     * @param sysUserPost 用户岗位信息
     * @return 用户岗位信息集合
     */
    public List<SysUserPost> selectSysUserPostList(SysUserPost sysUserPost);

    /**
     * 新增用户岗位信息
     * 
     * @param sysUserPost 用户岗位信息
     * @return 执行结果
     */
    public int insertSysUserPost(SysUserPost sysUserPost);

    /**
     * 修改用户岗位信息
     * 
     * @param sysUserPost 用户岗位信息
     * @return 执行结果
     */
    public int updateSysUserPost(SysUserPost sysUserPost);

    /**
     * 批量删除用户岗位信息
     * 
     * @param userIds 需要删除的用户岗位信息ID
     * @return 执行结果
     */
    public int deleteSysUserPostByIds(String[] userIds);

    /**
     * 删除用户岗位信息信息
     * 
     * @param userId 用户岗位信息ID
     * @return 执行结果
     */
    public int deleteSysUserPostById(String userId);
}

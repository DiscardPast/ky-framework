package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysPost;

/**
 * 岗位信息Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysPostMapper 
{
    /**
     * 查询岗位信息
     * 
     * @param postId 岗位信息ID
     * @return 岗位信息
     */
    public SysPost selectSysPostById(String postId);

    /**
     * 查询岗位信息列表
     * 
     * @param sysPost 岗位信息
     * @return 岗位信息集合
     */
    public List<SysPost> selectSysPostList(SysPost sysPost);

    /**
     * 新增岗位信息
     * 
     * @param sysPost 岗位信息
     * @return 执行结果
     */
    public int insertSysPost(SysPost sysPost);

    /**
     * 修改岗位信息
     * 
     * @param sysPost 岗位信息
     * @return 执行结果
     */
    public int updateSysPost(SysPost sysPost);

    /**
     * 删除岗位信息
     * 
     * @param postId 岗位信息ID
     * @return 执行结果
     */
    public int deleteSysPostById(String postId);

    /**
     * 批量删除岗位信息
     * 
     * @param postIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysPostByIds(String[] postIds);
}

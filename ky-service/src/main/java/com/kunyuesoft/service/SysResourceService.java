package com.kunyuesoft.service;

import java.util.List;
import com.kunyuesoft.model.domain.SysResource;

/**
 * 资源信息Service接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysResourceService
{
    /**
     * 查询资源信息
     * 
     * @param resourceId 资源信息ID
     * @return 资源信息
     */
    public SysResource selectSysResourceById(Long resourceId);

    /**
     * 查询资源信息列表
     * 
     * @param sysResource 资源信息
     * @return 资源信息集合
     */
    public List<SysResource> selectSysResourceList(SysResource sysResource);

    /**
     * 新增资源信息
     * 
     * @param sysResource 资源信息
     * @return 执行结果
     */
    public int insertSysResource(SysResource sysResource);

    /**
     * 修改资源信息
     * 
     * @param sysResource 资源信息
     * @return 执行结果
     */
    public int updateSysResource(SysResource sysResource);

    /**
     * 批量删除资源信息
     * 
     * @param resourceIds 需要删除的资源信息ID
     * @return 执行结果
     */
    public int deleteSysResourceByIds(Long[] resourceIds);

    /**
     * 删除资源信息信息
     * 
     * @param resourceId 资源信息ID
     * @return 执行结果
     */
    public int deleteSysResourceById(Long resourceId);
}

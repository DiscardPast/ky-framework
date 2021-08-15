package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysResourceRoleRelation;

/**
 * 资源角色关系Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysResourceRoleRelationMapper 
{
    /**
     * 查询资源角色关系
     * 
     * @param id 资源角色关系ID
     * @return 资源角色关系
     */
    public SysResourceRoleRelation selectSysResourceRoleRelationById(Long id);

    /**
     * 查询资源角色关系列表
     * 
     * @param sysResourceRoleRelation 资源角色关系
     * @return 资源角色关系集合
     */
    public List<SysResourceRoleRelation> selectSysResourceRoleRelationList(SysResourceRoleRelation sysResourceRoleRelation);

    /**
     * 新增资源角色关系
     * 
     * @param sysResourceRoleRelation 资源角色关系
     * @return 执行结果
     */
    public int insertSysResourceRoleRelation(SysResourceRoleRelation sysResourceRoleRelation);

    /**
     * 修改资源角色关系
     * 
     * @param sysResourceRoleRelation 资源角色关系
     * @return 执行结果
     */
    public int updateSysResourceRoleRelation(SysResourceRoleRelation sysResourceRoleRelation);

    /**
     * 删除资源角色关系
     * 
     * @param id 资源角色关系ID
     * @return 执行结果
     */
    public int deleteSysResourceRoleRelationById(Long id);

    /**
     * 批量删除资源角色关系
     * 
     * @param ids 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysResourceRoleRelationByIds(Long[] ids);
}

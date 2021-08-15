package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysResourceRole;

/**
 * 资源角色Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysResourceRoleMapper 
{
    /**
     * 查询资源角色
     * 
     * @param resourceRoleId 资源角色ID
     * @return 资源角色
     */
    public SysResourceRole selectSysResourceRoleById(Long resourceRoleId);

    /**
     * 查询资源角色列表
     * 
     * @param sysResourceRole 资源角色
     * @return 资源角色集合
     */
    public List<SysResourceRole> selectSysResourceRoleList(SysResourceRole sysResourceRole);

    /**
     * 新增资源角色
     * 
     * @param sysResourceRole 资源角色
     * @return 执行结果
     */
    public int insertSysResourceRole(SysResourceRole sysResourceRole);

    /**
     * 修改资源角色
     * 
     * @param sysResourceRole 资源角色
     * @return 执行结果
     */
    public int updateSysResourceRole(SysResourceRole sysResourceRole);

    /**
     * 删除资源角色
     * 
     * @param resourceRoleId 资源角色ID
     * @return 执行结果
     */
    public int deleteSysResourceRoleById(Long resourceRoleId);

    /**
     * 批量删除资源角色
     * 
     * @param resourceRoleIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysResourceRoleByIds(Long[] resourceRoleIds);
}

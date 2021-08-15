package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysDept;

/**
 * 部门信息Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysDeptMapper 
{
    /**
     * 查询部门信息
     * 
     * @param deptId 部门信息ID
     * @return 部门信息
     */
    public SysDept selectSysDeptById(String deptId);

    /**
     * 查询部门信息列表
     * 
     * @param sysDept 部门信息
     * @return 部门信息集合
     */
    public List<SysDept> selectSysDeptList(SysDept sysDept);

    /**
     * 新增部门信息
     * 
     * @param sysDept 部门信息
     * @return 执行结果
     */
    public int insertSysDept(SysDept sysDept);

    /**
     * 修改部门信息
     * 
     * @param sysDept 部门信息
     * @return 执行结果
     */
    public int updateSysDept(SysDept sysDept);

    /**
     * 删除部门信息
     * 
     * @param deptId 部门信息ID
     * @return 执行结果
     */
    public int deleteSysDeptById(String deptId);

    /**
     * 批量删除部门信息
     * 
     * @param deptIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysDeptByIds(String[] deptIds);
}

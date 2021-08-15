package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysDeptMapper;
import com.kunyuesoft.model.domain.SysDept;
import com.kunyuesoft.service.SysDeptService;

/**
 * 部门信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysDeptServiceImpl implements SysDeptService
{
    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询部门信息
     * 
     * @param deptId 部门信息ID
     * @return 部门信息
     */
    @Override
    public SysDept selectSysDeptById(String deptId)
    {
        return sysDeptMapper.selectSysDeptById(deptId);
    }

    /**
     * 查询部门信息列表
     * 
     * @param sysDept 部门信息
     * @return 部门信息
     */
    @Override
    public List<SysDept> selectSysDeptList(SysDept sysDept)
    {
        return sysDeptMapper.selectSysDeptList(sysDept);
    }

    /**
     * 新增部门信息
     * 
     * @param sysDept 部门信息
     * @return 执行结果
     */
    @Override
    public int insertSysDept(SysDept sysDept)
    {
        sysDept.setCreateTime(new Date());
        return sysDeptMapper.insertSysDept(sysDept);
    }

    /**
     * 修改部门信息
     * 
     * @param sysDept 部门信息
     * @return 执行结果
     */
    @Override
    public int updateSysDept(SysDept sysDept)
    {
        sysDept.setUpdateTime(new Date());
        return sysDeptMapper.updateSysDept(sysDept);
    }

    /**
     * 批量删除部门信息
     * 
     * @param deptIds 需要删除的部门信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysDeptByIds(String[] deptIds)
    {
        return sysDeptMapper.deleteSysDeptByIds(deptIds);
    }

    /**
     * 删除部门信息信息
     * 
     * @param deptId 部门信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysDeptById(String deptId)
    {
        return sysDeptMapper.deleteSysDeptById(deptId);
    }
}

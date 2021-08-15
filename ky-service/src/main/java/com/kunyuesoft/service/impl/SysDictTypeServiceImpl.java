package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysDictTypeMapper;
import com.kunyuesoft.model.domain.SysDictType;
import com.kunyuesoft.service.SysDictTypeService;


/**
 * 字典类型信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService
{
    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    /**
     * 查询字典类型信息
     * 
     * @param dictId 字典类型信息ID
     * @return 字典类型信息
     */
    @Override
    public SysDictType selectSysDictTypeById(Long dictId)
    {
        return sysDictTypeMapper.selectSysDictTypeById(dictId);
    }

    /**
     * 查询字典类型信息列表
     * 
     * @param sysDictType 字典类型信息
     * @return 字典类型信息
     */
    @Override
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType)
    {
        return sysDictTypeMapper.selectSysDictTypeList(sysDictType);
    }

    /**
     * 新增字典类型信息
     * 
     * @param sysDictType 字典类型信息
     * @return 执行结果
     */
    @Override
    public int insertSysDictType(SysDictType sysDictType)
    {
        sysDictType.setCreateTime(new Date());
        return sysDictTypeMapper.insertSysDictType(sysDictType);
    }

    /**
     * 修改字典类型信息
     * 
     * @param sysDictType 字典类型信息
     * @return 执行结果
     */
    @Override
    public int updateSysDictType(SysDictType sysDictType)
    {
        sysDictType.setUpdateTime(new Date());
        return sysDictTypeMapper.updateSysDictType(sysDictType);
    }

    /**
     * 批量删除字典类型信息
     * 
     * @param dictIds 需要删除的字典类型信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysDictTypeByIds(Long[] dictIds)
    {
        return sysDictTypeMapper.deleteSysDictTypeByIds(dictIds);
    }

    /**
     * 删除字典类型信息信息
     * 
     * @param dictId 字典类型信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysDictTypeById(Long dictId)
    {
        return sysDictTypeMapper.deleteSysDictTypeById(dictId);
    }
}

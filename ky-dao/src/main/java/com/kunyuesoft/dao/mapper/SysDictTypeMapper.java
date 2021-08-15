package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysDictType;

/**
 * 字典类型信息Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysDictTypeMapper 
{
    /**
     * 查询字典类型信息
     * 
     * @param dictId 字典类型信息ID
     * @return 字典类型信息
     */
    public SysDictType selectSysDictTypeById(Long dictId);

    /**
     * 查询字典类型信息列表
     * 
     * @param sysDictType 字典类型信息
     * @return 字典类型信息集合
     */
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType);

    /**
     * 新增字典类型信息
     * 
     * @param sysDictType 字典类型信息
     * @return 执行结果
     */
    public int insertSysDictType(SysDictType sysDictType);

    /**
     * 修改字典类型信息
     * 
     * @param sysDictType 字典类型信息
     * @return 执行结果
     */
    public int updateSysDictType(SysDictType sysDictType);

    /**
     * 删除字典类型信息
     * 
     * @param dictId 字典类型信息ID
     * @return 执行结果
     */
    public int deleteSysDictTypeById(Long dictId);

    /**
     * 批量删除字典类型信息
     * 
     * @param dictIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysDictTypeByIds(Long[] dictIds);
}

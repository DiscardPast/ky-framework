package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysDictData;

/**
 * 字典数据Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysDictDataMapper 
{
    /**
     * 查询字典数据
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public SysDictData selectSysDictDataById(String dictCode);

    /**
     * 查询字典数据列表
     * 
     * @param sysDictData 字典数据
     * @return 字典数据集合
     */
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData);

    /**
     * 新增字典数据
     * 
     * @param sysDictData 字典数据
     * @return 执行结果
     */
    public int insertSysDictData(SysDictData sysDictData);

    /**
     * 修改字典数据
     * 
     * @param sysDictData 字典数据
     * @return 执行结果
     */
    public int updateSysDictData(SysDictData sysDictData);

    /**
     * 删除字典数据
     * 
     * @param dictCode 字典数据ID
     * @return 执行结果
     */
    public int deleteSysDictDataById(String dictCode);

    /**
     * 批量删除字典数据
     * 
     * @param dictCodes 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysDictDataByIds(String[] dictCodes);
}

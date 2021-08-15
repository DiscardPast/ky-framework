package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysDictDataMapper;
import com.kunyuesoft.model.domain.SysDictData;
import com.kunyuesoft.service.SysDictDataService;

/**
 * 字典数据Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysDictDataServiceImpl implements SysDictDataService
{
    @Resource
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 查询字典数据
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public SysDictData selectSysDictDataById(String dictCode)
    {
        return sysDictDataMapper.selectSysDictDataById(dictCode);
    }

    /**
     * 查询字典数据列表
     * 
     * @param sysDictData 字典数据
     * @return 字典数据
     */
    @Override
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData)
    {
        return sysDictDataMapper.selectSysDictDataList(sysDictData);
    }

    /**
     * 新增字典数据
     * 
     * @param sysDictData 字典数据
     * @return 执行结果
     */
    @Override
    public int insertSysDictData(SysDictData sysDictData)
    {
        sysDictData.setCreateTime(new Date());
        return sysDictDataMapper.insertSysDictData(sysDictData);
    }

    /**
     * 修改字典数据
     * 
     * @param sysDictData 字典数据
     * @return 执行结果
     */
    @Override
    public int updateSysDictData(SysDictData sysDictData)
    {
        sysDictData.setUpdateTime(new Date());
        return sysDictDataMapper.updateSysDictData(sysDictData);
    }

    /**
     * 批量删除字典数据
     * 
     * @param dictCodes 需要删除的字典数据ID
     * @return 执行结果
     */
    @Override
    public int deleteSysDictDataByIds(String[] dictCodes)
    {
        return sysDictDataMapper.deleteSysDictDataByIds(dictCodes);
    }

    /**
     * 删除字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 执行结果
     */
    @Override
    public int deleteSysDictDataById(String dictCode)
    {
        return sysDictDataMapper.deleteSysDictDataById(dictCode);
    }
}

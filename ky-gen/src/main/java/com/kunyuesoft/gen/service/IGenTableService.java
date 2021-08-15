package com.kunyuesoft.gen.service;

import com.kunyuesoft.gen.domain.GenTable;

import java.util.List;

/**
 * 业务 服务层
 * 
 * @author kunyuesoft
 */
public interface IGenTableService
{

    /**
     * 生成代码
     * 
     * @param genTable 表名称
     * @return 数据
     */
    public byte[] generatorCode(GenTable genTable) throws Exception;

    /**
     * 批量生成代码
     * 
     * @param genTableList 表数组
     * @return 数据
     */
    public byte[] generatorCode(List<GenTable> genTableList) throws Exception;

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    public List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 导入表结构
     *
     * @param tableList 导入表列表
     */
    public List<GenTable> importGenTable(List<GenTable> tableList);
}

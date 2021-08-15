package com.kunyuesoft.gen.service.impl;

import com.google.api.client.util.Lists;
import com.kunyuesoft.gen.constants.GenConstants;
import com.kunyuesoft.gen.domain.GenTableColumn;
import com.kunyuesoft.gen.mapper.GenTableColumnMapper;
import com.kunyuesoft.gen.mapper.GenTableMapper;
import com.kunyuesoft.gen.service.IGenTableService;
import com.kunyuesoft.common.constatnts.Constants;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.exception.BtsException;
import com.kunyuesoft.common.utils.StringUtils;
import com.kunyuesoft.gen.domain.GenTable;
import com.kunyuesoft.gen.util.GenUtils;
import com.kunyuesoft.gen.util.VelocityInitializer;
import com.kunyuesoft.gen.util.VelocityUtils;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 业务 服务层实现
 * 
 * @author kunyuesoft
 */
@Service
public class GenTableServiceImpl implements IGenTableService
{
    private static final Logger log = LoggerFactory.getLogger(GenTableServiceImpl.class);

    @Autowired
    private GenTableMapper genTableMapper;

    @Autowired
    private GenTableColumnMapper genTableColumnMapper;


    /**
     * 生成代码
     * 
     * @param genTable 表名称
     * @return 数据
     */
    @Override
    public byte[] generatorCode(GenTable genTable) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        generatorCode(genTable, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 批量生成代码
     * 
     * @param genTableList 表数组
     * @return 数据
     */
    @Override
    public byte[] generatorCode(List<GenTable> genTableList) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (GenTable table : genTableList)
        {
            generatorCode(table, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    @Override
    public List<GenTable> selectDbTableListByNames(String[] tableNames)
    {
        return genTableMapper.selectDbTableListByNames(tableNames);
    }

    /**
     * 查询表信息并生成代码
     */
    private void generatorCode(GenTable table, ZipOutputStream zip) throws Exception {
        // 查询列信息
        List<GenTableColumn> columns = table.getColumns();
        setPkColumn(table, columns);

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates)
        {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            try
            {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(VelocityUtils.getFileName(template, table)));
                IOUtils.write(sw.toString(), zip, Constants.UTF8);
                IOUtils.closeQuietly(sw);
				zip.flush();
                zip.closeEntry();
            }
            catch (IOException e)
            {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
            }
        }
    }

    /**
     * 导入表结构
     *
     * @param tableList 导入表列表
     */
    @Override
    @Transactional
    public List<GenTable> importGenTable(List<GenTable> tableList)
    {
        List<GenTable> result = Lists.newArrayList();
        try
        {
            for (GenTable table : tableList)
            {
                String tableName = table.getTableName();
                GenUtils.initTable(table);
                if(StringUtils.isEmpty(table.getTplCategory())){
                    table.setTplCategory(GenConstants.TPL_CRUD);
                }
                // 保存列信息
                List<GenTableColumn> genTableColumns = genTableColumnMapper.selectDbTableColumnsByName(tableName);
                for (GenTableColumn column : genTableColumns)
                {
                    GenUtils.initColumnField(column, table);
                }
                table.setColumns(genTableColumns);
                result.add(table);
            }
        }
        catch (Exception e)
        {
            throw new BtsException(ResultEnum.IS_ERROR.getCode(),"导入失败：" + e.getMessage());
        }

        return result;
    }

    /**
     * 设置主键列信息
     * 
     * @param table 业务表信息
     * @param columns 业务字段列表
     */
    public void setPkColumn(GenTable table, List<GenTableColumn> columns)
    {
        for (GenTableColumn column : columns)
        {
            if (column.isPk())
            {
                table.setPkColumn(column);
                break;
            }
        }
        if (StringUtils.isNull(table.getPkColumn()))
        {
            table.setPkColumn(columns.get(0));
        }
    }
}
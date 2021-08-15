package com.kunyuesoft.api.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kunyuesoft.model.domain.SysDictData;
import com.kunyuesoft.service.SysDictDataService;

import javax.annotation.Resource;


/**
 * 字典数据Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "字典数据表接口", tags = "字典数据表模块")
@RestController
@RequestMapping("/kunyuesoft/data")
public class SysDictDataController extends BaseController
{
    @Resource
    private SysDictDataService sysDictDataService;

    /**
    * 查询字典数据列表
    *
    *
    * @param sysDictData SysDictDataDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询字典数据表", notes = "查询字典数据表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:data:list')")
    @GetMapping("/list")
    public ResultVO list(SysDictData sysDictData)
    {
        startPage();
        List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        return getDataTable(list);
    }

    /**
     * 获取字典数据详细信息
     *
     *
     * @param dictCode SysDictDataId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取字典数据表", notes = "获取字典数据表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:data:query')")
    @GetMapping(value = "/{dictCode}")
    public ResultVO getInfo(@PathVariable("dictCode") String dictCode)
    {
        return ResultVOUtil.success(sysDictDataService.selectSysDictDataById(dictCode));
    }

    /**
     * 新增字典数据
     *
     *
     * @param sysDictData SysDictDataDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增字典数据表", notes = "新增字典数据表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:data:add')")
    @Log(title = "字典数据", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysDictData sysDictData)
    {
        return ResultVOUtil.success(sysDictDataService.insertSysDictData(sysDictData));
    }

    /**
     * 修改字典数据
     *
     *
     * @param sysDictData SysDictDataDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改字典数据表", notes = "修改字典数据表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:data:edit')")
    @Log(title = "字典数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysDictData sysDictData)
    {
        return ResultVOUtil.success(sysDictDataService.updateSysDictData(sysDictData));
    }

    /**
     * 删除字典数据
     *
     *
     * @param dictCodes SysDictDataIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改字典数据表", notes = "修改字典数据表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:data:remove')")
    @Log(title = "字典数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dictCodes}")
    public ResultVO remove(@PathVariable String[] dictCodes)
    {
        return ResultVOUtil.success(sysDictDataService.deleteSysDictDataByIds(dictCodes));
    }
}

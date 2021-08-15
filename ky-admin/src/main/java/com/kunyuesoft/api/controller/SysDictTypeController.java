package com.kunyuesoft.api.controller;

import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.model.domain.SysDictType;
import com.kunyuesoft.service.SysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 字典类型信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "字典类型信息表接口", tags = "字典类型信息表模块")
@RestController
@RequestMapping("/kunyuesoft/type")
public class SysDictTypeController extends BaseController
{
    @Resource
    private SysDictTypeService sysDictTypeService;

    /**
    * 查询字典类型信息列表
    *
    *
    * @param sysDictType SysDictTypeDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询字典类型信息表", notes = "查询字典类型信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:type:list')")
    @GetMapping("/list")
    public ResultVO list(SysDictType sysDictType)
    {
        startPage();
        List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
        return getDataTable(list);
    }

    /**
     * 获取字典类型信息详细信息
     *
     *
     * @param dictId SysDictTypeId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取字典类型信息表", notes = "获取字典类型信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:type:query')")
    @GetMapping(value = "/{dictId}")
    public ResultVO getInfo(@PathVariable("dictId") Long dictId)
    {
        return ResultVOUtil.success(sysDictTypeService.selectSysDictTypeById(dictId));
    }

    /**
     * 新增字典类型信息
     *
     *
     * @param sysDictType SysDictTypeDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增字典类型信息表", notes = "新增字典类型信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:type:add')")
    @Log(title = "字典类型信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysDictType sysDictType)
    {
        return ResultVOUtil.success(sysDictTypeService.insertSysDictType(sysDictType));
    }

    /**
     * 修改字典类型信息
     *
     *
     * @param sysDictType SysDictTypeDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改字典类型信息表", notes = "修改字典类型信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:type:edit')")
    @Log(title = "字典类型信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysDictType sysDictType)
    {
        return ResultVOUtil.success(sysDictTypeService.updateSysDictType(sysDictType));
    }

    /**
     * 删除字典类型信息
     *
     *
     * @param dictIds SysDictTypeIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改字典类型信息表", notes = "修改字典类型信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:type:remove')")
    @Log(title = "字典类型信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dictIds}")
    public ResultVO remove(@PathVariable Long[] dictIds)
    {
        return ResultVOUtil.success(sysDictTypeService.deleteSysDictTypeByIds(dictIds));
    }
}

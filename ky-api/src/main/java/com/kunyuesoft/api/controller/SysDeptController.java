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
import com.kunyuesoft.model.domain.SysDept;
import com.kunyuesoft.service.SysDeptService;

import javax.annotation.Resource;


/**
 * 部门信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "部门信息表接口", tags = "部门信息表模块")
@RestController
@RequestMapping("/kunyuesoft/dept")
public class SysDeptController extends BaseController
{
    @Resource
    private SysDeptService sysDeptService;

    /**
    * 查询部门信息列表
    *
    *
    * @param sysDept SysDeptDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询部门信息表", notes = "查询部门信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:list')")
    @GetMapping("/list")
    public ResultVO list(SysDept sysDept)
    {
        startPage();
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        return getDataTable(list);
    }

    /**
     * 获取部门信息详细信息
     *
     *
     * @param deptId SysDeptId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取部门信息表", notes = "获取部门信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:query')")
    @GetMapping(value = "/{deptId}")
    public ResultVO getInfo(@PathVariable("deptId") String deptId)
    {
        return ResultVOUtil.success(sysDeptService.selectSysDeptById(deptId));
    }

    /**
     * 新增部门信息
     *
     *
     * @param sysDept SysDeptDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增部门信息表", notes = "新增部门信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:add')")
    @Log(title = "部门信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysDept sysDept)
    {
        return ResultVOUtil.success(sysDeptService.insertSysDept(sysDept));
    }

    /**
     * 修改部门信息
     *
     *
     * @param sysDept SysDeptDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改部门信息表", notes = "修改部门信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:edit')")
    @Log(title = "部门信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysDept sysDept)
    {
        return ResultVOUtil.success(sysDeptService.updateSysDept(sysDept));
    }

    /**
     * 删除部门信息
     *
     *
     * @param deptIds SysDeptIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改部门信息表", notes = "修改部门信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:remove')")
    @Log(title = "部门信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public ResultVO remove(@PathVariable String[] deptIds)
    {
        return ResultVOUtil.success(sysDeptService.deleteSysDeptByIds(deptIds));
    }
}

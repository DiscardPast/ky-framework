package com.kunyuesoft.api.controller;

import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.model.domain.SysRoleDept;
import com.kunyuesoft.service.SysRoleDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 角色部门关系Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "角色部门关系表接口", tags = "角色部门关系表模块")
@RestController
@RequestMapping("/kunyuesoft/dept")
public class SysRoleDeptController extends BaseController
{
    @Resource
    private SysRoleDeptService sysRoleDeptService;

    /**
    * 查询角色部门关系列表
    *
    *
    * @param sysRoleDept SysRoleDeptDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询角色部门关系表", notes = "查询角色部门关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:list')")
    @GetMapping("/list")
    public ResultVO list(SysRoleDept sysRoleDept)
    {
        startPage();
        List<SysRoleDept> list = sysRoleDeptService.selectSysRoleDeptList(sysRoleDept);
        return getDataTable(list);
    }

    /**
     * 获取角色部门关系详细信息
     *
     *
     * @param roleId SysRoleDeptId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取角色部门关系表", notes = "获取角色部门关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:query')")
    @GetMapping(value = "/{roleId}")
    public ResultVO getInfo(@PathVariable("roleId") int roleId)
    {
        return ResultVOUtil.success(sysRoleDeptService.selectSysRoleDeptById(roleId));
    }

    /**
     * 新增角色部门关系
     *
     *
     * @param sysRoleDept SysRoleDeptDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增角色部门关系表", notes = "新增角色部门关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:add')")
    @Log(title = "角色部门关系", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysRoleDept sysRoleDept)
    {
        return ResultVOUtil.success(sysRoleDeptService.insertSysRoleDept(sysRoleDept));
    }

    /**
     * 修改角色部门关系
     *
     *
     * @param sysRoleDept SysRoleDeptDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改角色部门关系表", notes = "修改角色部门关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:edit')")
    @Log(title = "角色部门关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysRoleDept sysRoleDept)
    {
        return ResultVOUtil.success(sysRoleDeptService.updateSysRoleDept(sysRoleDept));
    }

    /**
     * 删除角色部门关系
     *
     *
     * @param roleIds SysRoleDeptIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改角色部门关系表", notes = "修改角色部门关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:dept:remove')")
    @Log(title = "角色部门关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public ResultVO remove(@PathVariable int[] roleIds)
    {
        return ResultVOUtil.success(sysRoleDeptService.deleteSysRoleDeptByIds(roleIds));
    }
}

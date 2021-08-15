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
import com.kunyuesoft.model.domain.SysRole;
import com.kunyuesoft.service.SysRoleService;

import javax.annotation.Resource;


/**
 * 角色信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "角色信息表接口", tags = "角色信息表模块")
@RestController
@RequestMapping("/kunyuesoft/role")
public class SysRoleController extends BaseController
{
    @Resource
    private SysRoleService sysRoleService;

    /**
    * 查询角色信息列表
    *
    *
    * @param sysRole SysRoleDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询角色信息表", notes = "查询角色信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:list')")
    @GetMapping("/list")
    public ResultVO list(SysRole sysRole)
    {
        startPage();
        List<SysRole> list = sysRoleService.selectSysRoleList(sysRole);
        return getDataTable(list);
    }

    /**
     * 获取角色信息详细信息
     *
     *
     * @param roleId SysRoleId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取角色信息表", notes = "获取角色信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:query')")
    @GetMapping(value = "/{roleId}")
    public ResultVO getInfo(@PathVariable("roleId") Long roleId)
    {
        return ResultVOUtil.success(sysRoleService.selectSysRoleById(roleId));
    }

    /**
     * 新增角色信息
     *
     *
     * @param sysRole SysRoleDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增角色信息表", notes = "新增角色信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:add')")
    @Log(title = "角色信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysRole sysRole)
    {
        return ResultVOUtil.success(sysRoleService.insertSysRole(sysRole));
    }

    /**
     * 修改角色信息
     *
     *
     * @param sysRole SysRoleDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改角色信息表", notes = "修改角色信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:edit')")
    @Log(title = "角色信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysRole sysRole)
    {
        return ResultVOUtil.success(sysRoleService.updateSysRole(sysRole));
    }

    /**
     * 删除角色信息
     *
     *
     * @param roleIds SysRoleIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改角色信息表", notes = "修改角色信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:remove')")
    @Log(title = "角色信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public ResultVO remove(@PathVariable Long[] roleIds)
    {
        return ResultVOUtil.success(sysRoleService.deleteSysRoleByIds(roleIds));
    }
}

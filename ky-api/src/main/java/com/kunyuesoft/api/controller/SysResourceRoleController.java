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
import com.kunyuesoft.model.domain.SysResourceRole;
import com.kunyuesoft.service.SysResourceRoleService;

import javax.annotation.Resource;


/**
 * 资源角色Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "资源角色表接口", tags = "资源角色表模块")
@RestController
@RequestMapping("/kunyuesoft/role")
public class SysResourceRoleController extends BaseController
{
    @Resource
    private SysResourceRoleService sysResourceRoleService;

    /**
    * 查询资源角色列表
    *
    *
    * @param sysResourceRole SysResourceRoleDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询资源角色表", notes = "查询资源角色表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:list')")
    @GetMapping("/list")
    public ResultVO list(SysResourceRole sysResourceRole)
    {
        startPage();
        List<SysResourceRole> list = sysResourceRoleService.selectSysResourceRoleList(sysResourceRole);
        return getDataTable(list);
    }

    /**
     * 获取资源角色详细信息
     *
     *
     * @param resourceRoleId SysResourceRoleId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取资源角色表", notes = "获取资源角色表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:query')")
    @GetMapping(value = "/{resourceRoleId}")
    public ResultVO getInfo(@PathVariable("resourceRoleId") Long resourceRoleId)
    {
        return ResultVOUtil.success(sysResourceRoleService.selectSysResourceRoleById(resourceRoleId));
    }

    /**
     * 新增资源角色
     *
     *
     * @param sysResourceRole SysResourceRoleDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增资源角色表", notes = "新增资源角色表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:add')")
    @Log(title = "资源角色", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysResourceRole sysResourceRole)
    {
        return ResultVOUtil.success(sysResourceRoleService.insertSysResourceRole(sysResourceRole));
    }

    /**
     * 修改资源角色
     *
     *
     * @param sysResourceRole SysResourceRoleDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改资源角色表", notes = "修改资源角色表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:edit')")
    @Log(title = "资源角色", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysResourceRole sysResourceRole)
    {
        return ResultVOUtil.success(sysResourceRoleService.updateSysResourceRole(sysResourceRole));
    }

    /**
     * 删除资源角色
     *
     *
     * @param resourceRoleIds SysResourceRoleIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改资源角色表", notes = "修改资源角色表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:remove')")
    @Log(title = "资源角色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{resourceRoleIds}")
    public ResultVO remove(@PathVariable Long[] resourceRoleIds)
    {
        return ResultVOUtil.success(sysResourceRoleService.deleteSysResourceRoleByIds(resourceRoleIds));
    }
}

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
import com.kunyuesoft.model.domain.SysRoleMenu;
import com.kunyuesoft.service.SysRoleMenuService;

import javax.annotation.Resource;


/**
 * 角色菜单Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "角色菜单表接口", tags = "角色菜单表模块")
@RestController
@RequestMapping("/kunyuesoft/menu")
public class SysRoleMenuController extends BaseController
{
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
    * 查询角色菜单列表
    *
    *
    * @param sysRoleMenu SysRoleMenuDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询角色菜单表", notes = "查询角色菜单表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:list')")
    @GetMapping("/list")
    public ResultVO list(SysRoleMenu sysRoleMenu)
    {
        startPage();
        List<SysRoleMenu> list = sysRoleMenuService.selectSysRoleMenuList(sysRoleMenu);
        return getDataTable(list);
    }

    /**
     * 获取角色菜单详细信息
     *
     *
     * @param roleId SysRoleMenuId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取角色菜单表", notes = "获取角色菜单表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:query')")
    @GetMapping(value = "/{roleId}")
    public ResultVO getInfo(@PathVariable("roleId") int roleId)
    {
        return ResultVOUtil.success(sysRoleMenuService.selectSysRoleMenuById(roleId));
    }

    /**
     * 新增角色菜单
     *
     *
     * @param sysRoleMenu SysRoleMenuDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增角色菜单表", notes = "新增角色菜单表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:add')")
    @Log(title = "角色菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysRoleMenu sysRoleMenu)
    {
        return ResultVOUtil.success(sysRoleMenuService.insertSysRoleMenu(sysRoleMenu));
    }

    /**
     * 修改角色菜单
     *
     *
     * @param sysRoleMenu SysRoleMenuDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改角色菜单表", notes = "修改角色菜单表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:edit')")
    @Log(title = "角色菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysRoleMenu sysRoleMenu)
    {
        return ResultVOUtil.success(sysRoleMenuService.updateSysRoleMenu(sysRoleMenu));
    }

    /**
     * 删除角色菜单
     *
     *
     * @param roleIds SysRoleMenuIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改角色菜单表", notes = "修改角色菜单表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:remove')")
    @Log(title = "角色菜单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public ResultVO remove(@PathVariable int[] roleIds)
    {
        return ResultVOUtil.success(sysRoleMenuService.deleteSysRoleMenuByIds(roleIds));
    }
}

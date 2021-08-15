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
import com.kunyuesoft.model.domain.SysMenu;
import com.kunyuesoft.service.SysMenuService;

import javax.annotation.Resource;


/**
 * 菜单信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "菜单信息表接口", tags = "菜单信息表模块")
@RestController
@RequestMapping("/kunyuesoft/menu")
public class SysMenuController extends BaseController
{
    @Resource
    private SysMenuService sysMenuService;

    /**
    * 查询菜单信息列表
    *
    *
    * @param sysMenu SysMenuDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询菜单信息表", notes = "查询菜单信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:list')")
    @GetMapping("/list")
    public ResultVO list(SysMenu sysMenu)
    {
        startPage();
        List<SysMenu> list = sysMenuService.selectSysMenuList(sysMenu);
        return getDataTable(list);
    }

    /**
     * 获取菜单信息详细信息
     *
     *
     * @param menuId SysMenuId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取菜单信息表", notes = "获取菜单信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:query')")
    @GetMapping(value = "/{menuId}")
    public ResultVO getInfo(@PathVariable("menuId") Integer menuId)
    {
        return ResultVOUtil.success(sysMenuService.selectSysMenuById(menuId));
    }

    /**
     * 新增菜单信息
     *
     *
     * @param sysMenu SysMenuDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增菜单信息表", notes = "新增菜单信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:add')")
    @Log(title = "菜单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysMenu sysMenu)
    {
        return ResultVOUtil.success(sysMenuService.insertSysMenu(sysMenu));
    }

    /**
     * 修改菜单信息
     *
     *
     * @param sysMenu SysMenuDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改菜单信息表", notes = "修改菜单信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:edit')")
    @Log(title = "菜单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysMenu sysMenu)
    {
        return ResultVOUtil.success(sysMenuService.updateSysMenu(sysMenu));
    }

    /**
     * 删除菜单信息
     *
     *
     * @param menuIds SysMenuIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改菜单信息表", notes = "修改菜单信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:menu:remove')")
    @Log(title = "菜单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{menuIds}")
    public ResultVO remove(@PathVariable Integer[] menuIds)
    {
        return ResultVOUtil.success(sysMenuService.deleteSysMenuByIds(menuIds));
    }
}

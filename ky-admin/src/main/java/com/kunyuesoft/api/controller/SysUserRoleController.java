package com.kunyuesoft.api.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kunyuesoft.model.domain.SysUserRole;
import com.kunyuesoft.service.SysUserRoleService;

import javax.annotation.Resource;


/**
 * 用户角色关系Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "用户角色关系表接口", tags = "用户角色关系表模块")
@RestController
@RequestMapping("/kunyuesoft/role")
public class SysUserRoleController extends BaseController
{
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
    * 查询用户角色关系列表
    *
    *
    * @param sysUserRole SysUserRoleDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询用户角色关系表", notes = "查询用户角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:list')")
    @GetMapping("/list")
    public ResultVO list(SysUserRole sysUserRole)
    {
        startPage();
        List<SysUserRole> list = sysUserRoleService.selectSysUserRoleList(sysUserRole);
        return getDataTable(list);
    }

    /**
     * 获取用户角色关系详细信息
     *
     *
     * @param userId SysUserRoleId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取用户角色关系表", notes = "获取用户角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:query')")
    @GetMapping(value = "/{userId}")
    public ResultVO getInfo(@PathVariable("userId") int userId)
    {
        return ResultVOUtil.success(sysUserRoleService.selectSysUserRoleById(userId));
    }

    /**
     * 新增用户角色关系
     *
     *
     * @param sysUserRole SysUserRoleDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增用户角色关系表", notes = "新增用户角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:add')")
    @Log(title = "用户角色关系", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysUserRole sysUserRole)
    {
        return ResultVOUtil.success(sysUserRoleService.insertSysUserRole(sysUserRole));
    }

    /**
     * 修改用户角色关系
     *
     *
     * @param sysUserRole SysUserRoleDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改用户角色关系表", notes = "修改用户角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:edit')")
    @Log(title = "用户角色关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysUserRole sysUserRole)
    {
        return ResultVOUtil.success(sysUserRoleService.updateSysUserRole(sysUserRole));
    }

    /**
     * 删除用户角色关系
     *
     *
     * @param userIds SysUserRoleIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改用户角色关系表", notes = "修改用户角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:role:remove')")
    @Log(title = "用户角色关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public ResultVO remove(@PathVariable int[] userIds)
    {
        return ResultVOUtil.success(sysUserRoleService.deleteSysUserRoleByIds(userIds));
    }
}

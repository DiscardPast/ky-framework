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
import com.kunyuesoft.model.domain.SysUser;
import com.kunyuesoft.service.SysUserService;

import javax.annotation.Resource;


/**
 * 用户信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "用户信息表接口", tags = "用户信息表模块")
@RestController
@RequestMapping("/kunyuesoft/user")
public class SysUserController extends BaseController
{
    @Resource
    private SysUserService sysUserService;

    /**
    * 查询用户信息列表
    *
    *
    * @param sysUser SysUserDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询用户信息表", notes = "查询用户信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:user:list')")
    @GetMapping("/list")
    public ResultVO list(SysUser sysUser)
    {
        startPage();
        List<SysUser> list = sysUserService.selectSysUserList(sysUser);
        return getDataTable(list);
    }

    /**
     * 获取用户信息详细信息
     *
     *
     * @param userId SysUserId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取用户信息表", notes = "获取用户信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:user:query')")
    @GetMapping(value = "/{userId}")
    public ResultVO getInfo(@PathVariable("userId") Long userId)
    {
        return ResultVOUtil.success(sysUserService.selectSysUserById(userId));
    }

    /**
     * 新增用户信息
     *
     *
     * @param sysUser SysUserDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增用户信息表", notes = "新增用户信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:user:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysUser sysUser)
    {
        return ResultVOUtil.success(sysUserService.insertSysUser(sysUser));
    }

    /**
     * 修改用户信息
     *
     *
     * @param sysUser SysUserDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改用户信息表", notes = "修改用户信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:user:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysUser sysUser)
    {
        return ResultVOUtil.success(sysUserService.updateSysUser(sysUser));
    }

    /**
     * 删除用户信息
     *
     *
     * @param userIds SysUserIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改用户信息表", notes = "修改用户信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:user:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public ResultVO remove(@PathVariable Long[] userIds)
    {
        return ResultVOUtil.success(sysUserService.deleteSysUserByIds(userIds));
    }
}

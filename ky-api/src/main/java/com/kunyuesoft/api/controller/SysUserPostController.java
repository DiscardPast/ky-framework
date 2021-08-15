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
import com.kunyuesoft.model.domain.SysUserPost;
import com.kunyuesoft.service.SysUserPostService;

import javax.annotation.Resource;


/**
 * 用户岗位信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "用户岗位信息表接口", tags = "用户岗位信息表模块")
@RestController
@RequestMapping("/kunyuesoft/post")
public class SysUserPostController extends BaseController
{
    @Resource
    private SysUserPostService sysUserPostService;

    /**
    * 查询用户岗位信息列表
    *
    *
    * @param sysUserPost SysUserPostDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询用户岗位信息表", notes = "查询用户岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:list')")
    @GetMapping("/list")
    public ResultVO list(SysUserPost sysUserPost)
    {
        startPage();
        List<SysUserPost> list = sysUserPostService.selectSysUserPostList(sysUserPost);
        return getDataTable(list);
    }

    /**
     * 获取用户岗位信息详细信息
     *
     *
     * @param userId SysUserPostId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取用户岗位信息表", notes = "获取用户岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:query')")
    @GetMapping(value = "/{userId}")
    public ResultVO getInfo(@PathVariable("userId") String userId)
    {
        return ResultVOUtil.success(sysUserPostService.selectSysUserPostById(userId));
    }

    /**
     * 新增用户岗位信息
     *
     *
     * @param sysUserPost SysUserPostDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增用户岗位信息表", notes = "新增用户岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:add')")
    @Log(title = "用户岗位信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysUserPost sysUserPost)
    {
        return ResultVOUtil.success(sysUserPostService.insertSysUserPost(sysUserPost));
    }

    /**
     * 修改用户岗位信息
     *
     *
     * @param sysUserPost SysUserPostDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改用户岗位信息表", notes = "修改用户岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:edit')")
    @Log(title = "用户岗位信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysUserPost sysUserPost)
    {
        return ResultVOUtil.success(sysUserPostService.updateSysUserPost(sysUserPost));
    }

    /**
     * 删除用户岗位信息
     *
     *
     * @param userIds SysUserPostIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改用户岗位信息表", notes = "修改用户岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:remove')")
    @Log(title = "用户岗位信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public ResultVO remove(@PathVariable String[] userIds)
    {
        return ResultVOUtil.success(sysUserPostService.deleteSysUserPostByIds(userIds));
    }
}

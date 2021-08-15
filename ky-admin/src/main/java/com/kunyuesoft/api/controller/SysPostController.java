package com.kunyuesoft.api.controller;

import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.model.domain.SysPost;
import com.kunyuesoft.service.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 岗位信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "岗位信息表接口", tags = "岗位信息表模块")
@RestController
@RequestMapping("/kunyuesoft/post")
public class SysPostController extends BaseController
{
    @Resource
    private SysPostService sysPostService;

    /**
    * 查询岗位信息列表
    *
    *
    * @param sysPost SysPostDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询岗位信息表", notes = "查询岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:list')")
    @GetMapping("/list")
    public ResultVO list(SysPost sysPost)
    {
        startPage();
        List<SysPost> list = sysPostService.selectSysPostList(sysPost);
        return getDataTable(list);
    }

    /**
     * 获取岗位信息详细信息
     *
     *
     * @param postId SysPostId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取岗位信息表", notes = "获取岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:query')")
    @GetMapping(value = "/{postId}")
    public ResultVO getInfo(@PathVariable("postId") String postId)
    {
        return ResultVOUtil.success(sysPostService.selectSysPostById(postId));
    }

    /**
     * 新增岗位信息
     *
     *
     * @param sysPost SysPostDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增岗位信息表", notes = "新增岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:add')")
    @Log(title = "岗位信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysPost sysPost)
    {
        return ResultVOUtil.success(sysPostService.insertSysPost(sysPost));
    }

    /**
     * 修改岗位信息
     *
     *
     * @param sysPost SysPostDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改岗位信息表", notes = "修改岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:edit')")
    @Log(title = "岗位信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysPost sysPost)
    {
        return ResultVOUtil.success(sysPostService.updateSysPost(sysPost));
    }

    /**
     * 删除岗位信息
     *
     *
     * @param postIds SysPostIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改岗位信息表", notes = "修改岗位信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:post:remove')")
    @Log(title = "岗位信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postIds}")
    public ResultVO remove(@PathVariable String[] postIds)
    {
        return ResultVOUtil.success(sysPostService.deleteSysPostByIds(postIds));
    }
}

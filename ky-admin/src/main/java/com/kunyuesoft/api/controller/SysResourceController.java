package com.kunyuesoft.api.controller;

import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.model.domain.SysResource;
import com.kunyuesoft.service.SysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 资源信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "资源信息表接口", tags = "资源信息表模块")
@RestController
@RequestMapping("/kunyuesoft/resource")
public class SysResourceController extends BaseController
{
    @Resource
    private SysResourceService sysResourceService;

    /**
    * 查询资源信息列表
    *
    *
    * @param sysResource SysResourceDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询资源信息表", notes = "查询资源信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:resource:list')")
    @GetMapping("/list")
    public ResultVO list(SysResource sysResource)
    {
        startPage();
        List<SysResource> list = sysResourceService.selectSysResourceList(sysResource);
        return getDataTable(list);
    }

    /**
     * 获取资源信息详细信息
     *
     *
     * @param resourceId SysResourceId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取资源信息表", notes = "获取资源信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:resource:query')")
    @GetMapping(value = "/{resourceId}")
    public ResultVO getInfo(@PathVariable("resourceId") Long resourceId)
    {
        return ResultVOUtil.success(sysResourceService.selectSysResourceById(resourceId));
    }

    /**
     * 新增资源信息
     *
     *
     * @param sysResource SysResourceDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增资源信息表", notes = "新增资源信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:resource:add')")
    @Log(title = "资源信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysResource sysResource)
    {
        return ResultVOUtil.success(sysResourceService.insertSysResource(sysResource));
    }

    /**
     * 修改资源信息
     *
     *
     * @param sysResource SysResourceDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改资源信息表", notes = "修改资源信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:resource:edit')")
    @Log(title = "资源信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysResource sysResource)
    {
        return ResultVOUtil.success(sysResourceService.updateSysResource(sysResource));
    }

    /**
     * 删除资源信息
     *
     *
     * @param resourceIds SysResourceIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改资源信息表", notes = "修改资源信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:resource:remove')")
    @Log(title = "资源信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{resourceIds}")
    public ResultVO remove(@PathVariable Long[] resourceIds)
    {
        return ResultVOUtil.success(sysResourceService.deleteSysResourceByIds(resourceIds));
    }
}

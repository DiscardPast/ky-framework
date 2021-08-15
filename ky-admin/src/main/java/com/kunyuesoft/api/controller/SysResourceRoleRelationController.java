package com.kunyuesoft.api.controller;

import com.kunyuesoft.api.annotation.Log;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.BusinessType;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.model.domain.SysResourceRoleRelation;
import com.kunyuesoft.service.SysResourceRoleRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 资源角色关系Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "资源角色关系表接口", tags = "资源角色关系表模块")
@RestController
@RequestMapping("/kunyuesoft/relation")
public class SysResourceRoleRelationController extends BaseController
{
    @Resource
    private SysResourceRoleRelationService sysResourceRoleRelationService;

    /**
    * 查询资源角色关系列表
    *
    *
    * @param sysResourceRoleRelation SysResourceRoleRelationDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询资源角色关系表", notes = "查询资源角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:relation:list')")
    @GetMapping("/list")
    public ResultVO list(SysResourceRoleRelation sysResourceRoleRelation)
    {
        startPage();
        List<SysResourceRoleRelation> list = sysResourceRoleRelationService.selectSysResourceRoleRelationList(sysResourceRoleRelation);
        return getDataTable(list);
    }

    /**
     * 获取资源角色关系详细信息
     *
     *
     * @param id SysResourceRoleRelationId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取资源角色关系表", notes = "获取资源角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:relation:query')")
    @GetMapping(value = "/{id}")
    public ResultVO getInfo(@PathVariable("id") Long id)
    {
        return ResultVOUtil.success(sysResourceRoleRelationService.selectSysResourceRoleRelationById(id));
    }

    /**
     * 新增资源角色关系
     *
     *
     * @param sysResourceRoleRelation SysResourceRoleRelationDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增资源角色关系表", notes = "新增资源角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:relation:add')")
    @Log(title = "资源角色关系", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysResourceRoleRelation sysResourceRoleRelation)
    {
        return ResultVOUtil.success(sysResourceRoleRelationService.insertSysResourceRoleRelation(sysResourceRoleRelation));
    }

    /**
     * 修改资源角色关系
     *
     *
     * @param sysResourceRoleRelation SysResourceRoleRelationDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改资源角色关系表", notes = "修改资源角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:relation:edit')")
    @Log(title = "资源角色关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysResourceRoleRelation sysResourceRoleRelation)
    {
        return ResultVOUtil.success(sysResourceRoleRelationService.updateSysResourceRoleRelation(sysResourceRoleRelation));
    }

    /**
     * 删除资源角色关系
     *
     *
     * @param ids SysResourceRoleRelationIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改资源角色关系表", notes = "修改资源角色关系表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:relation:remove')")
    @Log(title = "资源角色关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResultVO remove(@PathVariable Long[] ids)
    {
        return ResultVOUtil.success(sysResourceRoleRelationService.deleteSysResourceRoleRelationByIds(ids));
    }
}

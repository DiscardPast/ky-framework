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
import com.kunyuesoft.model.domain.SysOperLog;
import com.kunyuesoft.service.SysOperLogService;

import javax.annotation.Resource;


/**
 * 操作信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "操作信息表接口", tags = "操作信息表模块")
@RestController
@RequestMapping("/kunyuesoft/log")
public class SysOperLogController extends BaseController
{
    @Resource
    private SysOperLogService sysOperLogService;

    /**
    * 查询操作信息列表
    *
    *
    * @param sysOperLog SysOperLogDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询操作信息表", notes = "查询操作信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:log:list')")
    @GetMapping("/list")
    public ResultVO list(SysOperLog sysOperLog)
    {
        startPage();
        List<SysOperLog> list = sysOperLogService.selectSysOperLogList(sysOperLog);
        return getDataTable(list);
    }

    /**
     * 获取操作信息详细信息
     *
     *
     * @param operId SysOperLogId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取操作信息表", notes = "获取操作信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:log:query')")
    @GetMapping(value = "/{operId}")
    public ResultVO getInfo(@PathVariable("operId") Long operId)
    {
        return ResultVOUtil.success(sysOperLogService.selectSysOperLogById(operId));
    }

    /**
     * 新增操作信息
     *
     *
     * @param sysOperLog SysOperLogDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增操作信息表", notes = "新增操作信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:log:add')")
    @Log(title = "操作信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysOperLog sysOperLog)
    {
        return ResultVOUtil.success(sysOperLogService.insertSysOperLog(sysOperLog));
    }

    /**
     * 修改操作信息
     *
     *
     * @param sysOperLog SysOperLogDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改操作信息表", notes = "修改操作信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:log:edit')")
    @Log(title = "操作信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysOperLog sysOperLog)
    {
        return ResultVOUtil.success(sysOperLogService.updateSysOperLog(sysOperLog));
    }

    /**
     * 删除操作信息
     *
     *
     * @param operIds SysOperLogIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改操作信息表", notes = "修改操作信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:log:remove')")
    @Log(title = "操作信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{operIds}")
    public ResultVO remove(@PathVariable Long[] operIds)
    {
        return ResultVOUtil.success(sysOperLogService.deleteSysOperLogByIds(operIds));
    }
}

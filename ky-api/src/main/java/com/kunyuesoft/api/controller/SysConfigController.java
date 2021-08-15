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
import com.kunyuesoft.model.domain.SysConfig;
import com.kunyuesoft.service.SysConfigService;

import javax.annotation.Resource;


/**
 * 配置信息Controller
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Api(value = "配置信息表接口", tags = "配置信息表模块")
@RestController
@RequestMapping("/kunyuesoft/config")
public class SysConfigController extends BaseController
{
    @Resource
    private SysConfigService sysConfigService;

    /**
    * 查询配置信息列表
    *
    *
    * @param sysConfig SysConfigDomain
    * @return ResultVO 返回统一结果model
    */
    @ApiOperation(value = "查询配置信息表", notes = "查询配置信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:config:list')")
    @GetMapping("/list")
    public ResultVO list(SysConfig sysConfig)
    {
        startPage();
        List<SysConfig> list = sysConfigService.selectSysConfigList(sysConfig);
        return getDataTable(list);
    }

    /**
     * 获取配置信息详细信息
     *
     *
     * @param configId SysConfigId
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "获取配置信息表", notes = "获取配置信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:config:query')")
    @GetMapping(value = "/{configId}")
    public ResultVO getInfo(@PathVariable("configId") Long configId)
    {
        return ResultVOUtil.success(sysConfigService.selectSysConfigById(configId));
    }

    /**
     * 新增配置信息
     *
     *
     * @param sysConfig SysConfigDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "新增配置信息表", notes = "新增配置信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:config:add')")
    @Log(title = "配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResultVO add(@RequestBody SysConfig sysConfig)
    {
        return ResultVOUtil.success(sysConfigService.insertSysConfig(sysConfig));
    }

    /**
     * 修改配置信息
     *
     *
     * @param sysConfig SysConfigDomain
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改配置信息表", notes = "修改配置信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:config:edit')")
    @Log(title = "配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResultVO edit(@RequestBody SysConfig sysConfig)
    {
        return ResultVOUtil.success(sysConfigService.updateSysConfig(sysConfig));
    }

    /**
     * 删除配置信息
     *
     *
     * @param configIds SysConfigIds
     * @return ResultVO 返回统一结果model
     */
    @ApiOperation(value = "修改配置信息表", notes = "修改配置信息表", response = ResultVO.class)
    @PreAuthorize("@ss.hasPermi('kunyuesoft:config:remove')")
    @Log(title = "配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{configIds}")
    public ResultVO remove(@PathVariable Long[] configIds)
    {
        return ResultVOUtil.success(sysConfigService.deleteSysConfigByIds(configIds));
    }
}

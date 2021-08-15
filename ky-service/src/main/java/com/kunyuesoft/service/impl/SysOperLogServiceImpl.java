package com.kunyuesoft.service.impl;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kunyuesoft.dao.mapper.SysOperLogMapper;
import com.kunyuesoft.model.domain.SysOperLog;
import com.kunyuesoft.service.SysOperLogService;

/**
 * 操作信息Service业务层处理
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Service
public class SysOperLogServiceImpl implements SysOperLogService
{
    @Resource
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 查询操作信息
     * 
     * @param operId 操作信息ID
     * @return 操作信息
     */
    @Override
    public SysOperLog selectSysOperLogById(Long operId)
    {
        return sysOperLogMapper.selectSysOperLogById(operId);
    }

    /**
     * 查询操作信息列表
     * 
     * @param sysOperLog 操作信息
     * @return 操作信息
     */
    @Override
    public List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog)
    {
        return sysOperLogMapper.selectSysOperLogList(sysOperLog);
    }

    /**
     * 新增操作信息
     * 
     * @param sysOperLog 操作信息
     * @return 执行结果
     */
    @Override
    public int insertSysOperLog(SysOperLog sysOperLog)
    {
        return sysOperLogMapper.insertSysOperLog(sysOperLog);
    }

    /**
     * 修改操作信息
     * 
     * @param sysOperLog 操作信息
     * @return 执行结果
     */
    @Override
    public int updateSysOperLog(SysOperLog sysOperLog)
    {
        return sysOperLogMapper.updateSysOperLog(sysOperLog);
    }

    /**
     * 批量删除操作信息
     * 
     * @param operIds 需要删除的操作信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysOperLogByIds(Long[] operIds)
    {
        return sysOperLogMapper.deleteSysOperLogByIds(operIds);
    }

    /**
     * 删除操作信息信息
     * 
     * @param operId 操作信息ID
     * @return 执行结果
     */
    @Override
    public int deleteSysOperLogById(Long operId)
    {
        return sysOperLogMapper.deleteSysOperLogById(operId);
    }
}

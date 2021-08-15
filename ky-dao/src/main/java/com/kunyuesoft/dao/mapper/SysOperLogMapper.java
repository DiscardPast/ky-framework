package com.kunyuesoft.dao.mapper;

import java.util.List;
import com.kunyuesoft.model.domain.SysOperLog;

/**
 * 操作信息Mapper接口
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
public interface SysOperLogMapper 
{
    /**
     * 查询操作信息
     * 
     * @param operId 操作信息ID
     * @return 操作信息
     */
    public SysOperLog selectSysOperLogById(Long operId);

    /**
     * 查询操作信息列表
     * 
     * @param sysOperLog 操作信息
     * @return 操作信息集合
     */
    public List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog);

    /**
     * 新增操作信息
     * 
     * @param sysOperLog 操作信息
     * @return 执行结果
     */
    public int insertSysOperLog(SysOperLog sysOperLog);

    /**
     * 修改操作信息
     * 
     * @param sysOperLog 操作信息
     * @return 执行结果
     */
    public int updateSysOperLog(SysOperLog sysOperLog);

    /**
     * 删除操作信息
     * 
     * @param operId 操作信息ID
     * @return 执行结果
     */
    public int deleteSysOperLogById(Long operId);

    /**
     * 批量删除操作信息
     * 
     * @param operIds 需要删除的数据ID
     * @return 执行结果
     */
    public int deleteSysOperLogByIds(Long[] operIds);
}

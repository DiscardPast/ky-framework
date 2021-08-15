package com.kunyuesoft.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.utils.SqlUtil;
import com.kunyuesoft.common.utils.StringUtils;
import com.kunyuesoft.model.dtos.admin.base.PageDomain;
import com.kunyuesoft.model.dtos.admin.base.TableDataInfo;
import com.kunyuesoft.model.dtos.admin.base.TableSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * web层通用数据处理
 * 
 * @author kunyuesoft
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected ResultVO getDataTable(List<?> list)
    {
        ResultVO result = new ResultVO();
        TableDataInfo rspData = new TableDataInfo();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMessage());
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        result.setData(rspData);
        return result;
    }
}

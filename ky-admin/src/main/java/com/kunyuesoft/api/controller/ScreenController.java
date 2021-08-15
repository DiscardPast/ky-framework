package com.kunyuesoft.api.controller;


import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.model.dtos.admin.vo.ScreenImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开屏图片操作处理
 * 
 * @author kunyuesoft
 */
@RefreshScope
@RestController
public class ScreenController
{
    @Value("${screen.url}")
    private String screenUrl;

    @Value("${screen.isShow}")
    private Integer isShow;

    /**
     * 获取开屏图片地址
     */
    @RequestMapping("/getScreenImage")
    public ResultVO getScreenImage()
    {
        ScreenImageVO screenImageVO = new ScreenImageVO();
        screenImageVO.setScreenUrl(screenUrl);
        screenImageVO.setIsShow(isShow);
        return ResultVOUtil.success(screenImageVO);
    }
}

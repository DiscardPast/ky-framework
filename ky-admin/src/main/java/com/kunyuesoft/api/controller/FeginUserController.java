package com.kunyuesoft.api.controller;

import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.fegin.erp.UserCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("fegin/user")
public class FeginUserController {

    @Resource
    private UserCenter userCenter;


    @Value("${tongchuang.erp.companyid}")
    private String comid;

    @GetMapping("/list")
    public ResultVO list() {
        return userCenter.getCompEmpInfoList(comid);
    }
}

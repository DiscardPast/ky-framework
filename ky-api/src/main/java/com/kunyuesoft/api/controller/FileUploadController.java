package com.kunyuesoft.api.controller;

import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.utils.FileUploadService;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.common.utils.StringUtils;
import com.kunyuesoft.model.dtos.admin.base.FileBase64DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("file")
public class FileUploadController {

    @Resource
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResultVO upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return ResultVOUtil.fail(ResultEnum.PARAM_FILE_IS_NOT_NULL);
        }
        String url = fileUploadService.upload(file);
        return ResultVOUtil.success(url);
    }
    
    @PostMapping("/uploadByBase64")
    public ResultVO uploadByBase64(@RequestBody FileBase64DTO base64DTO) throws Exception {
        if (StringUtils.isEmpty(base64DTO.getFile())) {
            return ResultVOUtil.fail(ResultEnum.PARAM_FILE_IS_NOT_NULL);
        }
        if (StringUtils.isEmpty(base64DTO.getFileName())) {
            return ResultVOUtil.fail(ResultEnum.PARAM_FILE_NAME_IS_NOT_NULL);
        }
        String url = fileUploadService.uploadByBase64(base64DTO.getFile(),base64DTO.getFileName());
        return ResultVOUtil.success(url);
    }
}

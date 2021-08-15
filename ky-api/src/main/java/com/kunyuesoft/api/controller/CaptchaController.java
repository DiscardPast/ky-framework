package com.kunyuesoft.api.controller;


import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.constatnts.Constants;
import com.kunyuesoft.common.redis.RedisCache;
import com.kunyuesoft.common.utils.IdUtils;
import com.kunyuesoft.common.utils.ResultVOUtil;
import com.kunyuesoft.common.utils.VerifyCodeUtils;
import com.kunyuesoft.model.dtos.admin.vo.CaptchaVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * 验证码操作处理
 * 
 * @author kunyuesoft
 */
@RestController
public class CaptchaController
{
    @Autowired
    private RedisCache redisCache;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public ResultVO getCode(HttpServletResponse response) throws IOException
    {
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 唯一标识
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        //redisCache.setCacheObject(verifyKey, verifyCode, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 生成图片
        int w = 111, h = 36;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, stream, verifyCode);
        return ResultVOUtil.success(convertToCaptchaVO(uuid,Base64.getEncoder().encodeToString(stream.toByteArray())));
    }

    private CaptchaVO convertToCaptchaVO(String uuid, String img){
        CaptchaVO vo = new CaptchaVO();
        vo.setUuid(uuid);
        vo.setImg(img);
        return vo;
    }
}

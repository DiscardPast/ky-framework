package com.kunyuesoft.common.utils;


import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.exception.BtsException;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class FileUploadService {

    @Value("${minio.endpoint}")
    public String endpoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.domain}")
    private String domain;

    private static MinioClient client;

    @PostConstruct
    private void init() throws Exception {
        client = new MinioClient(endpoint, accessKey, secretKey);
        // 检查存储桶是否已经存在
        boolean isExist = client.bucketExists(bucketName);
        if(!isExist) {
            client.makeBucket(bucketName);
        }
    }

    public String upload(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return upload(file.getBytes(), getPath("") + "." + prefix);
    }

    public String uploadByBase64(String base64,String fileName) throws Exception {
        byte[] bytes = new BASE64Decoder().decodeBuffer(base64.trim());
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return upload(bytes, getPath("") + "." + prefix);
    }

    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    public String upload(InputStream inputStream, String path) {
        try {
            client.putObject(bucketName, path, inputStream,"application/octet-stream");
        } catch (Exception e) {
            log.error("上传文件失败，请检查配置信息:{}",e);
            throw new BtsException(ResultEnum.IS_ERROR.getCode(),"文件上传失败");
        }
        return domain + "/" + path;
    }


    /**
     * 文件路径
     *
     * @param prefix 前缀
     * @return 返回上传路径
     */
    public String getPath(String prefix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        String path = DateUtils.format(new Date(), "yyyyMMdd") + "/" + DateUtils.format(new Date(), "HHmmssS") + uuid.substring(0, 5);

        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }
        return path;
    }
}

package com.liurq.server.controller.system;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.util.IDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @Author:hyz
 * @Date:2021-04-16
 * @Desc:
 **/
@RestController
@RequestMapping("/server/file")
@Api(description = "登录控制器")
public class FileController {

    /**
     * 上传文件到oss
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ApiOperation(value = "上传文件到oss",notes = "上传文件到oss")
    public RspInfo<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "123";
        String accessKeySecret = "123";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String oldName = file.getOriginalFilename();
        String fileName = IDUtils.genId()+oldName.substring(oldName.lastIndexOf("."));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateArr = simpleDateFormat.format(new Date()).split("-");
        String imgPath="head-image/"+dateArr[0]+"/"+dateArr[1]+"/"+dateArr[2]+"/"+fileName;
        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
        PutObjectResult result = ossClient.putObject("hospital-head-image", imgPath, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
        return RspInfo.success("https://hospital-head-image.oss-cn-beijing.aliyuncs.com/"+imgPath);
    }

}

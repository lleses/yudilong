package com.dl.modules.demo.controller;

import com.dl.comm.utils.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 上传文件
 *
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    // 文件上传后的路径
    @Value("${dc.filePath}")
    private String FILE_PATH;
    @Value("${dc.fileUrlPath}")
    private String FILE_URL_PATH;

    /** 上传图片 **/
    @RequestMapping("img")
    public String img(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();// 获取文件名
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));// 获取文件的后缀名
        fileName = IdUtil.id32() + fileSuffix;
        File dest = new File(FILE_PATH + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return FILE_URL_PATH + fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

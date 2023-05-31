package org.czcy.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;

/**
 * 通用请求处理
 * 
 * @author cy
 */
@RestController
@RequestMapping("/common")
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     */
    @GetMapping("/download")
    public void fileDownload(@RequestParam(value = "filename") String fileName, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            String filePath = "D:\\ctsi\\" + fileName;
            File file = new File(filePath);
            FileInputStream stream = new FileInputStream(file);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            //FileUtils.setAttachmentResponseHeader(response, fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(stream, response.getOutputStream());
            //FileUtils.writeBytes(filePath, response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }
}

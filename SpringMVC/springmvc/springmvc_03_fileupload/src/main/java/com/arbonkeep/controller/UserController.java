package com.arbonkeep.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author arbonkeep
 * @date 2019/12/4 - 17:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 传统方式文件上传
     * @return
     */
    @RequestMapping("/fileController1")
    public String fileContoller1(HttpServletRequest request) throws Exception {
        System.out.println("fileController1方法执行了。。。");

        //使用fileupload组件完成文件的上传
        //指定文件上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //不存在，就创建
            file.mkdirs();
        }
        //解析request对象，获取文件上传项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            //判断当前item对象是否为一个文件上传对象
            if(item.isFormField()) {
                //说明是一个普通文件
            }else {
                //是一个上传文件
                //获取上传文件名
                String fileName = item.getName();
                //将文件名设置为唯一值，UUID
                String s = UUID.randomUUID().toString().replace("-", "");
                fileName= s + "_" + fileName;
                //完成上传
                item.write(new File(path,fileName));
                //清除临时文件
                item.delete();
            }
        }

        return "success";
    }

    /**
     * 使用springmvc方式上传文件
     * @param request
     * @param upload
     * @return
     */
    @RequestMapping("/fileController2")
    public String fileController2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc方式上传文件。。。");
        //指定文件上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断文件路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //说明文件不存在，创建
            file.mkdirs();
        }
        //获取上传文件项的名称
        String filename = upload.getOriginalFilename();
        //将文件名设置为唯一值
        String s = UUID.randomUUID().toString().replace("-", "");
        filename = s + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));


        return "success";

    }

    /**
     * 跨服务器上传文件
     * @param upload
     * @return
     */
    @RequestMapping("/fileController3")
    public String fileController3(MultipartFile upload) throws IOException {
        System.out.println("跨服务器上传文件");
        //定义需要上传的服务器的路径
        String path = "http://localhost:8088/uploads/";//这里加上/后面拼接时不需要加
        //如果file不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //将文件名设置为唯一值
        String s = UUID.randomUUID().toString().replace("-", "");
        fileName = s + "_" + fileName;
        //完成跨服务器上传
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器连接
        WebResource webResource = client.resource(path + fileName);
        //上传
        webResource.put(upload.getBytes());


        return "success";
    }
}

package com.zq.controller;

import com.zq.entity.MyFile;
import com.zq.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhaoqi
 * @version 1.8
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("upload")
    public String upload(MultipartFile aa, HttpServletRequest request) throws IOException {
//        获得相对于服务器的存储路径
        String path1 = request.getSession().getServletContext().getRealPath("/files");
//        每天一个文件夹
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String path2="/files/"+format;
//        路径
//        判断文件是否存在
        File file = new File(path1,format);
        if (!file.exists()) file.mkdirs();
//        给名字命名
        String oldName = aa.getOriginalFilename();
//        新名字前缀
        String prefixName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + UUID.randomUUID().toString();
        String end = oldName.substring(oldName.lastIndexOf("."));
        String newName = prefixName+end;
        Long sizes = aa.getSize();
        String type = aa.getContentType();
//      判断是否是图片
        String isPic = "false";
        if (end.equals(".jpj")||end.equals(".jpeg")||end.equals(".png")||end.equals(".gif")){
            isPic="true";
        }
        fileService.insert(new MyFile(
                UUID.randomUUID().toString(),oldName,newName,end,path2,sizes,type,isPic,0
        ));
        aa.transferTo(new File(file,newName));
        return "redirect:/file/selectAll";
    }

    @RequestMapping("download")
    public void download(String newName,String type,HttpServletRequest request, HttpServletResponse response) throws Exception {
        MyFile myFile = fileService.selectByName(newName);
        String path = myFile.getPath();
        if (type.equals("inline")) {
            response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode(myFile.getNewName(), "utf-8"));
        }else {
            fileService.update(new MyFile().setNewName(newName));
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(myFile.getNewName(), "utf-8"));
        }
        String realPath = request.getSession().getServletContext().getRealPath(path);
        FileInputStream in = new FileInputStream(new File(realPath,newName));
        ServletOutputStream out = response.getOutputStream();

        IOUtils.copy(in,out);
        IOUtils.closeQuietly(in);
        IOUtils.closeQuietly(out);
    }

    @ResponseBody
    @RequestMapping("update")
    public  Integer update(){
        return null;
    }


    @RequestMapping("selectAll")
    public String selectAll(HttpServletRequest request){
        List<MyFile> myFiles = fileService.selectAll();
        request.setAttribute("myFile",myFiles);
        return  "main";
    }

    @RequestMapping("delete")
    public String delete(String newName,String path,HttpServletRequest request){
        String path1 = request.getSession().getServletContext().getRealPath(path);
        File file =new File(path1,newName);
        file.delete();
        fileService.delete(newName);
        return "redirect:/file/selectAll";
    }
}

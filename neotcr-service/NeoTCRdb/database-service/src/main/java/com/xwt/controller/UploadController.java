package com.xwt.controller;

import com.jcraft.jsch.SftpException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xwt.service.FileService;
import com.xwt.thrift.ServiceProvider;
import com.xwt.thrift.browse.BrowseService;
import com.xwt.thrift.browse.CDR3TCR;
import com.xwt.thrift.browse.McPAS;
import com.xwt.thrift.browse.NeoTCR;
import com.xwt.utils.FtpUtils;
import com.xwt.vo.FileVO;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping(value = "/service/upload")
public class UploadController {
    @Autowired
    FileService fileService;
    @Autowired
    FtpUtils ftpUtils;
    @Resource
    private ServiceProvider serviceProvider;

    @PostMapping("/file")
    public FileVO upload(@RequestParam("file")MultipartFile file){
        System.out.println("上传文件");
        try {
            byte[] bytes=file.getBytes();
            ftpUtils.login();
            FileVO res=ftpUtils.upload(bytes,file.getOriginalFilename());
            ftpUtils.logout();
            return res;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/txtfile")
    public String uploadTXT(@RequestParam("file")MultipartFile file){
        System.out.println("上传txt文件");
        try {
            byte[] bytes=file.getBytes();
            ftpUtils.login();
            String res=ftpUtils.uploadTXT(bytes,file.getOriginalFilename());
            ftpUtils.logout();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/transfile")
    public FileVO fileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        System.out.println();
        String uuid= UUID.randomUUID().toString().replace("-","");
        String originalFilename = file.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("fileType"+fileType);
        if(fileType.equals(".txt")){
            String virtualName=uuid+".txt";
            String path="/root/store/txt/"+virtualName;
            File newfile = new File(path);
            file.transferTo(newfile);
            return new FileVO("/root/store/txt/",virtualName);
        }
        if(fileType.equals(".gz")){
            String virtualName=uuid+".fastq.gz";
            String path="/root/store/temp/"+virtualName;
            File newfile = new File(path);
            file.transferTo(newfile);
            return new FileVO("/root/store/temp/",virtualName);
        }
        if(fileType.equals(".fastq")){
            String virtualName=uuid+".fastq";
            String path="/root/store/temp/"+virtualName;
            File newfile = new File(path);
            file.transferTo(newfile);
            return new FileVO("/root/store/temp/",virtualName);
        }
        else {
            return null;
        }
    }

    @RequestMapping("/uploadtxtfile")
    public FileVO uploadTXTFile(@RequestParam("file")MultipartFile file) throws IOException {
        System.out.println("uploadtxtfile");
        String uuid= UUID.randomUUID().toString().replace("-","");
        String virtualName=uuid+".txt";
        String path="/root/store/txt/"+virtualName;
        File newfile = new File(path);
        file.transferTo(newfile);
        return new FileVO("/root/store/txt/",virtualName);
    }


    @RequestMapping("/searchtxtneo")
    public List<NeoTCR> searchTXTNeo(@RequestParam("str")String str){
        System.out.println("txt文件查找");
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<NeoTCR> tcrList;
        try {
            System.out.println(str);
            tcrList = browseService.getNeo(Arrays.asList(str.split("\r\n")));
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/searchtxtvdj")
    public List<CDR3TCR> searchTXTVDJ(@RequestParam("str")String str){
        System.out.println("txt文件查找");
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<CDR3TCR> tcrList;
        try {
            tcrList = browseService.getCDR3TCR(Arrays.asList(str.split("\r\n")));
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/searchtxtmcpas")
    public List<McPAS> searchTXTMcPAS(@RequestParam("str")String str){
        System.out.println("txt文件查找");
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<McPAS> tcrList;
        try {
            tcrList = browseService.getMcPAS(Arrays.asList(str.split("\r\n")));
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/deleteFile",method = RequestMethod.POST)
    public Boolean delFile(@RequestParam("fileName")String fileName){
        System.out.println("删除文件");
        try {
            ftpUtils.login();
            return ftpUtils.delete(fileName);
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return false;
    }
    @RequestMapping("/download")
    public String fileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName){
        System.out.println(fileName);
        System.out.println(Arrays.toString(fileName.split("\\.")));
        String downloadFilePath="/root/store/temp"+'/'+fileName.split("\\.")[0];
        File file = new File(downloadFilePath  +"/full_clones.txt");
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }

}

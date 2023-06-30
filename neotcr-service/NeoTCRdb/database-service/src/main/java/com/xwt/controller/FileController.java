package com.xwt.controller;

import com.jcraft.jsch.SftpException;
import com.xwt.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/service/file")
public class FileController {
    @Autowired
    private FtpUtils ftpUtils;
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
}

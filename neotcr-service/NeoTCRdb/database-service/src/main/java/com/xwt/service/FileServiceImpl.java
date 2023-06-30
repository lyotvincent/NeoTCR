package com.xwt.service;

import com.xwt.vo.FileVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    @Value("${web.upload-path}")
    private String localUrlPath;


    @Override
    public FileVO upload(MultipartFile file) throws IOException {
        String localDir = localUrlPath;
        File dirFile = new File(localDir);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileType = ".fastq.gz";
        String realFileName = uuid+fileType;
        String filePathAll = localDir+realFileName;
        File realFile = new File(filePathAll);
        file.transferTo(realFile);
        String virtualPath = "/"+realFileName;
        System.out.println(virtualPath+realFileName);
        return new FileVO(virtualPath,realFileName);
    }
}

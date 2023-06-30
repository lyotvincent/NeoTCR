package com.xwt.service;

import com.xwt.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public FileVO upload(MultipartFile file) throws IOException;
}

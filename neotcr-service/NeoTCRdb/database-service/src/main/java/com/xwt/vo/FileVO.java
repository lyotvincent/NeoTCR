package com.xwt.vo;


public class FileVO {
    private String virtualPath;
    private String fileName;

    public FileVO() {
    }

    public FileVO(String virtualPath, String fileName) {
        this.virtualPath = virtualPath;
        this.fileName = fileName;
    }

    public String getVirtualPath() {
        return virtualPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setVirtualPath(String virtualPath) {
        this.virtualPath = virtualPath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileVO{" +
                "virtualPath='" + virtualPath + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}

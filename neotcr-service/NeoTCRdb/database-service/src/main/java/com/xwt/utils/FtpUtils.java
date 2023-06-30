package com.xwt.utils;

import com.jcraft.jsch.*;
import com.xwt.vo.FileVO;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FtpUtils {

    @Value("${web.ftp-centos.ip}")
    private String host;



    @Value("${web.ftp-centos.port}")
    private int port;


    @Value("${web.ftp-centos.user}")
    private String user;


    @Value("${web.ftp-centos.password}")
    private String password;


    @Value("${web.upload-path}")
    private String basePath;

    @Value("${web.upload-txt-path}")
    private String baseTXTPath;

    private ChannelSftp sftp;

    private Session session;

    public FtpUtils() { }

    public void login(){
        try {
            JSch jsch = new JSch();
            if (port<= 0) {
                session = jsch.getSession(user, host);
            } else {
                session = jsch.getSession(user, host, port);
            }
            if (session == null) {
                throw new Exception("session is null");
            }
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("session");
            session.connect(300000);
            OutputStream outstream = null;
            Channel channel = (Channel) session.openChannel("sftp");
            channel.connect(10000);
            sftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(){
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

    public FileVO upload(byte[] bytes, String fileName) throws IOException {
        OutputStream outstream = null;
        try{
            sftp.cd(basePath);
            String uuid= UUID.randomUUID().toString().replace("-","");
            String virtualName=uuid+".fastq.gz";

            outstream = sftp.put(virtualName);
            outstream.write(bytes);
            return new FileVO(basePath,virtualName);
        } catch (SftpException | IOException e) {
            e.printStackTrace();
        }finally {
            if (outstream != null) {
                outstream.flush();
                outstream.close();
            }
        }
        return null;
    }

    public String uploadTXT(byte[] bytes, String fileName) throws IOException {
        try {
            String js=new String(bytes);
            return js;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }

    public String readTXT(String fileName) throws SftpException, IOException {
            sftp.cd(baseTXTPath);
            InputStream file=sftp.get(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            StringBuilder sb = new StringBuilder();
            String temp = "";
            while (((temp=br.readLine())!=null)){
                sb.append(temp+"\n");
            }
            br.close();
            String js = sb.toString();
            sftp.rm(fileName);
            return js;
    }

    public boolean delete(String fileName) throws SftpException {
        if (isExist(fileName)){
            sftp.cd(basePath);
            sftp.rm(fileName);
            return true;
        }
        return false;
    }

    public boolean isExist(String fileName) throws SftpException {
        boolean flag = false;
        try {
            sftp.stat(basePath+fileName);
            flag = true;
        }
        catch (SftpException e){
            if (e.id == ChannelSftp.SSH_FX_NO_SUCH_FILE){
                flag = false;
            }
        }
        return flag;
    }

    public boolean download(String fileName,String saveFile) {
        try {
            sftp.cd(basePath);
            File file=new File(saveFile);
            sftp.get(fileName,new FileOutputStream(file));
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return false;
    }
    public byte[] downFile(String directory,String fileName) {
        try {
            sftp.cd(directory);
            InputStream is = sftp.get(fileName);

            byte[] fileData = IOUtils.toByteArray(is);

            return fileData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
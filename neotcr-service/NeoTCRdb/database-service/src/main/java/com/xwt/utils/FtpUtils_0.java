package com.xwt.utils;


import com.jcraft.jsch.*;
import com.xwt.vo.FileVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.UUID;

@Service
public class FtpUtils_0 {

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

    public FileVO sshSftp(byte[] bytes, String fileName) throws Exception {
        Session session = null;
        Channel channel = null;
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
        try {
            channel = (Channel) session.openChannel("sftp");
            channel.connect(10000);
            ChannelSftp sftp = (ChannelSftp) channel;
            sftp.cd(basePath);
            String uuid= UUID.randomUUID().toString().replace("-","");
            String virtualName=uuid+".fastq.gz";
            outstream = sftp.put(virtualName);
            outstream.write(bytes);
            return new FileVO(basePath,virtualName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outstream != null) {
                outstream.flush();
                outstream.close();
            }
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
        return null;
    }

}
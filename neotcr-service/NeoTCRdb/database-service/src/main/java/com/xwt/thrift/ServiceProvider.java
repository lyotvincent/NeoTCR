package com.xwt.thrift;

import com.xwt.thrift.analyse.AnalyseService;
import com.xwt.thrift.browse.BrowseService;
import com.xwt.thrift.view.ViewService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceProvider {
    @Value("${thrift.browse.ip}")
    private String serverIp;
    @Value("${thrift.browse.port}")
    private int serverPort;

    @Value("${thrift.analyse.ip}")
    private String analyseIP;

    @Value("${thrift.analyse.port}")
    private int analysePort;

    @Value("${thrift.view.ip}")
    private String viewIP;

    @Value("${thrift.view.port}")
    private int viewPort;


    private enum ServiceType{
        BROWSE,
        ANALYSE,
        VIEW
    }

    public <T> T getService(String ip, int port, ServiceType serviceType){
        TSocket socket = new TSocket(ip, port, 1000*60*20);

        TTransport transport = new TFramedTransport(socket);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        TServiceClient result=null;
        switch (serviceType){
            case BROWSE:
                result = new BrowseService.Client(protocol);
                break;
            case ANALYSE:
                result = new AnalyseService.Client(protocol);
                break;
            case VIEW:
                result = new ViewService.Client(protocol);
                break;
        }

        return (T)result;
    }
    
    public BrowseService.Client getBrowseService(){
        return getService(serverIp, serverPort, ServiceType.BROWSE);
    }
    public AnalyseService.Client getAnalyseService(){
        return getService(analyseIP,analysePort,ServiceType.ANALYSE);
    }
    public ViewService.Client getViewService(){
        return getService(viewIP,viewPort,ServiceType.VIEW);
    }

}

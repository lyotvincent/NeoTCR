package com.xwt.browse.thrift;

import com.xwt.thrift.browse.BrowseService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class ThriftServer {

    @Value("7911")
    private int servicePort;

    @Resource
    private BrowseService.Iface browseService;

    @PostConstruct
    public void startThriftServer(){
        TNonblockingServerSocket serverSocker = null;
        try {
            serverSocker = new TNonblockingServerSocket(servicePort);
        } catch (TTransportException e) {
            e.printStackTrace();
            return;
        }
        TFramedTransport.Factory transportFactory = new TFramedTransport.Factory();

        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();

        TProcessor processor = new BrowseService.Processor<>(browseService);

        TNonblockingServer.Args args = new TNonblockingServer.Args(serverSocker);
        args.transportFactory(transportFactory);
        args.protocolFactory(protocolFactory);
        args.processor(processor);
        TServer server = new TNonblockingServer(args);

        System.out.println("UserService Thrift Server starting...");
        server.serve();
        System.out.println("UserService Thrift Server stoped.");

    }
}

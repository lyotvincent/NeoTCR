package com.xwt.browse.service;

import com.xwt.browse.mapper.DataMapper;
import com.xwt.thrift.browse.BrowseService;
import com.xwt.thrift.browse.CDR3TCR;
import com.xwt.thrift.browse.McPAS;
import com.xwt.thrift.browse.NeoTCR;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService.Iface {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<NeoTCR> getAllTCR() throws TException {
        System.out.println("getall");
        return dataMapper.getAllTCR();
    }

    @Override
    public List<NeoTCR> getTCRStr(String selectStr) throws TException {
        System.out.println("getTCRStr");
        return dataMapper.getTCRStr(selectStr);
    }

    @Override
    public List<NeoTCR> getTCR(List<String> antigen, List<String> aminoAcidExchange, List<String> hlaAllele, List<String> traCDR3, List<String> trav, List<String> traj, List<String> trbCDR3, List<String> trbv, List<String> trbj, List<String> tumor) throws TException {
        System.out.println("getTCR");
        return dataMapper.getTCR(antigen,aminoAcidExchange,hlaAllele,traCDR3,trav,traj,trbCDR3,trbv,trbj,tumor);
    }


    @Override
    public List<NeoTCR> getNeo(List<String> cdrs) throws TException {
        System.out.println("get neo");
        return dataMapper.getNeo(cdrs);
    }

    @Override
    public List<CDR3TCR> getCDR3TCR(List<String> cdrs) throws TException {
        System.out.println("get vdj");
        return dataMapper.getCDR3TCR(cdrs);
    }

    @Override
    public List<McPAS> getMcPAS(List<String> cdrs) throws TException {
        System.out.println("get mcpas");
        return dataMapper.getMcPAS(cdrs);
    }


}

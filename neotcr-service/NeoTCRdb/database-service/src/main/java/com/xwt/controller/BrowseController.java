package com.xwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwt.thrift.ServiceProvider;
import com.xwt.thrift.browse.BrowseService;
import com.xwt.thrift.browse.CDR3TCR;
import com.xwt.thrift.browse.McPAS;
import com.xwt.thrift.browse.NeoTCR;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/service/browse")
public class BrowseController {
    @Resource
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/getAllTCR",method = RequestMethod.GET)
    public List<NeoTCR> getAllTCR(){
        System.out.println("getalltcr");
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<NeoTCR> tcrList;
        try {
            tcrList = browseService.getAllTCR();
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getTheTCR",method = RequestMethod.POST)
    @ResponseBody
    public List<NeoTCR> getTheTCR(@RequestParam("antigen") List<String> antigen,
                                  @RequestParam("aminoAcidExchange") List<String> aminoAcidExchange,
                                  @RequestParam("hlaAllele") List<String> hlaAllele,
                                  @RequestParam("traCDR3") List<String> traCDR3,
                                  @RequestParam("trav") List<String> trav,
                                  @RequestParam("traj") List<String> traj,
                                  @RequestParam("trbCDR3") List<String> trbCDR3,
                                  @RequestParam("trbv") List<String> trbv,
                                  @RequestParam("trbj") List<String> trbj,
                                  @RequestParam("tumor") List<String> tumor){
        System.out.println("getTheTCR");
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<NeoTCR> tcrList;
        try{
            tcrList=browseService.getTCR(antigen,aminoAcidExchange,hlaAllele,traCDR3,trav,traj,trbCDR3,trbv,trbj,tumor);
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getNeo",method = RequestMethod.GET)
    public List<NeoTCR> getNeo(@RequestParam("cdrs") String cdrs){
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<NeoTCR> tcrList;
        try {
            tcrList = browseService.getNeo(Arrays.asList(cdrs.split("\n")));
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getCDR3TCR",method = RequestMethod.GET)
    public List<CDR3TCR> getCDR3TCR(@RequestParam("cdrs") String cdrs){
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<CDR3TCR> tcrList;
        try {
            tcrList = browseService.getCDR3TCR(Arrays.asList(cdrs.split("\n")));
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getMcPAS",method = RequestMethod.GET)
    public List<McPAS> getMcPAS(@RequestParam("cdrs") String cdrs){
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        List<McPAS> tcrList;
        try{
            tcrList = browseService.getMcPAS(Arrays.asList(cdrs.split("\n")));
            return tcrList;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getAllCDR3",method = RequestMethod.GET)
    public String getAllCDR3(@RequestParam("cdrMap")String cdrMap) throws TException {
        BrowseService.Iface browseService = serviceProvider.getBrowseService();
        JSONObject jsonObject = JSONObject.parseObject(cdrMap);
        Map map = (Map)jsonObject;
        Map<String,List<NeoTCR>> jsonMap1 = new HashMap<String,List<NeoTCR>>();
        Map<String,List<CDR3TCR>> jsonMap2 = new HashMap<String, List<CDR3TCR>>();
        JSONObject answer=new JSONObject(true);
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key;
            String value;
            key = iter.next().toString();
            value= (String) map.get(key);
            System.out.println(key+"--"+value);
            jsonMap1.put(key,browseService.getTCRStr("select * from neoTCR where traCDR3='"+value+"' or trbCDR3='"+value+"'"));
        }
        answer.put("neotcrdb",jsonMap1);
        answer.put("vdjdb",jsonMap2);
        return answer.toString();
    }
}

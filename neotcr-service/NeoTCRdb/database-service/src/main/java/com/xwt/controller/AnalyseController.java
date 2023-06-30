package com.xwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwt.thrift.ServiceProvider;
import com.xwt.thrift.analyse.*;
import com.xwt.thrift.browse.BrowseService;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/service/analyse")
public class AnalyseController {
    @Resource
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/getAnalyse",method = RequestMethod.POST)
    public String getAnalyse(@RequestParam("filename1") String filename1,
                                 @RequestParam("filename2") String filename2,
                             @RequestParam("chain") String chain){
        System.out.println("getAnalyse");
        AnalyseService.Iface analyseService = serviceProvider.getAnalyseService();
        String uuid = filename1.split("\\.")[0];
        filename1 = "/root/store/temp/"+filename1;
        filename2 = "/root/store/temp/"+filename2;
        System.out.println(filename1+filename2+uuid);
        try {
            if(analyseService.getAnalyse(filename1,filename2,uuid,chain)){
                return "/root/store/temp/"+uuid+"/full_clones.txt";
            }
        } catch (TException e) {
            e.printStackTrace();
            return "";
        }
        return "";
    }

    @RequestMapping(value = "/getDNAAnalyse",method = RequestMethod.POST)
    public String getDNAAnalyse(@RequestParam("filename1") String filename1,
                                 @RequestParam("filename2") String filename2,
                                @RequestParam("chain") String chain){
        System.out.println("getDNAAnalyse");
        AnalyseService.Iface analyseService = serviceProvider.getAnalyseService();
        String uuid = filename1.split("\\.")[0];
        filename1 = "/root/store/temp/"+filename1;
        filename2 = "/root/store/temp/"+filename2;
        System.out.println(filename1+filename2+uuid);

        try {
            if(analyseService.getDNAAnalyse(filename1,filename2,uuid,chain)){
                return "/root/store/temp/"+uuid+"/full_clones.txt";
            }
        } catch (TException e) {
            e.printStackTrace();
            return "";
        }
        return "";
    }

    @RequestMapping(value = "/getUMIAnalyse",method = RequestMethod.POST)
    public String getUMIAnalyse(@RequestParam("filename1") String filename1,
                                 @RequestParam("filename2") String filename2,
                                 @RequestParam("umi") String umi,
                                @RequestParam("chain") String chain){
        System.out.println("getUMIAnalyse");
        AnalyseService.Iface analyseService = serviceProvider.getAnalyseService();
        String uuid = filename1.split("\\.")[0];
        filename1 = "/root/store/temp/"+filename1;
        filename2 = "/root/store/temp/"+filename2;
        System.out.println(filename1+filename2+umi+uuid);
        try {
            if(analyseService.getUMIAnalyse(filename1,filename2,umi,uuid,chain)){
                return "/root/store/temp/"+uuid+"/full_clones.txt";
            }
        } catch (TException e) {
            e.printStackTrace();
            return "";
        }
        return "";
    }

    @RequestMapping(value = "/conversion",method = RequestMethod.GET)
    public String conversion(@RequestParam("fileName") String fileName){
        System.out.println("conversion");
        System.out.println(fileName);
        AnalyseService.Iface analyseService = serviceProvider.getAnalyseService();
        try {
            String res = analyseService.conversion(fileName);
            JSONObject jsonObject = JSONObject.parseObject(res);
            return res;
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

}

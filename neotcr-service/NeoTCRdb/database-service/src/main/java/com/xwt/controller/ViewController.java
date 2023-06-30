package com.xwt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwt.thrift.ServiceProvider;
import com.xwt.thrift.view.ViewService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@CrossOrigin
@RequestMapping(value = "/service/view")
public class ViewController {
    @Resource
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/getView",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getView(@RequestParam("filepath") String filepath){
        System.out.println("getview");
        ViewService.Iface viewService = serviceProvider.getViewService();
        String res="";
        try {

            res=viewService.getView(filepath);
            JSONObject jsonObject = JSONObject.parseObject(res);
            return jsonObject;
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void ttt(@RequestParam("time") String time){
        System.out.println(time);
        ViewService.Iface viewService=serviceProvider.getViewService();
        try {
            System.out.println(viewService.ttt(time));
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}

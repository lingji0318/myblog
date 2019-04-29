package com.myblog.indexController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import interface_main.main_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/main_myblog")
public class IndexController {

    @RequestMapping("/index")
    public String index()
    {
        return "toufang_interface";
    }
    @RequestMapping("/dmp_interface")
    public  String dmp(){return "dmp_interface";}
    @RequestMapping("/adx_interface")
    public  String adx(){return "adx_interface";}






    @RequestMapping(value="/toufang_controller",produces="text/html;charset=UTF-8")//解决ajax返回的post body有中文乱码问题
    @ResponseBody
    public String toufang_interface(String toufang_req,String toufang_url )
    {
        return main_api.httpURLConnectionPOST(toufang_req,toufang_url);
    }

    @RequestMapping(value="/dmp_controller",produces="text/html;charset=UTF-8")//解决ajax返回的post body有中文乱码问题
    @ResponseBody
    public String dmp_interface(String dmp_req,String dmp_url )
    {
        return main_api.httpURLConnectionPOST(dmp_req,dmp_url);
    }

    @RequestMapping(value="/adx_controller",produces="text/html;charset=UTF-8")//解决ajax返回的post body有中文乱码问题
    @ResponseBody
    public String adx_interface(String adx_req,String adx_url )
    {
        return main_api.httpURLConnectionPOST(adx_req,adx_url);
    }

}

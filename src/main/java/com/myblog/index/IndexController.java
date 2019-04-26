package com.myblog.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import interface_toufang.main_api;


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

}

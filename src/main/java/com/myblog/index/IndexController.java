package com.myblog.index;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/main_myblog")
public class IndexController {

    @RequestMapping("/index")
    public String index()
    {
        return "toufang_interface";
    }

    @RequestMapping(value="/toufang_controller",produces="text/html;charset=UTF-8")//解决ajax返回的post body有中文乱码问题
    @ResponseBody
    public String toufang_interface(String toufang_req )
    {
         //String url=
         //String toufang_req
        return toufang_req;
    }
}

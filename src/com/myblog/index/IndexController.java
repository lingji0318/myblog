package com.myblog.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main_myblog")
public class IndexController {

    @RequestMapping("/index")
    public String index()
    {
        return "/WEB-INF/views/user_info.jsp";
    }
}

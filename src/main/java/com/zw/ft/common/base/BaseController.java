package com.zw.ft.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @ClassName BaseController
 * @Description BaseController
 * @Author Oliver
 * @Date 2020/9/19 15:29
 * @Version 1.0
 **/
@Controller
public class BaseController {

    protected Logger logger = (Logger) LoggerFactory.getLogger(getClass());
    @GetMapping(value = "/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }
}

package com.eliteams.quick4j.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author StarZou
 * @since 2014年5月28日 下午4:00:49
 **/
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * dashboard页
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

    /*
     非结构化文件上传
    */
    @RequestMapping("/upload")
    public String upLoad() {
        return "unStruct/upload";
    }

    /*
     非结构化数据检索
    */
    @RequestMapping("/search")
    public String search() {
        return "unStruct/search";
    }
    /*
      结构化数据检索
     */
    @RequestMapping("/struct")
    public String jump(){
        return "Struct/search";
    }
}
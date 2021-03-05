package com.atjianyi.controller;

import com.atjianyi.pojo.SystemLog;
import com.atjianyi.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 简一
 * @className SystemLogController
 * @Date 2021/3/5 16:58
 **/
@Controller
@RequestMapping("/systemLog")
public class SystemLogController {
    @Autowired
    private SystemLogService service;

    @RequestMapping("/findAllLog.do")
    public ModelAndView findAllLog(){
        List<SystemLog> logs =  service.findAllLog();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("logs",logs);
        modelAndView.setViewName("log-list");
        return modelAndView;
    }
}

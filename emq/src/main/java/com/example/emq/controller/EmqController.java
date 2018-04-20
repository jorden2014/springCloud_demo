package com.example.emq.controller;

import com.example.emq.service.EmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jorden
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/4/1817:36
 */
@RestController
public class EmqController {
    @Autowired
    private EmqService emqService;

    @RequestMapping("/publish/{msg}")
    public void send(@PathVariable String msg){
        emqService.publish("测试",msg);
    }

    @RequestMapping("/subscribe")
    public void receive(){
        emqService.subscribe("测试");
    }
}

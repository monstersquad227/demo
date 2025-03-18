package com.example.demo.controller;


import com.example.demo.service.HarborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/harbor")
public class HarborController {

    private final HarborService harborService;
    @Autowired
    public HarborController(HarborService harborService){
        this.harborService = harborService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tagList")
    public Map<String, Object> tagList(@RequestParam String project, String env) {

        return harborService.processHarborTagList(project, env);
    }
}

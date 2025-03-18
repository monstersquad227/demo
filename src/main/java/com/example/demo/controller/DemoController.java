package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testGet")
    public String testGet() {

        return "demo OK";
    }



    @RequestMapping(method = RequestMethod.POST, value = "/testPost")
    public Map<String, Object> testPost(@RequestBody Map<String, Object> requestData) {

        return demoService.processPostRequest(requestData);
    }
}

package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoService {

    public Map<String, Object> processPostRequest(Map<String, Object> requestData) {
        Map<String, Object> result = new HashMap<>();
        Object data = requestData.get("data");
        Object msg = requestData.get("message");
        result.put("code", 200);
        result.put("data", data);
        result.put("message", msg);
        return result;
    }
}

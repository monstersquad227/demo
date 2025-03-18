package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class HarborService {

    private final RestTemplate restTemplate;

    @Autowired
    public HarborService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> processHarborTagList(String project, String env) {

        String url = "https://harbor.chengdd.cn/api/repositories/" + env + "/" + project + "/tags";

        // 设置基本身份验证头
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin", "Mzl123456");

        // 发送请求
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Object[].class);

        // 处理响应
        Map<String, Object> result = new HashMap<>();
        result.put("code", responseEntity.getStatusCodeValue());
        result.put("data", responseEntity.getBody());
        result.put("message", "successful");
        return result;
    }
}

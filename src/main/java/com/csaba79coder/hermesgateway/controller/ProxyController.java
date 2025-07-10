package com.csaba79coder.hermesgateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProxyController {

    private final RestTemplate restTemplate;

    private static final String FASTAPI_BASE_URL = "http://localhost:8000";

    @GetMapping("/hello/{name}")
    public ResponseEntity<Map> proxyHello(@PathVariable String name) {
        String url = FASTAPI_BASE_URL + "/hello/" + name;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/")
    public ResponseEntity<Map> proxyRoot() {
        String url = FASTAPI_BASE_URL + "/";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
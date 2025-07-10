package com.csaba79coder.hermesgateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.csaba79coder.hermesgateway.util.PromptHelper.encodePrompt;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ModelProxyController {

    private final WebClient webClient = WebClient.create("http://localhost:8000"); // FastAPI port

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generate(@RequestParam String prompt) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/generate/")
                        .queryParam("prompt", encodePrompt(prompt))
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .map(ResponseEntity::ok);
    }
}

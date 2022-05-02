package com.example;

import com.example.config.MessageProducer;
import com.example.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class controller {
    private final  MessageProducer producer;
    private final ApiService apiService;

    @GetMapping("/d")
    public void get()
    {
        producer.sendMessage(apiService.getData("Grodno"));
    }
}

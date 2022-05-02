package com.example.service;

import com.egorbahar.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {
    private final RestTemplate restTemplate;

    @Override
    public Weather getData(String city) {
        String url = "http://172.24.96.1:8081/api/weather?city=" + city;
        return restTemplate.getForObject(url, Weather.class);
    }

}
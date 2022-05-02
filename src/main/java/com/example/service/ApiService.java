package com.example.service;

import com.egorbahar.Weather;

public interface ApiService {
    Weather getData(String city);
}

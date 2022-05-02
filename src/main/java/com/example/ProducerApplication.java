package com.example;

import com.example.config.MessageProducer;
import com.example.service.ApiServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProducerApplication.class, args);
        MessageProducer producer = applicationContext.getBean(MessageProducer.class);
        producer.sendMessage(applicationContext.getBean(ApiServiceImpl.class).getData("Grodno"));
    }
}

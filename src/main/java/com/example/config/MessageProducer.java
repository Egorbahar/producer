package com.example.config;

import com.egorbahar.Weather;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@NoArgsConstructor
@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Weather> kafkaTemplate;
    @Value(value = "${kafka.topic.name}")
    private String topicName;


    public void sendMessage(Weather weather) {
        ListenableFuture<SendResult<String, Weather>> future = kafkaTemplate.send(topicName, weather);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message = {} dut to: {}", weather, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Weather> stringDataSendResult) {
                log.info("Sent Message = {} with offset = {}", weather, stringDataSendResult.getRecordMetadata().offset());
            }
        });
    }
}
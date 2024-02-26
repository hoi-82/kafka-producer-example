package com.example.kafka.producer.service;

import com.example.kafka.producer.domain.dto.TestMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, TestMessage<?>> kafkaTemplate;

    public void sendMessage(String id, String message) {
        final TestMessage<String> testMessage = new TestMessage<>(id, message);
        kafkaTemplate.send("test-topic", testMessage)
                .whenComplete((result, ex) -> {
                    if(ex == null) handleSuccess(testMessage);
                    else handleFailure(testMessage, ex);
                });
    }

    private void handleSuccess(TestMessage<?> testMessage) {
        log.debug("Message was successfully sent / TestMessage id : {}", testMessage.id());
    }

    private void handleFailure(TestMessage<?> testMessage, Throwable throwable) {
        log.debug("Failed to send message / TestMessage id : {}", testMessage.id());
        log.debug("Fail log : {}", throwable.getMessage());
    }
}

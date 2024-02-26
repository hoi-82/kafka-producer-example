package com.example.kafka.producer.endpoint;

import com.example.kafka.producer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestRestController
 *
 * @author devhoi
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class TestRestController {
    private final KafkaProducerService kafkaProducerService;

    /**
     * sendMessage
     *
     * Kafka에 데이터 전송
     *
     * @author devhoi
     * @param id
     * @param message
     */
    @PostMapping("/message")
    public void sendMessage(@RequestParam("id") String id, @RequestParam("message") String message) {
        kafkaProducerService.sendMessage(id, message);
    }
}

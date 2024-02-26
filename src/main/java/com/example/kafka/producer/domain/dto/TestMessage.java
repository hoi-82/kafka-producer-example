package com.example.kafka.producer.domain.dto;

public record TestMessage<T>(String id, T body) {
}

package br.com.bode.pocpetshop.cadastropet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PetProducer {

    private String topic;

    private final KafkaTemplate<String, Pet> kafkaTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(PetProducer.class);


    public PetProducer(@Value("${kafka.topic.pet}") String topic, KafkaTemplate<String, Pet> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Pet pet) {
        String traceId = UUID.randomUUID().toString();
        kafkaTemplate.send(topic, traceId, pet).addCallback(
                success -> LOGGER.info("Send message with success! - ID: " + traceId),
                failure -> LOGGER.error("Fail on send message... - ID: " + traceId)
        );
    }

}

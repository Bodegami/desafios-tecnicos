package br.com.bode.pocmailing.pet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component

public class PetConsumer {

    private final PetRepository repository;
    private final ObjectMapper mapper;

    private final Logger LOGGER = LoggerFactory.getLogger(PetConsumer.class);

    public PetConsumer(PetRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "${kafka.topic.pet}")
    public void consumer(ConsumerRecord<String, Pet> record, Acknowledgment ack) {

        try {
            var pet = record.value();

            repository.save(pet);

            ack.acknowledge();

            LOGGER.info("Save on database with success! - Message: " + pet.toString());
        } catch (Exception e) {
            LOGGER.info("Fail on receive message...");
            throw new RuntimeException("Error durante persistência!");
        }

    }


}

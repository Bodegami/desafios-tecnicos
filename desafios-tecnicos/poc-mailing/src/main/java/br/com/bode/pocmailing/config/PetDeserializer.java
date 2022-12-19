package br.com.bode.pocmailing.config;

import br.com.bode.pocmailing.pet.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;


public class PetDeserializer implements Deserializer {

    @Override public void close() {

    }

    @Override
    public Pet deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = null;
        try {
            pet = mapper.readValue(arg1, Pet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pet;
    }
}

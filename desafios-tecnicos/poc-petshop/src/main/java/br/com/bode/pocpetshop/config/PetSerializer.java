package br.com.bode.pocpetshop.config;

import br.com.bode.pocpetshop.cadastropet.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class PetSerializer implements Serializer {


    @Override
    public byte[] serialize(String s, Object o) {
        Pet arg1 = (Pet) o;
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override public void close() {
    }
}

package br.com.bode.pocpetshop.cadastropet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetProducer producer;

    public PetController(PetProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> cadastro(@RequestBody PetCadastroRequest request) {
        Pet pet = request.toModel();
        producer.sendMessage(pet);
        return ResponseEntity.ok(pet.toString());
    }

}

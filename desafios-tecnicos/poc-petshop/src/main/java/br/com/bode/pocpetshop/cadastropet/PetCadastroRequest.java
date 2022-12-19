package br.com.bode.pocpetshop.cadastropet;

import java.io.Serializable;

public class PetCadastroRequest {

    private String nome;
    private String raca;
    private Long idade;

    public PetCadastroRequest() {

    }

    public PetCadastroRequest(String nome, String raca, Long idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public Long getIdade() {
        return idade;
    }

    public Pet toModel() {
        return new Pet(nome, raca, idade);
    }
}

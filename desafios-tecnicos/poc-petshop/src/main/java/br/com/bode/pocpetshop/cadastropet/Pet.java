package br.com.bode.pocpetshop.cadastropet;

import java.util.Objects;

public class Pet {

    private String nome;
    private String raca;
    private Long idade;

    public Pet() {
    }

    public Pet(String nome, String raca, Long idade) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(nome, pet.nome) && Objects.equals(raca, pet.raca) && Objects.equals(idade, pet.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, raca, idade);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                '}';
    }
}

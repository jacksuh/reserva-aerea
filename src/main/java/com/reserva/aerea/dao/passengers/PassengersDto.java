package com.reserva.aerea.dao.passengers;

public class PassengersDto {

    private String nome;

    private String cpf;

    public String PassengersData(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        return nome + cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

package br.com.linketinder.pessoa

class Pessoa {
    String nome, email, cep, estado
    List<String> competencias = []

    Pessoa(String nome, String email, String cep, String estado, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.competencias = competencias
    }
}

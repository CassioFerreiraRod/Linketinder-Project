package br.com.linketinder.model.entity

class Usuario {
    int id
    String nome, email, cep, estado, descricao
    List<String> competencias = []

    Usuario(String nome, String email, String cep, String estado, List<String> competencias, String descricao) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.competencias = competencias
        this.descricao = descricao
    }

    Usuario(int id, String nome, String email, String cep, String estado, String descricao, List<String> competencias) {
        this.id = id
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.descricao = descricao
        this.competencias = competencias
    }
}

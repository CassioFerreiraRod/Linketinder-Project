package br.com.linketinder.model.entity

class Usuario {
    int id
    String nome, email, cep, estado, descricao

    Usuario(String nome, String email, String cep, String estado, String descricao) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.descricao = descricao
    }

    Usuario(int id, String nome, String email, String cep, String estado, String descricao) {
        this.id = id
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.descricao = descricao
    }
}

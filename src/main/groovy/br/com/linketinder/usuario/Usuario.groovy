package br.com.linketinder.usuario

class Usuario {
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
}

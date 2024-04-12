package br.com.linketinder.model.entity

class Empresa extends Usuario {
    int id
    String cnpj
    String pais
    String senha

    Empresa(int id, String nome, String email, String cnpj, String cep, String estado, String pais, String descricao) {
        super(id, nome, email, cep, estado, descricao)
        this.id = id
        this.cnpj = cnpj
        this.pais = pais
    }

    Empresa(int id, String nome, String email, String cnpj, String cep, String estado, String pais, String descricao, String senha) {
        super(id, nome, email, cep, estado, descricao)
        this.id = id
        this.cnpj = cnpj
        this.pais = pais
        this.senha = senha
    }

    Empresa(String nome, String email, String cep, String estado, String descricao, String cnpj, String pais) {
        super(nome, email, cep, estado, descricao)
        this.cnpj = cnpj
        this.pais = pais
    }

    Empresa(String nome, String email, String cnpj, String cep, String estado, String pais, String descricao, String senha) {
        super(nome, email, cep, estado, descricao)
        this.cnpj = cnpj
        this.pais = pais
        this.senha = senha
    }

    @Override
    String toString() {
        return """\
Empresa{
    id: ${super.id}
    Nome: ${super.nome},
    Email: ${super.email},
    CNPJ: $cnpj,
    País: $pais,
    Estado: ${super.estado},
    CEP: ${super.cep},
    Descrição aa Empresa: ${super.descricao},
}"""
    }
}

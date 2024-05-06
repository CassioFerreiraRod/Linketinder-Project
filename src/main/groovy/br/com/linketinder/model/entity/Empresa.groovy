package br.com.linketinder.model.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class Empresa extends Usuario {
    String cnpj
    String pais
    String senha

    Empresa(int id, String nome, String email, String cnpj, String cep, String estado, String pais, String descricao) {
        super(id, nome, email, cep, estado, descricao)
        this.cnpj = cnpj
        this.pais = pais
    }

    Empresa(int id, String nome, String email, String cnpj, String cep, String estado, String pais, String descricao, String senha) {
        super(id, nome, email, cep, estado, descricao)
        this.cnpj = cnpj
        this.pais = pais
        this.senha = senha
    }

    @JsonCreator
    Empresa(
            @JsonProperty("nome") String nome,
            @JsonProperty("email") String email,
            @JsonProperty("cnpj") String cnpj,
            @JsonProperty("cep") String cep,
            @JsonProperty("estado") String estado,
            @JsonProperty("pais") String pais,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("senha") String senha) {
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

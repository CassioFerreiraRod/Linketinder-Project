package br.com.linketinder.model.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class Vaga {
    int id
    String nome
    String descricao
    String cidade
    String estado
    String empresa
    List<String> competencias

    Vaga(int id, String empresa, String nome, String descricao, String cidade, String estado, List<String> competencias) {
        this.id = id
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.competencias = competencias
        this.empresa = empresa
    }

    Vaga(
            String nome,
            String descricao,
            String cidade,
            String estado,
            String empresa) {
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.empresa = empresa
    }

    @JsonCreator
    Vaga(
            @JsonProperty("nome") String nome,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("cidade") String cidade,
            @JsonProperty("estado") String estado,
            @JsonProperty("empresa") String empresa,
            @JsonProperty("competencias") List<String> competencias
    ) {
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.empresa = empresa
        this.competencias = competencias
    }

    Vaga(int id, String nome, String descricao, String cidade, String estado, String empresa) {
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.empresa = empresa
        this.id = id
    }

    @Override
    String toString() {
        return """\
Vaga{
    id: $id,
    Nome: $nome,
    Empresa: $empresa
    Descricao: $descricao,
    Cidade: $cidade,
    Estado: $estado
    Competencias: $competencias
}"""
    }
}

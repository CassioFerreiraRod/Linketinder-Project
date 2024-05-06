package br.com.linketinder.model.entity

import br.com.linketinder.utils.DAOUtils
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

import java.sql.Date

class Candidato extends Usuario {
    String cpf
    String sobrenome
    String dataNascimento
    String pais
    String senha
    List<String> competencias

    Candidato(
             String nome,
             String sobrenome,
             String email,
             String cep,
             String estado,
             String pais,
             String descricao,
             String cpf,
             String senha,
             String dataNascimento
    ) {
        super(nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.senha = senha
        this.dataNascimento = dataNascimento
    }

    @JsonCreator
    Candidato(
            @JsonProperty("nome") String nome,
            @JsonProperty("sobrenome") String sobrenome,
            @JsonProperty("email") String email,
            @JsonProperty("cep") String cep,
            @JsonProperty("estado") String estado,
            @JsonProperty("pais") String pais,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("cpf") String cpf,
            @JsonProperty("senha") String senha,
            @JsonProperty("dataNascimento") String dataNascimento,
            @JsonProperty("competencias") List<String> competencias
    ) {
        super(nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.senha = senha
        this.dataNascimento = dataNascimento
        this.competencias = competencias
    }

    Candidato(int id, String nome, String sobrenome, String email, String cep, String estado, String pais,
              String descricao, String cpf, String dataNascimento, String senha) {
        super(id, nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.dataNascimento = dataNascimento
        this.senha = senha
    }

    Candidato(int id, String nome, String sobrenome, String email, String cep, String estado, String pais,
              String descricao, String cpf, String dataNascimento, List<String> competencias) {
        super(id, nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.dataNascimento = dataNascimento
        this.competencias = competencias
    }

     Date getDataNascimento() {
         Date dataSQL = DAOUtils.converterParaSQLDate(this.dataNascimento)
         return dataSQL
    }

    @Override
    String toString() {
        return """\
Candidato{
    id: ${super.id},
    Nome: ${super.nome},
    Sobrenome: $sobrenome,
    Email: ${super.email},
    CPF: $cpf,
    Data de nascimento: $dataNascimento,
    Estado: ${super.estado},
    Pais: $pais,
    Cep: ${super.cep},
    Descricao Pessoal: ${super.descricao},
    Competências: $competencias
}"""
    }
}

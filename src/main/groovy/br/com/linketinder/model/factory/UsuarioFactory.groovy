package br.com.linketinder.model.factory

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.entity.Empresa

class UsuarioFactory {

    static Candidato criarCandidato(
            String nome,
            String sobrenome,
            String email,
            String cep,
            String estado,
            String pais,
            String descricao,
            String cpf,
            String dataNascimento,
            String senha) {
        return new Candidato(nome, sobrenome, email, cep, estado, pais, descricao, cpf, dataNascimento, senha)
    }

    static Empresa criarEmpresa(
            String nome,
            String email,
            String cnpj,
            String cep,
            String estado,
            String pais,
            String descricao,
            String senha) {
        return new Empresa(nome, email, cnpj, cep, estado, pais, descricao, senha)
    }

}
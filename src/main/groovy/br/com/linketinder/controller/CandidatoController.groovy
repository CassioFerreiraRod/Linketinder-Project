package br.com.linketinder.controller

import br.com.linketinder.model.factory.UsuarioFactory
import br.com.linketinder.service.CandidatoService

class CandidatoController {

    CandidatoService candidatoService

    CandidatoController() {
        this.candidatoService = new CandidatoService()
    }

    void listarCandidatos() {
        candidatoService.listarCandidatos()
    }

    void cadastraCandidato(String nome,
                           String sobrenome,
                           String email,
                           String cep,
                           String estado,
                           String pais,
                           String descricao,
                           String cpf,
                           String dataNascimento,
                           String senha){
        candidatoService.cadastrarCandidato(UsuarioFactory.criarCandidato(
                nome,
                sobrenome,
                email,
                cep,
                estado,
                pais,
                descricao,
                cpf,
                dataNascimento,
                senha
        ))
    }

}

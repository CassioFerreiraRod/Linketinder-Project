package br.com.linketinder.controller

import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.model.factory.VagaFactory
import br.com.linketinder.service.VagaService

class VagaController {

    VagaService vagaService

    VagaController() {
        this.vagaService = new VagaService()
    }

    void cadastrarVaga(String nome, String descricao, String cidade, String estado, String empresa) {
        this.vagaService.cadastrarVaga(VagaFactory.criarVaga(nome, descricao, cidade, estado, empresa))
    }

    void listarVagas() {
        vagaService.listarVagas()
    }

    void atualizaVaga(Vaga vaga) {
        vagaService.alterarVaga(vaga)
    }

    void excluirVaga(int id) {
        vagaService.excluirVaga(id)
    }
}

package br.com.linketinder.service

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.dao.ConexaoDB
import br.com.linketinder.model.entity.Vaga

class VagaService {
    VagaDAO vagaDAO

    VagaService() {
        vagaDAO = new VagaDAO(ConexaoDB.conectar())
    }

    void listarVagas() {
        List<Vaga> listaVagas = vagaDAO.listar()
        listaVagas.each {
            println(it)
        }
    }

    boolean cadastrarVaga(Vaga vaga) {
        return vagaDAO.inserir(vaga)
    }

    boolean alterarVaga(Vaga vaga) {
        return vagaDAO.alterar(vaga)
    }

    boolean excluirVaga(int id) {
        return vagaDAO.remover(id)
    }
}

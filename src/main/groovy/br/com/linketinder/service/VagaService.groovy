package br.com.linketinder.service

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.utils.DatabaseUtils

import java.sql.Connection
import java.sql.SQLException

class VagaService {
    VagaDAO vagaDAO

    VagaService() {
        vagaDAO = new VagaDAO()
    }

    boolean listarVagas() {
        List<Vaga> listaVagas = vagaDAO.listar()
        listaVagas.each {
            println(it)
        }
    }

    boolean cadastrarVaga(Vaga vaga) {

        boolean cadastroValido = vagaDAO.inserir(vaga)

        return cadastroValido

    }

    boolean alterarVaga(Vaga vaga) {
        boolean alteracaoValida = vagaDAO.alterar(vaga)

        return alteracaoValida
    }

    boolean excluirVaga(int id) {
        boolean exclusaoValida = vagaDAO.remover(id)

        return exclusaoValida
    }
}

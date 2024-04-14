package br.com.linketinder.service

import br.com.linketinder.utils.DatabaseUtils
import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Candidato

import java.sql.Connection
import java.sql.SQLException

class CandidatoService {

    CandidatoDAO candidatoDAO

    CandidatoService() {
        candidatoDAO = new CandidatoDAO()
    }

    void listarCandidatos() {
        List<Candidato> listaCandidatos = candidatoDAO.listar()
        listaCandidatos.each {
            println(it)
        }
    }

    boolean cadastrarCandidato(Candidato candidato) {

        boolean cadastroValido = candidatoDAO.inserir(candidato)

        return cadastroValido
    }

    boolean alterarCandidato(Candidato candidato) {
        boolean alteracaoValida = candidatoDAO.alterar(candidato)

        return alteracaoValida
    }

    boolean excluirCandidato(int id) {
        boolean exclusaoValida = candidatoDAO.remover(id)

        return exclusaoValida
    }
}

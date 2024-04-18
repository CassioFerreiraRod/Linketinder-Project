package br.com.linketinder.service

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Candidato

class CandidatoService {

    CandidatoDAO candidatoDAO

    CandidatoService() {
        candidatoDAO = new CandidatoDAO(ConexaoDAO.conectar())
    }

    void listarCandidatos() {
        List<Candidato> listaCandidatos = candidatoDAO.listar()
        listaCandidatos.each {
            println(it)
        }
    }

    boolean cadastrarCandidato(Candidato candidato) {
        return candidatoDAO.inserir(candidato)
    }

    boolean alterarCandidato(Candidato candidato) {
        return candidatoDAO.alterar(candidato)
    }

    boolean excluirCandidato(int id) {
        return candidatoDAO.remover(id)
    }
}

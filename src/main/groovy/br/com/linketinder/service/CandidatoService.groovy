package br.com.linketinder.service

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDB
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.entity.Usuario

class CandidatoService {

    CandidatoDAO candidatoDAO

    CandidatoService() {
        candidatoDAO = new CandidatoDAO(ConexaoDB.conectar())
    }

    void listarCandidatos() {
        List<Candidato> listaCandidatos = candidatoDAO.listar()
        listaCandidatos.each {
            println(it)
        }
    }

    boolean cadastrarCandidato(Usuario candidato) {
        return candidatoDAO.inserir(candidato)
    }

    boolean alterarCandidato(Candidato candidato) {
        return candidatoDAO.alterar(candidato)
    }

    boolean excluirCandidato(int id) {
        return candidatoDAO.remover(id)
    }
}

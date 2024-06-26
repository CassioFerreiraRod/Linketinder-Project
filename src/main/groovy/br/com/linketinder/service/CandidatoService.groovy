package br.com.linketinder.service

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.conn.ConexaoDB
import br.com.linketinder.model.entity.Candidato

class CandidatoService {

    CandidatoDAO candidatoDAO

    CandidatoService() {
        candidatoDAO = new CandidatoDAO(ConexaoDB.conectar())
    }

    List<Candidato> listarCandidatos() {
        List<Candidato> listaCandidatos = candidatoDAO.listar()
        return listaCandidatos
    }

    Candidato listarCandidato(int id) {
        return candidatoDAO.obterCandidato(id)
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

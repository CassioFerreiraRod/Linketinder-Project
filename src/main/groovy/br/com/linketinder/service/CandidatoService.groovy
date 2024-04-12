package br.com.linketinder.service

import br.com.linketinder.utils.DatabaseUtils
import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Candidato

import java.sql.Connection
import java.sql.SQLException

class CandidatoService {

    static CandidatoDAO candidatoDAO

    CandidatoService() {
        candidatoDAO = new CandidatoDAO()
    }

    static void listarCandidatos() {
        List<Candidato> listaCandidatos = candidatoDAO.listar()
        listaCandidatos.each {
            println(it)
        }
    }

    static boolean cadastrarCandidato(Candidato candidato) {

        boolean cadastroValido = candidatoDAO.inserir(candidato)

        return cadastroValido
    }

    static boolean cadastrarCandidatoCompetencia(List<String> listaCompetencias) {
        try (Connection conn = ConexaoDAO.conectar()) {
            List<Integer> id_competencias = DatabaseUtils.obterCompetenciasIdPorNome(conn, listaCompetencias)
            int candidatoId = DatabaseUtils.obterIdCandidatoRecente(conn)
            for (int id_comptencia : id_competencias) {
                candidatoDAO.inserirCandidatoCompetencia(id_comptencia, candidatoId)
            }
            return true
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar candidato: " + e.getMessage())
        }
    }

    static boolean alterarCandidato(Candidato candidato) {
        boolean alteracaoValida = candidatoDAO.alterar(candidato)

        return alteracaoValida
    }

    static boolean excluirCandidato(int id) {
        boolean exclusaoValida = candidatoDAO.remover(id)

        return exclusaoValida
    }
}

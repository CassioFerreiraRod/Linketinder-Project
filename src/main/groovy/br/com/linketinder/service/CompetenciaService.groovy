package br.com.linketinder.service

import br.com.linketinder.dao.CompetenciaDAO
import br.com.linketinder.conn.ConexaoDB
import br.com.linketinder.model.entity.Competencia
import br.com.linketinder.utils.DAOUtils

import java.sql.Connection
import java.sql.SQLException

class CompetenciaService {
    CompetenciaDAO competenciaDAO

    CompetenciaService() {
        competenciaDAO = new CompetenciaDAO(ConexaoDB.conectar())
    }

    List<Competencia> listarCompetencias() {
        List<Competencia> listaCompetencias = competenciaDAO.listar()
        return listaCompetencias
    }

    boolean cadastrarCompetencia(Competencia competencia) {
        return competenciaDAO.inserir(competencia)
    }

    boolean alterarCompetencia(Competencia competencia) {
        return competenciaDAO.alterar(competencia)
    }

    boolean excluirCompetencia(Integer id) {
        return competenciaDAO.remover(id)
    }

    boolean cadastrarCandidatoCompetencia(List<String> competencias) {
        Connection conn = ConexaoDB.conectar()
        try {
            List<Integer> id_competencias = DAOUtils.obterCompetenciasIdPorNome(conn, competencias)
            int candidatoId = DAOUtils.obterIdCandidatoRecente(conn)

            id_competencias.each {
                competenciaDAO.inserirCandidatoCompetencia(it, candidatoId)
            }


            return true
        } catch (SQLException e) {
            e.printStackTrace()
        } finally {
            conn.close()
        }
    }

    boolean cadastrarVagaCompetencia(List<String> listaCompetencias) {
        Connection conn = ConexaoDB.conectar()
        try {
            List<Integer> id_competencias = DAOUtils.obterCompetenciasIdPorNome(conn, listaCompetencias)
            int vagaId = DAOUtils.obterIdVagaRecente(conn)

            id_competencias.each {
                competenciaDAO.inserirVagaCompetencia(it, vagaId)
            }

            return true
        } catch (SQLException e) {
            e.printStackTrace()
        } finally {
            conn.close()
        }
    }
}

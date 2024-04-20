package br.com.linketinder.service

import br.com.linketinder.dao.CompetenciaDAO
import br.com.linketinder.dao.ConexaoDB
import br.com.linketinder.model.entity.Competencia
import br.com.linketinder.utils.DAOUtils

import java.sql.Connection
import java.sql.SQLException

class CompetenciaService {
    CompetenciaDAO competenciaDAO

    CompetenciaService() {
        competenciaDAO = new CompetenciaDAO(ConexaoDB.conectar())
    }

    void listarCompetencias() {
        List<Competencia> listaCompetencias = competenciaDAO.listar()
        listaCompetencias.each {
            println(it)
        }
    }

    boolean cadastrarCompetencia(Competencia competencia) {
        return competenciaDAO.inserir(competencia)
    }

    boolean alterarCompetencia(Competencia competencia){
        return competenciaDAO.alterar(competencia)
    }

    boolean excluirCompetencia(Integer id) {
        return competenciaDAO.remover(id)
    }

    boolean cadastrarCandidatoCompetencia(List<String> competencias) {
        try(Connection conn = ConexaoDB.conectar()) {
            List<Integer> id_competencias = DAOUtils.obterCompetenciasIdPorNome(conn, competencias)
            int candidatoId = DAOUtils.obterIdCandidatoRecente(conn)

            for (int id_competencia : id_competencias) {
                competenciaDAO.inserirCandidatoCompetencia(id_competencia, candidatoId)
            }

            return true
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar competência na vaga: " + e.getMessage())
        }
    }

     boolean cadastrarVagaCompetencia(List<String> listaCompetencias) {
        try(Connection conn = ConexaoDB.conectar()) {
            List<Integer> id_competencias = DAOUtils.obterCompetenciasIdPorNome(conn, listaCompetencias)
            int vagaId = DAOUtils.obterIdVagaRecente(conn)

            for (int id_competencia : id_competencias) {
                competenciaDAO.inserirVagaCompetencia(id_competencia, vagaId)
            }

            return true
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar competência na vaga: " + e.getMessage())
        }
    }
}

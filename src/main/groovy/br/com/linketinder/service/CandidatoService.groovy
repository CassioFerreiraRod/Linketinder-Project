package br.com.linketinder.service

import br.com.linketinder.utils.DatabaseUtils
import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Candidato

import java.sql.Connection

class CandidatoService {

    static CandidatoDAO candidatoDAO

    CandidatoService() {
        candidatoDAO = new CandidatoDAO()
    }

    static void listarCandidatos() {
        List<Candidato> listaCandidatos= candidatoDAO.listar()
        listaCandidatos.each {
            println(it)
        }
    }

    static void cadastrarCandidato(Candidato candidato) {

        boolean cadastroValido = candidatoDAO.inserir(candidato)

        if (cadastroValido) {
            println("Cadastro Realizado com sucesso")
        } else {
            println("Erro ao fazer cadastro")
        }

    }

    static void cadastrarCandidatoCompetencia(List<String> listaCompetencias) {

        Connection conn = null

        try {
            conn = ConexaoDAO.conectar()

            List<Integer> id_competencias = DatabaseUtils.obterCompetenciasIdPorNome(conn,listaCompetencias)
            int candidatoId = DatabaseUtils.obterIdCandidatoRecente(conn)

            for (int id_comptencia : id_competencias) {
                candidatoDAO.inserirCandidatoCompetencia(id_comptencia, candidatoId)
            }
            println("Cadastro realizado com sucesso")
        }catch (Exception e) {
            e.printStackTrace()
            println("Erro ao fazer cadastro")
        }finally {
            ConexaoDAO.desconectar(conn)
        }

    }

    static void alterarCandidato(Candidato candidato) {
        boolean alteracaoValida = candidatoDAO.alterar(candidato)

        if (alteracaoValida) {
            println("Alteração Realizada com sucesso")
        } else {
            println("Erro ao fazer alteração")
        }
    }

    static void excluirCandidato(int id) {
        boolean exclusaoValida =candidatoDAO.remover(id)

        if (exclusaoValida) {
            println("Candidato excluído com sucesso")
        } else {
            println("Erro ao fazer exclusão")
        }
    }
}

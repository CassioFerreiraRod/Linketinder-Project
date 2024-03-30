package br.com.linketinder.service

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.utils.DatabaseUtils

import java.sql.Connection

class VagaService {
    static VagaDAO vagaDAO

    VagaService() {
        vagaDAO = new VagaDAO()
    }

    static void listarVagas() {
        List<Vaga> listaVagas= vagaDAO.listar()
        listaVagas.each {
            println(it)
        }
    }

    static void cadastrarVaga(Vaga vaga) {

        boolean cadastroValido = vagaDAO.inserir(vaga)

        if (cadastroValido) {
            println("Cadastro Realizado com sucesso")
        } else {
            println("Erro ao fazer cadastro")
        }

    }

    static void cadastrarVagaCompetencia(List<String> listaCompetencias) {

        Connection conn = null

        try {
            conn = ConexaoDAO.conectar()

            List<Integer> id_competencias = DatabaseUtils.obterCompetenciasIdPorNome(conn,listaCompetencias)
            int vagaId = DatabaseUtils.obterIdVagaRecente(conn)

            for (int id_comptencia : id_competencias) {
                vagaDAO.inserirVagaCompetencia(id_comptencia, vagaId)
            }
            println("Cadastro realizado com sucesso")
        }catch (Exception e) {
            e.printStackTrace()
            println("Erro ao fazer cadastro")
        }finally {
            ConexaoDAO.desconectar(conn)
        }

    }

    static void alterarVaga(Vaga vaga) {
        boolean alteracaoValida = vagaDAO.alterar(vaga)

        if (alteracaoValida) {
            println("Alteração Realizada com sucesso")
        } else {
            println("Erro ao fazer alteração")
        }
    }

    static void excluirVaga(int id) {
        boolean exclusaoValida =vagaDAO.remover(id)

        if (exclusaoValida) {
            println("Vaga excluído com sucesso")
        } else {
            println("Erro ao fazer exclusão")
        }
    }
}

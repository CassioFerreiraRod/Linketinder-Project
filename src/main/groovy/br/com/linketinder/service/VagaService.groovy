package br.com.linketinder.service

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.utils.DatabaseUtils

import java.sql.Connection
import java.sql.SQLException

class VagaService {
    static VagaDAO vagaDAO

    VagaService() {
        vagaDAO = new VagaDAO()
    }

    static boolean listarVagas() {
        List<Vaga> listaVagas = vagaDAO.listar()
        listaVagas.each {
            println(it)
        }
    }

    static boolean cadastrarVaga(Vaga vaga) {

        boolean cadastroValido = vagaDAO.inserir(vaga)

        return cadastroValido

    }

    static boolean cadastrarVagaCompetencia(List<String> listaCompetencias) {
        try(Connection conn = ConexaoDAO.conectar()) {
            List<Integer> id_competencias = DatabaseUtils.obterCompetenciasIdPorNome(conn, listaCompetencias)
            int vagaId = DatabaseUtils.obterIdVagaRecente(conn)

            for (int id_comptencia : id_competencias) {
                vagaDAO.inserirVagaCompetencia(id_comptencia, vagaId)
            }

            return true
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar competência na vaga: " + e.getMessage())
        }
    }

    static boolean alterarVaga(Vaga vaga) {
        boolean alteracaoValida = vagaDAO.alterar(vaga)

        return alteracaoValida
    }

    static boolean excluirVaga(int id) {
        boolean exclusaoValida = vagaDAO.remover(id)

        return exclusaoValida
    }
}

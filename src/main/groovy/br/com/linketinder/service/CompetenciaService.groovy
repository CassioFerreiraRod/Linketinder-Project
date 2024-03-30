package br.com.linketinder.service

import br.com.linketinder.dao.CompetenciaDAO
import br.com.linketinder.model.entity.Competencia

class CompetenciaService {
    static CompetenciaDAO competenciaDAO

    CompetenciaService() {
        competenciaDAO = new CompetenciaDAO()
    }

    static void listarCompetencias(){
        List<Competencia> listaCompetencias = competenciaDAO.listar()
        listaCompetencias.each {
            println(it)
        }
    }

    static void cadastrarCompetencia(Competencia competencia) {
        boolean cadastroValido = competenciaDAO.inserir(competencia)

        if (cadastroValido) {
            println("Cadastro Realizado com sucesso")
        } else {
            println("Erro ao fazer cadastro")
        }
    }

    static void alterarCompetencia(Competencia competencia) {
        boolean aleracaoValida = competenciaDAO.alterar(competencia)

        if (aleracaoValida) {
            println("Alteração Realizado com sucesso")
        } else {
            println("Erro ao fazer Alteração")
        }
    }
    static void excluirCompetencia(Integer id) {
        boolean exclusaoValida = competenciaDAO.remover(id)

        if (exclusaoValida) {
            println("Exclusão Realizado com sucesso")
        } else {
            println("Erro ao fazer Exclusão")
        }
    }
}

package br.com.linketinder.service

import br.com.linketinder.dao.CompetenciaDAO
import br.com.linketinder.model.entity.Competencia

class CompetenciaService {
    CompetenciaDAO competenciaDAO

    CompetenciaService() {
        competenciaDAO = new CompetenciaDAO()
    }

    boolean listarCompetencias() {
        List<Competencia> listaCompetencias = competenciaDAO.listar()
        listaCompetencias.each {
            println(it)
        }
    }

    boolean cadastrarCompetencia(Competencia competencia) {
        boolean cadastroValido = competenciaDAO.inserir(competencia)

        return cadastroValido
    }

    boolean alterarCompetencia(Competencia competencia) {
        boolean aleracaoValida = competenciaDAO.alterar(competencia)

        return aleracaoValida
    }

    boolean excluirCompetencia(Integer id) {
        boolean exclusaoValida = competenciaDAO.remover(id)

        return exclusaoValida
    }
}

package br.com.linketinder.service

import br.com.linketinder.dao.CompetenciaDAO
import br.com.linketinder.model.entity.Competencia

class CompetenciaService {
    static CompetenciaDAO competenciaDAO

    CompetenciaService() {
        competenciaDAO = new CompetenciaDAO()
    }

    static boolean listarCompetencias(){
        List<Competencia> listaCompetencias = competenciaDAO.listar()
        listaCompetencias.each {
            println(it)
        }
    }

    static boolean cadastrarCompetencia(Competencia competencia) {
        boolean cadastroValido = competenciaDAO.inserir(competencia)

        return cadastroValido
    }

    static boolean alterarCompetencia(Competencia competencia) {
        boolean aleracaoValida = competenciaDAO.alterar(competencia)

        aleracaoValida
    }

    static boolean excluirCompetencia(Integer id) {
        boolean exclusaoValida = competenciaDAO.remover(id)

        return exclusaoValida
    }
}

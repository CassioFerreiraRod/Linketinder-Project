package br.com.linketinder.controller

import br.com.linketinder.model.entity.Competencia
import br.com.linketinder.model.factory.CompetenciaFactory
import br.com.linketinder.service.CompetenciaService

class CompetenciaController {
    CompetenciaService competenciaService

    CompetenciaController() {
        this.competenciaService = new CompetenciaService()
    }

    void cadastraCompetencia(String competencia) {
        competenciaService.cadastrarCompetencia(CompetenciaFactory.criarCompetencia(competencia))
    }

    void listarCompetencias() {
        competenciaService.listarCompetencias()
    }

    void alterarCompetencia(Competencia competencia){
        competenciaService.alterarCompetencia(competencia)
    }

    void excluirCompetencia(int id) {
        competenciaService.excluirCompetencia(id)
    }

    void cadastrarCandidatoCompetencia(List<String> competencias) {
        competenciaService.cadastrarCandidatoCompetencia(competencias)

    }
    void cadastrarVagaCompetencia(List<String> competencias) {
        competenciaService.cadastrarVagaCompetencia(competencias)
    }
}

package br.com.linketinder.model.factory

import br.com.linketinder.model.entity.Competencia

class CompetenciaFactory {

    static Competencia criarCompetencia(String competencia) {
        return new Competencia(competencia)
    }

}

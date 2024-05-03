package br.com.linketinder.view.menu.competencia

import br.com.linketinder.model.entity.Competencia
import br.com.linketinder.service.CompetenciaService

class MenuInsercao {
    void exibirMenuInsercao(BufferedReader bufferedReader, CompetenciaService competenciaService) {
        println "Digite o nome da nova Competência:"
        String competencia = bufferedReader.readLine()

        Competencia competenciaObjeto = new Competencia(competencia)

        competenciaService.cadastrarCompetencia(competenciaObjeto)
    }
}
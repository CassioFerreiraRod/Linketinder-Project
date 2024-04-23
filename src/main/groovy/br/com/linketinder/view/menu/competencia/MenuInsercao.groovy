package br.com.linketinder.view.menu.competencia

import br.com.linketinder.controller.CompetenciaController

class MenuInsercao {
    void exibirMenuInsercao(BufferedReader bufferedReader, CompetenciaController competenciaController) {
        println "Digite o nome da nova Competência:"
        String competencia = bufferedReader.readLine()

        competenciaController.cadastraCompetencia(competencia)
    }
}
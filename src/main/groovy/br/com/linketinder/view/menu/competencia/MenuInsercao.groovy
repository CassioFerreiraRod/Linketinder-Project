package br.com.linketinder.view.menu.competencia

import br.com.linketinder.model.entity.Competencia
import br.com.linketinder.service.CompetenciaService

class MenuInsercao {
    static void menuInsercao(BufferedReader bufferedReader, CompetenciaService competenciaService) {
        println "Digite o nome da nova Competência:"
        String comptencia = bufferedReader.readLine()

        Competencia novaCompetencia = new Competencia(comptencia)


        CompetenciaService.cadastrarCompetencia(novaCompetencia)
    }
}

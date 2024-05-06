package br.com.linketinder.view.menu.competencia

import br.com.linketinder.service.CompetenciaService

class MenuExclusao {
    void exibirMenuExclusao(BufferedReader bufferedReader, CompetenciaService competenciaService) {
        competenciaService.listarCompetencias().each {
            println it
        }
        println "Digite o id da competência que deseja excluir:"
        int id = Integer.parseInt(bufferedReader.readLine())

        competenciaService.excluirCompetencia(id)
    }
}

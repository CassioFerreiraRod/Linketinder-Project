package br.com.linketinder.view.menu.competencia

import br.com.linketinder.controller.CompetenciaController

class MenuExclusao {
    void exibirMenuExclusao(BufferedReader bufferedReader, CompetenciaController competenciaController) {
        competenciaController.listarCompetencias()
        println "Digite o id da competência que deseja excluir:"
        int id = Integer.parseInt(bufferedReader.readLine())

        competenciaController.excluirCompetencia(id)
    }
}

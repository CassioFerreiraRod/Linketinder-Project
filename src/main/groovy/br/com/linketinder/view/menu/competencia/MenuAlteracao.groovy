package br.com.linketinder.view.menu.competencia

import br.com.linketinder.controller.CompetenciaController
import br.com.linketinder.model.entity.Competencia

class MenuAlteracao {
     void exibirMenuAlteracao(BufferedReader bufferedReader, CompetenciaController competenciaController) {
        competenciaController.listarCompetencias()

        println "Digite o id da competência que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        println "Altere o nome:"
        String competencia = bufferedReader.readLine()


        Competencia competenciaAlterada = new Competencia(id, competencia)

        competenciaController.alterarCompetencia(competenciaAlterada)

    }
}

package br.com.linketinder.view.menu.competencia

import br.com.linketinder.service.CompetenciaService

class MenuExclusao {
    static void menuExclusao(BufferedReader bufferedReader,CompetenciaService competenciaService) {
        CompetenciaService.listarCompetencias()
        println "Digite o id da competência que deseja excluir:"
        int id = Integer.parseInt(bufferedReader.readLine())

        CompetenciaService.excluirCompetencia(id)
    }
}

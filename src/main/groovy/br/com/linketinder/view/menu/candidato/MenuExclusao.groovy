package br.com.linketinder.view.menu.candidato

import br.com.linketinder.service.CandidatoService

class MenuExclusao {
    static void menuExclusao(BufferedReader bufferedReader,CandidatoService candidatoService) {
        CandidatoService.listarCandidatos()
        println "Digite o id do candidato que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        CandidatoService.excluirCandidato(id)
    }
}

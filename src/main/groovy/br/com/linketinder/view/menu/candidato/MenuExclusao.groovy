package br.com.linketinder.view.menu.candidato

import br.com.linketinder.controller.CandidatoController

class MenuExclusao {
    CandidatoController controller
    void exibirMenuExclusao(BufferedReader bufferedReader) {
        controller = new CandidatoController()
        controller.listarCandidatos()
        println "Digite o id do candidato que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        controller.excluirCandidato(id)
    }
}

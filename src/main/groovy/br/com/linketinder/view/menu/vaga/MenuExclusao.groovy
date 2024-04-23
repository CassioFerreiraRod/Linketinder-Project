package br.com.linketinder.view.menu.vaga

import br.com.linketinder.controller.VagaController

class MenuExclusao {
    void exibirMenuExclusao(BufferedReader bufferedReader, VagaController vagaController) {
        vagaController.listarVagas()
        println "Digite o id da vaga que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        vagaController.excluirVaga(id)
    }
}

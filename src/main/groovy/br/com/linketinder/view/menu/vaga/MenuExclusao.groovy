package br.com.linketinder.view.menu.vaga

import br.com.linketinder.service.VagaService

class MenuExclusao {
    void exibirMenuExclusao(BufferedReader bufferedReader, VagaService vagaService) {
        vagaService.listarVagas()
        println "Digite o id da vaga que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        vagaService.excluirVaga(id)
    }
}

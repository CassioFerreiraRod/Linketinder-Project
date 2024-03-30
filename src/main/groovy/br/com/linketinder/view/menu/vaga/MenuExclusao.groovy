package br.com.linketinder.view.menu.vaga

import br.com.linketinder.service.VagaService

class MenuExclusao {
    static void menuExclusao(BufferedReader bufferedReader,VagaService vagaService) {
        VagaService.listarVagas()
        println "Digite o id da vaga que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        VagaService.excluirVaga(id)
    }
}

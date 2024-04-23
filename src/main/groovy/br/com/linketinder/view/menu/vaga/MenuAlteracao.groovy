package br.com.linketinder.view.menu.vaga

import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.controller.VagaController

class MenuAlteracao {
    void exibirMenuAlteracao(BufferedReader bufferedReader, VagaController vagaController) {
        vagaController.listarVagas()

        println "Digite o id da vaga que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        println "Altere o nome da vaga:"
        String nome = bufferedReader.readLine()

        println "Altere a descrição da vaga:"
        String descricao = bufferedReader.readLine()

        println "Altere o cidade da vaga:"
        String cidade = bufferedReader.readLine()

        println "Altere o estado vaga:"
        String estado = bufferedReader.readLine()

        println "Altere o nome da empresa:"
        String empresa = bufferedReader.readLine()

        Vaga vagaAlterada = new Vaga(id, nome, descricao, cidade, estado, empresa)
        vagaController.atualizaVaga(vagaAlterada)

    }
}

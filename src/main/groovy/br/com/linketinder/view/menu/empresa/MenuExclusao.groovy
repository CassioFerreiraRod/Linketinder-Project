package br.com.linketinder.view.menu.empresa

import br.com.linketinder.controller.EmpresaController

class MenuExclusao {
     void exibirMenuExclusao(BufferedReader bufferedReader, EmpresaController empresaController) {
        empresaController.listarEmpresas()
        println "Digite o id do empresa que deseja excluir:"
        int id = Integer.parseInt(bufferedReader.readLine())

        empresaController.excluirEmpresa(id)
    }
}
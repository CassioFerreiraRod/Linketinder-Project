package br.com.linketinder.view.menu.empresa

import br.com.linketinder.service.EmpresaService

class MenuExclusao {
     void exibirMenuExclusao(BufferedReader bufferedReader, EmpresaService empresaService) {
        empresaService.listarEmpresas()
        println "Digite o id do empresa que deseja excluir:"
        int id = Integer.parseInt(bufferedReader.readLine())

        empresaService.excluirEmpresa(id)
    }
}

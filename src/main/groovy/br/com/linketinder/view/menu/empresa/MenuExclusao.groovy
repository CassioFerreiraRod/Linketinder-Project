package br.com.linketinder.view.menu.empresa

import br.com.linketinder.service.EmpresaService

class MenuExclusao {
    static void menuExclusao(BufferedReader bufferedReader,EmpresaService empresaService) {
        EmpresaService.listarEmpresas()
        println "Digite o id do empresa que deseja excluir:"
        int id = Integer.parseInt(bufferedReader.readLine())

        EmpresaService.excluirEmpresa(id)
    }
}

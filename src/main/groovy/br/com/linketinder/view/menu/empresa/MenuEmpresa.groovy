package br.com.linketinder.view.menu.empresa


import br.com.linketinder.controller.EmpresaController

class MenuEmpresa {
    EmpresaController empresaController

    void exibirMenuEmpresas(BufferedReader bufferedReader) {
        MenuInsercao menuInsercao = new MenuInsercao()
        MenuAlteracao menuAlteracao = new MenuAlteracao()
        MenuExclusao menuExclusao = new MenuExclusao()

        empresaController = new EmpresaController()
        boolean continuar = true
        String opcao
        while (continuar) {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todas as Empresas")
            println("2. Cadastrar Empresa")
            println("3. Alterar Empresa")
            println("4. Excluir Empresa")
            println("0. Voltar")
            opcao = bufferedReader.readLine()

            switch (opcao) {
                case '1':
                    empresaController.listarEmpresas()
                    break
                case '2':
                    menuInsercao.exibirMenuInsercao(bufferedReader, empresaController)
                    break
                case '3':
                    menuAlteracao.exibirMenuAlteracao(bufferedReader, empresaController)
                    break
                case '4':
                    menuExclusao.exibirMenuExclusao(bufferedReader, empresaController)
                    break
                case '0':
                    continuar = false
                    println "Voltando..."
                    break
                default:
                    println "Opção inválida"
                    break

            }
        }
    }
}

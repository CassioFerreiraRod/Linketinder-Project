package br.com.linketinder.view.menu.empresa


import br.com.linketinder.service.EmpresaService

class MenuEmpresa {
    EmpresaService empresaService

    void exibirMenuEmpresas(BufferedReader bufferedReader) {
        MenuInsercao menuInsercao = new MenuInsercao()
        MenuAlteracao menuAlteracao = new MenuAlteracao()
        MenuExclusao menuExclusao = new MenuExclusao()

        empresaService = new EmpresaService()
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
                    empresaService.listarEmpresas().each {
                        println it
                    }
                    break
                case '2':
                    menuInsercao.exibirMenuInsercao(bufferedReader, empresaService)
                    break
                case '3':
                    menuAlteracao.exibirMenuAlteracao(bufferedReader, empresaService)
                    break
                case '4':
                    menuExclusao.exibirMenuExclusao(bufferedReader, empresaService)
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

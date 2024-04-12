package br.com.linketinder.view.menu.empresa

import br.com.linketinder.service.EmpresaService

class MenuEmpresa {
    static EmpresaService empresaService

    static void menuEmpresas(BufferedReader bufferedReader) {
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
                    EmpresaService.listarEmpresas()
                    break
                case '2':
                    MenuInsercao.menuInsercao(bufferedReader, empresaService)
                    break
                case '3':
                   MenuAlteracao.menuAlteracao(bufferedReader, empresaService)
                    break
                case '4':
                    MenuExclusao.menuExclusao(bufferedReader, empresaService)
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

package br.com.linketinder.view.menu.vaga

import br.com.linketinder.service.VagaService

class MenuVaga {
     VagaService vagaService

     void exibirMenuVagas(BufferedReader bufferedReader) {
         MenuInsercao menuInsercao = new MenuInsercao()
         MenuAlteracao menuAlteracao = new MenuAlteracao()
         MenuExclusao menuExclusao = new MenuExclusao()

        vagaService = new VagaService()
        boolean continuar = true
        String opcao
        while (continuar) {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todas os Vagas")
            println("2. Cadastrar Vaga")
            println("3. Alterar Vaga")
            println("4. Excluir Vaga")
            println("0. Voltar")
            opcao = bufferedReader.readLine()

            switch (opcao) {
                case '1':
                    vagaService.listarVagas()
                    break
                case '2':
                    menuInsercao.exibirMenuInsercao(bufferedReader, vagaService)
                    break
                case '3':
                    menuAlteracao.exibirMenuAlteracao(bufferedReader, vagaService)
                    break
                case '4':
                    menuExclusao.exibirMenuExclusao(bufferedReader, vagaService)
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

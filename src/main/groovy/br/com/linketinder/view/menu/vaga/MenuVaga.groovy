package br.com.linketinder.view.menu.vaga

import br.com.linketinder.service.VagaService

class MenuVaga {
    static VagaService candidatoService

    static void menuVagas(BufferedReader bufferedReader) {
        candidatoService = new VagaService()
        boolean continuar = true
        def opcao
        while (continuar) {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todos os Vagas")
            println("2. Cadastrar Vaga")
            println("3. Alterar Vaga")
            println("4. Excluir Vaga")
            println("0. Voltar")
            opcao = bufferedReader.readLine()

            switch (opcao) {
                case '1':
                    VagaService.listarVagas()
                    break
                case '2':
                    MenuInsercao.menuInsercao(bufferedReader, candidatoService)
                    break
                case '3':
                    MenuAlteracao.menuAlteracao(bufferedReader, candidatoService)
                    break
                case '4':
                    MenuExclusao.menuExclusao(bufferedReader, candidatoService)
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

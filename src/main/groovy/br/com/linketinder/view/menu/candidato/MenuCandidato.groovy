package br.com.linketinder.view.menu.candidato

import br.com.linketinder.controller.CandidatoController

class MenuCandidato {
    CandidatoController controller = new CandidatoController()

    void exibirMenuCandidatos(BufferedReader bufferedReader) {
        boolean continuar = true
        String opcao
        while (continuar) {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todos os Candidatos")
            println("2. Cadastrar Candidato")
            println("3. Alterar Candidato")
            println("4. Excluir Candidato")
            println("0. Voltar")
            opcao = bufferedReader.readLine()

            switch (opcao) {
                case '1':
                    controller.listarCandidatos()
                    break
                case '2':
//                    menuInsercao.exibirMenuInsercao(bufferedReader, candidatoService)
                    break
                case '3':
//                    menuAlteracao.exibirMenuAlteracao(bufferedReader, candidatoService)
                    break
                case '4':
//                    menuExclusao.exibirMenuExclusao(bufferedReader, candidatoService)
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

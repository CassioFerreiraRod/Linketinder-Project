package br.com.linketinder.view.menu.candidato

import br.com.linketinder.controller.CandidatoController

class MenuCandidato {
    CandidatoController controller = new CandidatoController()
    MenuInsercao menuInsercao
    MenuAlteracao menuAlteracao
    MenuExclusao menuExclusao

    void exibirMenuCandidatos(BufferedReader bufferedReader) {
        menuInsercao = new MenuInsercao()
        menuAlteracao = new MenuAlteracao()
        menuExclusao = new MenuExclusao()
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
                    menuInsercao.exibirMenuInsercao(bufferedReader)
                    break
                case '3':
                    menuAlteracao.exibirMenuAlteracao(bufferedReader)
                    break
                case '4':
                    menuExclusao.exibirMenuExclusao(bufferedReader)
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

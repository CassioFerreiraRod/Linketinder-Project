package br.com.linketinder.view.menu.candidato


import br.com.linketinder.service.CandidatoService

class MenuCandidato {
    static CandidatoService candidatoService

    static void menuCandidatos(BufferedReader bufferedReader) {
        candidatoService = new CandidatoService()
        boolean continuar = true
        def opcao
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
                    CandidatoService.listarCandidatos()
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

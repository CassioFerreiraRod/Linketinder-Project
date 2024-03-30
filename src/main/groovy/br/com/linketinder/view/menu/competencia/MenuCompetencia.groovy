package br.com.linketinder.view.menu.competencia

import br.com.linketinder.service.CompetenciaService

class MenuCompetencia {
    static CompetenciaService competenciaService

    static void menuCompetencias(BufferedReader bufferedReader) {
        competenciaService = new CompetenciaService()
        boolean continuar = true
        def opcao
        while (continuar) {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todas as Competencias")
            println("2. Cadastrar Competencia")
            println("3. Alterar Competencia")
            println("4. Excluir Competencia")
            println("0. Voltar")
            opcao = bufferedReader.readLine()

            switch (opcao) {
                case '1':
                    CompetenciaService.listarCompetencias()
                    break
                case '2':
                    MenuInsercao.menuInsercao(bufferedReader, competenciaService)
                    break
                case '3':
                   MenuAlteracao.menuAlteracao(bufferedReader, competenciaService)
                    break
                case '4':
                    MenuExclusao.menuExclusao(bufferedReader, competenciaService)
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

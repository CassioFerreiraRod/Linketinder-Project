package br.com.linketinder.view.menu.competencia

import br.com.linketinder.service.CompetenciaService

class MenuCompetencia {
    CompetenciaService competenciaService
    MenuAlteracao menuAlteracao = new MenuAlteracao()
    MenuExclusao menuExclusao = new MenuExclusao()
    MenuInsercao menuInsercao = new MenuInsercao()

    void exibirMenuCompetencias(BufferedReader bufferedReader) {
        competenciaService = new CompetenciaService()
        boolean continuar = true
        String opcao
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
                    competenciaService.listarCompetencias()
                    break
                case '2':
                    menuInsercao.exibirMenuInsercao(bufferedReader, competenciaService)
                    break
                case '3':
                    menuAlteracao.exibirMenuAlteracao(bufferedReader, competenciaService)
                    break
                case '4':
                    menuExclusao.exibirMenuExclusao(bufferedReader, competenciaService)
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

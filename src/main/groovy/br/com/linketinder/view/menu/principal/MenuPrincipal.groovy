package br.com.linketinder.view.menu.principal

import br.com.linketinder.view.menu.candidato.MenuCandidato
import br.com.linketinder.view.menu.competencia.MenuCompetencia
import br.com.linketinder.view.menu.empresa.MenuEmpresa
import br.com.linketinder.view.menu.vaga.MenuVaga


class MenuPrincipal {

    void exibirMenu() {
        MenuCandidato menuCandidato = new MenuCandidato()
        MenuCompetencia menuCompetencia = new MenuCompetencia()
        MenuVaga menuVaga = new MenuVaga()
        MenuEmpresa menuEmpresa = new MenuEmpresa()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        String opcao

        boolean continuar = true

        while (continuar) {
            println "Escolha uma das opções a seguir"
            println "1. Exibir menu Candidatos"
            println "2. Exibir menu empresas"
            println "3. Exibir menu competências"
            println "4. Exibir menu vagas"
            println "0. Para sair"
            opcao = br.readLine()

            switch (opcao) {
                case '1':
                    menuCandidato.menuCandidatos(br)
                    break
                case '2':
                    menuEmpresa.menuEmpresas(br)
                    break
                case '3':
                    menuCompetencia.menuCompetencias(br)
                    break
                case '4':
                    menuVaga.menuVagas(br)
                    break
                case '0':
                    continuar = false
                    println "Saindo..."
                    break
                default:
                    println "Opção inválida"
                    break

            }
        }
    }

}
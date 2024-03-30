package br.com.linketinder.view.menu.principal

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.view.menu.candidato.MenuCandidato


class MenuPrincipal {

    CandidatoDAO candidatoDAO = new CandidatoDAO()

    void exibirMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        def opcao

        boolean continuar = true

        while (continuar) {
            println "Escolha uma das opções a seguir"
            println "1. Exibir menu Candidatos"
            println "2. Exibir menu empresas"
            println "3. Exibir menu vagas"
            println "4. Exibir menu competências"
            println "0. Para sair"
            opcao = br.readLine()

            switch (opcao) {
                case '1':
                    MenuCandidato.menuCandidatos(br)
                    break
                case '2':

                    break
                case '3':

                    break
                case '4':

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
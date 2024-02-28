package br.com.linketinder.menu

import br.com.linketinder.cadastro.Cadastro

class Menu {

    def cadastro = new Cadastro()

    void exibirMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        def opcao

        do {
            println "Escolha uma das opções a seguir"
            println "1. Listar candidatos"
            println "2. Listar empresas"
            println "0. Para sair"
            opcao = br.readLine()

            switch (opcao) {
                case '1':
                    cadastro.listarCandidatos()
                    break
                case '2':
                    cadastro.listarEmpresas()
                    break
                case '0':
                    println "Saindo..."
                    break
                default:
                    println "Opção inválida"
                    break
            }

        } while (opcao != '0')
    }
}

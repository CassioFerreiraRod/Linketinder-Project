package br.com.linketinder.view

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Cadastro


class Menu {

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
                   menuCandidatos(br)
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

   void menuCandidatos(BufferedReader bufferedReader) {
        boolean continuar = true
       def opcao
       while (continuar) {
           println("Escolha uma das opções a seguir:")
           println("1. Listar Todos os Candidatos")
           println("2. Cadastrar Candidato")
           println("3. Atualizar Candidato")
           println("4. Excluir Candidato")
           println("0. Voltar")
           opcao = bufferedReader.readLine()

           switch (opcao) {
               case '1':
                   println candidatoDAO.listar()
                   break
               case '2':

                   break
               case '3':

                   break
               case '4':

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
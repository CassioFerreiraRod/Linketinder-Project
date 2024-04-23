package br.com.linketinder.view.menu.candidato

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.controller.CompetenciaController

class MenuInsercao {
   CandidatoController controller
   CompetenciaController competenciaController
     void exibirMenuInsercao(BufferedReader bufferedReader) {
        controller = new CandidatoController()
        competenciaController = new CompetenciaController()
        println "Digite o nome:"
        String nome = bufferedReader.readLine()

        println "Digite o sobrenome:"
        String sobrenome = bufferedReader.readLine()

        println "Digite o email:"
        String email = bufferedReader.readLine()

        println "Digite o cep:"
        String cep = bufferedReader.readLine()

        println "Digite o estado:"
        String estado = bufferedReader.readLine()

        println "Digite o pais:"
        String pais = bufferedReader.readLine()

        println "Digite a descrição:"
        String descricao = bufferedReader.readLine()

        println "Digite o cpf:"
        String cpf = bufferedReader.readLine()

        println "Digite a data de nascimento: dd/mm/yyyy"
        String dataNascimento = bufferedReader.readLine()

        println "Digite a senha:"
        String senha = bufferedReader.readLine()

        controller.cadastraCandidato(nome, sobrenome, email, cep, estado, pais, descricao, cpf, dataNascimento, senha)

        println "Listando competências cadastradas:"

        competenciaController.listarCompetencias()

        println "Digite as competências:(separar por vírgula, entre as competências listada)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        competenciaController.cadastrarCandidatoCompetencia(listaCompetencias)
        println("Cadastro realizado com sucesso")
    }
}
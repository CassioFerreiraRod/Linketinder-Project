package br.com.linketinder.view.menu.candidato

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.service.CandidatoService
import br.com.linketinder.service.CompetenciaService

class MenuInsercao {
     void exibirMenuInsercao(BufferedReader bufferedReader, CandidatoService candidatoService) {
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

        Candidato novoCandidato = new Candidato(nome, sobrenome, email, cep, estado, pais,
                descricao, cpf, dataNascimento, senha)

        CandidatoService.cadastrarCandidato(novoCandidato)

        println "Listando competências cadastradas:"
        CompetenciaService competenciaService = new CompetenciaService()
        CompetenciaService.listarCompetencias()

        println "Digite as competências:(separar por vírgula, entre as competências listada)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        candidatoService.cadastrarCandidatoCompetencia(listaCompetencias)
        println("Cadastro realizado com sucesso")
    }
}

package br.com.linketinder.view.menu.candidato

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.service.CandidatoService
import br.com.linketinder.service.CompetenciaService

class MenuInsercao {
    CandidatoService service
    CompetenciaService competenciaService

    void exibirMenuInsercao(BufferedReader bufferedReader) {
        service = new CandidatoService()
        competenciaService = new CompetenciaService()
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

        Candidato candidato = new Candidato(nome, sobrenome, email, cep, estado, pais, descricao, cpf, dataNascimento, senha)

        service.cadastrarCandidato(candidato)

        println "Listando competências cadastradas:"

        competenciaService.listarCompetencias()

        println "Digite as competências:(separar por vírgula, entre as competências listada)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        competenciaService.cadastrarCandidatoCompetencia(listaCompetencias)
        println("Cadastro realizado com sucesso")
    }
}
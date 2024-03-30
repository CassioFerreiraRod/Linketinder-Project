package br.com.linketinder.view.menu.candidato

import br.com.linketinder.model.entity.Candidato

class MenuInsercao {
    static void menuInsercao(BufferedReader bufferedReader,CandidatoService) {
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
        println "Digite as competências:(separar por vírgula)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        CandidatoService.cadastrarCandidatoCompetencia(listaCompetencias)
    }
}

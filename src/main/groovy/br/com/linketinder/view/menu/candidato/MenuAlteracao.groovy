package br.com.linketinder.view.menu.candidato

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.service.CandidatoService

class MenuAlteracao {
    static void menuAlteracao(BufferedReader bufferedReader, CandidatoService candidatoService) {
        CandidatoService.listarCandidatos()

        println "Digite o id do candidato que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        println "Altere o nome:"
        String nome = bufferedReader.readLine()

        println "Altere o sobrenome:"
        String sobrenome = bufferedReader.readLine()

        println "Altere o email:"
        String email = bufferedReader.readLine()

        println "Altere o cep:"
        String cep = bufferedReader.readLine()

        println "Altere o estado:"
        String estado = bufferedReader.readLine()

        println "Altere o pais:"
        String pais = bufferedReader.readLine()

        println "Altere a descrição:"
        String descricao = bufferedReader.readLine()

        println "Altere o cpf:"
        String cpf = bufferedReader.readLine()

        println "Altere a data de nascimento: dd/mm/yyyy"
        String dataNascimento = bufferedReader.readLine()

        println "Altere a senha:"
        String senha = bufferedReader.readLine()

        Candidato candidatoAlterado = new Candidato(id, nome, sobrenome, email, cep, estado, pais,
                descricao, cpf, dataNascimento, senha)

        CandidatoService.alterarCandidato(candidatoAlterado)

    }
}

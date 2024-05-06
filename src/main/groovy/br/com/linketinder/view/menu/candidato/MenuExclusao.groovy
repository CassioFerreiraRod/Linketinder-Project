package br.com.linketinder.view.menu.candidato

import br.com.linketinder.service.CandidatoService

class MenuExclusao {
    CandidatoService service
    void exibirMenuExclusao(BufferedReader bufferedReader) {
        service = new CandidatoService()
        service.listarCandidatos().each {
            println it
        }
        println "Digite o id do candidato que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        service.excluirCandidato(id)
    }
}

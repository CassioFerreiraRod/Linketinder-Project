package br.com.linketinder.view.menu.candidato

import br.com.linketinder.service.CandidatoService

class MenuExclusao {
    void exibirMenuExclusao(BufferedReader bufferedReader, CandidatoService candidatoService) {
        candidatoService.listarCandidatos()
        println "Digite o id do candidato que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        candidatoService.excluirCandidato(id)
    }
}

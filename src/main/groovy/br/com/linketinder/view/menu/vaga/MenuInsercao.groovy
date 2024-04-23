package br.com.linketinder.view.menu.vaga

import br.com.linketinder.controller.CompetenciaController
import br.com.linketinder.controller.EmpresaController
import br.com.linketinder.controller.VagaController

class MenuInsercao {
     void exibirMenuInsercao(BufferedReader bufferedReader, VagaController vagaController) {
        println "Digite o nome da vaga:"
        String nome = bufferedReader.readLine()

        println "Digite a descrição da vaga:"
        String descricao = bufferedReader.readLine()

        println "Digite o cidade da vaga:"
        String cidade = bufferedReader.readLine()

        println "Digite o estado vaga:"
        String estado = bufferedReader.readLine()

        println "Listando empresas cadastradas:"

        EmpresaController empresaController = new EmpresaController()
        empresaController.listarEmpresas()

        println "Digite o nome da empresa:(dentre as listadas)"
        String empresa = bufferedReader.readLine()

        vagaController.cadastrarVaga(nome, descricao, cidade, estado, empresa)

        println "Listando competências cadastradas:"

        CompetenciaController competenciaController = new CompetenciaController()
        competenciaController.listarCompetencias()

        println "Digite as competências:(separar por vírgula, dentre as listadas)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        competenciaController.cadastrarVagaCompetencia(listaCompetencias)
    }
}
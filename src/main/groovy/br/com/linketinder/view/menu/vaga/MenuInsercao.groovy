package br.com.linketinder.view.menu.vaga

import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.service.CompetenciaService
import br.com.linketinder.service.EmpresaService
import br.com.linketinder.service.VagaService

class MenuInsercao {
    void exibirMenuInsercao(BufferedReader bufferedReader, VagaService vagaService) {
        println "Digite o nome da vaga:"
        String nome = bufferedReader.readLine()

        println "Digite a descrição da vaga:"
        String descricao = bufferedReader.readLine()

        println "Digite o cidade da vaga:"
        String cidade = bufferedReader.readLine()

        println "Digite o estado vaga:"
        String estado = bufferedReader.readLine()

        println "Listando empresas cadastradas:"

        EmpresaService empresaService = new EmpresaService()
        empresaService.listarEmpresas()

        println "Digite o nome da empresa:(dentre as listadas)"
        String empresa = bufferedReader.readLine()

        Vaga vaga = new Vaga(nome, descricao, cidade, estado, empresa)

        vagaService.cadastrarVaga(vaga)

        println "Listando competências cadastradas:"

        CompetenciaService competenciaService = new CompetenciaService()
        competenciaService.listarCompetencias()

        println "Digite as competências:(separar por vírgula, dentre as listadas)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        competenciaService.cadastrarVagaCompetencia(listaCompetencias)
    }
}
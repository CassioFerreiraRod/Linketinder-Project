package br.com.linketinder.view.menu.vaga

import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.service.CompetenciaService
import br.com.linketinder.service.EmpresaService
import br.com.linketinder.service.VagaService

class MenuInsercao {
    static void menuInsercao(BufferedReader bufferedReader, VagaService candidatoService) {
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
        EmpresaService.listarEmpresas()

        println "Digite o nome da empresa:(dentre as listadas)"
        String empresa = bufferedReader.readLine()

        Vaga novaVaga = new Vaga(nome, descricao, cidade, estado, empresa)

        VagaService.cadastrarVaga(novaVaga)

        println "Listando competências cadastradas:"

        CompetenciaService competenciaService = new CompetenciaService()
        CompetenciaService.listarCompetencias()

        println "Digite as competências:(separar por vírgula, dentre as listadas)"
        String competenciasString = bufferedReader.readLine().trim()
        List<String> listaCompetencias = competenciasString.tokenize(',')

        VagaService.cadastrarVagaCompetencia(listaCompetencias)
    }
}

package br.com.linketinder.view.menu.empresa

import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.service.EmpresaService

class MenuInsercao {
    void exibirMenuInsercao(BufferedReader bufferedReader, EmpresaService empresaService) {
        println "Digite o nome:"
        String nome = bufferedReader.readLine()

        println "Digite o email:"
        String email = bufferedReader.readLine()

        println "Digite o cnpj:"
        String cnpj = bufferedReader.readLine()

        println "Digite o cep:"
        String cep = bufferedReader.readLine()

        println "Digite o estado:"
        String estado = bufferedReader.readLine()

        println "Digite o pais:"
        String pais = bufferedReader.readLine()

        println "Digite a descrição:"
        String descricao = bufferedReader.readLine()

        println "Digite a senha:"
        String senha = bufferedReader.readLine()

        Empresa empresa = new Empresa(nome, estado, cnpj, cep, estado, pais, descricao, senha)

        empresaService.cadastrarEmpresa(empresa)
    }
}
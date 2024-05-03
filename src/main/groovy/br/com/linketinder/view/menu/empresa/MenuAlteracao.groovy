package br.com.linketinder.view.menu.empresa

import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.service.EmpresaService

class MenuAlteracao {
     void exibirMenuAlteracao(BufferedReader bufferedReader, EmpresaService empresaService) {
        empresaService.listarEmpresas()

        println "Digite o id da empresa que deseja alterar:"
        int id = Integer.parseInt(bufferedReader.readLine())

        println "Altere o nome:"
        String nome = bufferedReader.readLine()

        println "Altere o email:"
        String email = bufferedReader.readLine()

        println "Altere o cnpj:"
        String cnpj = bufferedReader.readLine()

        println "Altere o cep:"
        String cep = bufferedReader.readLine()

        println "Altere o estado:"
        String estado = bufferedReader.readLine()

        println "Altere o pais:"
        String pais = bufferedReader.readLine()

        println "Altere a descrição:"
        String descricao = bufferedReader.readLine()

        println "Altere a senha:"
        String senha = bufferedReader.readLine()

        Empresa empresaAlterada = new Empresa(id, nome, email, cnpj, cep, estado, pais, descricao, senha)

        empresaService.alterarEmpresa(empresaAlterada)

    }
}

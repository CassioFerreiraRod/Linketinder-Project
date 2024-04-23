package br.com.linketinder.controller

import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.model.factory.UsuarioFactory
import br.com.linketinder.service.EmpresaService

class EmpresaController {

    EmpresaService empresaService

    EmpresaController() {
        this.empresaService = new EmpresaService()
    }

    void cadastrarEmpresa(String nome, String email, String cnpj, String cep, String estado, String pais, String descricao, String senha) {
        this.empresaService.cadastrarEmpresa(UsuarioFactory.criarEmpresa(nome, email, cnpj, cep, estado, pais, descricao, senha))
    }

    void listarEmpresas() {
        empresaService.listarEmpresas()
    }

    void atualizaEmpresa(Empresa empresa) {
        empresaService.alterarEmpresa(empresa)
    }

    void excluirEmpresa(int id) {
        empresaService.excluirEmpresa(id)
    }
}

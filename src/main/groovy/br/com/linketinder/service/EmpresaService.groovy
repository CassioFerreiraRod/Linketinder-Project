package br.com.linketinder.service

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaService {
    static EmpresaDAO empresaDAO

    EmpresaService() {
        empresaDAO = new EmpresaDAO()
    }

    static void listarEmpresas(){
        List<Empresa> listaEmpresas = empresaDAO.listar()
        listaEmpresas.each {
            println(it)
        }
    }

    static void cadastrarEmpresa(Empresa empresa) {
        boolean cadastroValido = empresaDAO.inserir(empresa)

        if (cadastroValido) {
            println("Cadastro Realizado com sucesso")
        } else {
            println("Erro ao fazer cadastro")
        }
    }

    static void alterarEmpresa(Empresa empresa) {
        boolean aleracaoValida = empresaDAO.alterar(empresa)

        if (aleracaoValida) {
            println("Alteração Realizado com sucesso")
        } else {
            println("Erro ao fazer Alteração")
        }
    }
    static void excluirEmpresa(Integer id) {
        boolean exclusaoValida = empresaDAO.remover(id)

        if (exclusaoValida) {
            println("Exclusão Realizado com sucesso")
        } else {
            println("Erro ao fazer Exclusão")
        }
    }
}

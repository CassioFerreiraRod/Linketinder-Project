package br.com.linketinder.service

import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaService {
    EmpresaDAO empresaDAO

    EmpresaService() {
        empresaDAO = new EmpresaDAO(ConexaoDAO.conectar())
    }

    void listarEmpresas() {
        List<Empresa> listaEmpresas = empresaDAO.listar()
        listaEmpresas.each {
            println(it)
        }
    }

    boolean cadastrarEmpresa(Empresa empresa) {
        return empresaDAO.inserir(empresa)
    }

    boolean alterarEmpresa(Empresa empresa) {
        return empresaDAO.alterar(empresa)
    }

    boolean excluirEmpresa(Integer id) {
        return empresaDAO.remover(id)
    }
}

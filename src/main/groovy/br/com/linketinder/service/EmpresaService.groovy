package br.com.linketinder.service

import br.com.linketinder.conn.ConexaoDB
import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaService {
    EmpresaDAO empresaDAO

    EmpresaService() {
        empresaDAO = new EmpresaDAO(ConexaoDB.conectar())
    }

    List<Empresa> listarEmpresas() {
        List<Empresa> listaEmpresas = empresaDAO.listar()
        return listaEmpresas
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

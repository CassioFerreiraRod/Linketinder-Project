package br.com.linketinder.service

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaService {
    EmpresaDAO empresaDAO

    EmpresaService() {
        empresaDAO = new EmpresaDAO()
    }

    boolean listarEmpresas() {
        List<Empresa> listaEmpresas = empresaDAO.listar()
        listaEmpresas.each {
            println(it)
        }
    }

    boolean cadastrarEmpresa(Empresa empresa) {
        boolean cadastroValido = empresaDAO.inserir(empresa)

        return cadastroValido
    }

    boolean alterarEmpresa(Empresa empresa) {
        boolean aleracaoValida = empresaDAO.alterar(empresa)

        return aleracaoValida
    }

    boolean excluirEmpresa(Integer id) {
        boolean exclusaoValida = empresaDAO.remover(id)

        return exclusaoValida
    }
}

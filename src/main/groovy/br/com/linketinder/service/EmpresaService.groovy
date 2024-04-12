package br.com.linketinder.service

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaService {
    static EmpresaDAO empresaDAO

    EmpresaService() {
        empresaDAO = new EmpresaDAO()
    }

    static boolean listarEmpresas() {
        List<Empresa> listaEmpresas = empresaDAO.listar()
        listaEmpresas.each {
            println(it)
        }
    }

    static boolean cadastrarEmpresa(Empresa empresa) {
        boolean cadastroValido = empresaDAO.inserir(empresa)

        return cadastroValido
    }

    static boolean alterarEmpresa(Empresa empresa) {
        boolean aleracaoValida = empresaDAO.alterar(empresa)

        return aleracaoValida
    }

    static boolean excluirEmpresa(Integer id) {
        boolean exclusaoValida = empresaDAO.remover(id)

        return exclusaoValida
    }
}

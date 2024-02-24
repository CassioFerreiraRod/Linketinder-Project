package br.com.linketinder.pessoa.empresa

import br.com.linketinder.pessoa.Pessoa

class Empresa extends Pessoa {
    String  cnpj, pais

    Empresa(String nome, String email, String cep, String estado, List<String> competencias, String descricao, String cnpj, String pais) {
        super(nome, email, cep, estado, competencias, descricao)
        this.cnpj = cnpj
        this.pais = pais
    }

    @Override
    public String toString() {
        return """\
{
    Nome: ${super.nome},
    Email: ${super.email},
    CNPJ: $cnpj,
    País: $pais,
    Estado: ${super.estado},
    CEP: ${super.cep},
    Descrição aa Empresa: ${super.descricao},
    Competências: ${super.competencias}
}"""
    }
}

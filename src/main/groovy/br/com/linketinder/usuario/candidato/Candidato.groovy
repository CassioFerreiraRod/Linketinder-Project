package br.com.linketinder.usuario.candidato

import br.com.linketinder.usuario.Usuario

class Candidato extends Usuario {
    String  cpf
    int idade

    Candidato(String nome, String email, String cep, String estado, List<String> competencias, String descricao, String cpf, int idade) {
        super(nome, email, cep, estado, competencias, descricao)
        this.cpf = cpf
        this.idade = idade
    }

    @Override
    public String toString() {
        return """\
{
    Nome: ${super.nome},
    Email: ${super.email},
    CPF: $cpf,
    Idade:$idade,
    Estado: ${super.estado},
    Cep: ${super.cep},
    Descricao Pessoal: ${super.descricao},
    Competências: ${super.competencias}
}"""
    }
}

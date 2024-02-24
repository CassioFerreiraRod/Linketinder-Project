package br.com.linketinder.pessoa.candidato

import br.com.linketinder.pessoa.Pessoa

class Candidato extends Pessoa {
    String descricaoPessoal, cpf
    int idade

    Candidato(String nome, String email, String cep, String estado, List<String> competencias, String descricaoPessoal, String cpf, int idade) {
        super(nome, email, cep, estado, competencias)
        this.descricaoPessoal = descricaoPessoal
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
    Descricao Pessoal: $descricaoPessoal,
    Competências: ${super.competencias}
}"""
    }
}

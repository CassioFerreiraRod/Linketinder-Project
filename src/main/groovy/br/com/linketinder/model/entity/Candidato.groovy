package br.com.linketinder.model.entity

class Candidato extends Usuario {
    String cpf, sobrenome, dataNascimento, pais, senha
    List<String> competencias

    Candidato(String nome, String sobrenome, String email, String cep, String estado, String pais,
              String descricao, String cpf, String dataNascimento, List<String> competencias) {
        super(nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.dataNascimento = dataNascimento
        this.competencias = competencias
    }

    Candidato(String nome, String sobrenome, String email, String cep, String estado, String pais,
              String descricao, String cpf, String dataNascimento,String senha) {
        super(nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.senha = senha
        this.dataNascimento = dataNascimento
    }

    Candidato(int id, String nome,  String sobrenome, String email, String cep, String estado, String pais,
              String descricao, String cpf,String dataNascimento, List<String> competencias) {
        super(id, nome, email, cep, estado, descricao)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.dataNascimento = dataNascimento
        this.competencias = competencias
    }

    @Override
    public String toString() {
        return """\
Candidato{
    id: ${super.id},
    Nome: ${super.nome},
    Sobrenome: $sobrenome,
    Email: ${super.email},
    CPF: $cpf,
    Data de nascimento: $dataNascimento,
    Estado: ${super.estado},
    Pais: $pais,
    Cep: ${super.cep},
    Descricao Pessoal: ${super.descricao},
    Competências: $competencias
}"""
    }
}

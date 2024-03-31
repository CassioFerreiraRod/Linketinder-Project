package br.com.linketinder.model.entity

class Vaga {
    int id
    String nome, descricao, cidade, estado, empresa
    List<String> competencias

    Vaga(int id,String empresa, String nome, String descricao, String cidade, String estado, List<String> competencias) {
        this.id = id
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.competencias = competencias
        this.empresa = empresa
    }

    Vaga(String nome, String descricao, String cidade, String estado, String empresa) {
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.empresa = empresa
    }

    Vaga(int id,String nome, String descricao, String cidade, String estado, String empresa) {
        this.nome = nome
        this.descricao = descricao
        this.cidade = cidade
        this.estado = estado
        this.empresa = empresa
        this.id = id
    }

    @Override
    public String toString() {
        return """\
Vaga{
    id: $id,
    Nome: $nome,
    Empresa: $empresa
    Descricao: $descricao,
    Cidade: $cidade,
    Estado: $estado
    Competencias: $competencias
}"""
    }
}

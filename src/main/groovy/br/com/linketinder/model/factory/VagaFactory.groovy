package br.com.linketinder.model.factory;

import br.com.linketinder.model.entity.Vaga;

class VagaFactory {

    static Vaga criarVaga(String nome, String descricao, String cidade, String estado, String empresa) {
        return new Vaga(nome, descricao, cidade, estado, empresa)
    }

}

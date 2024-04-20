package br.com.linketinder.dao;

interface IOperacoesDBCRUD<T> {
    List<T> listar()

    boolean inserir(T entity)

    boolean alterar(T entity)

    boolean remover(Integer id)
}

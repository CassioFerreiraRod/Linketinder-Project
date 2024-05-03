package br.com.linketinder.conn

import java.sql.Connection

interface IConexaoDB {

    void desconectar(Connection connection)

}
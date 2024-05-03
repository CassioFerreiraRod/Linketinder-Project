package br.com.linketinder.conn

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConexaoDB implements IConexaoDB{

    private static final String USUARIO = "postgres"
    private static final String SENHA = "postgres"
    private static final String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"

    static Connection conectar() {
        Properties properties = new Properties()
        properties.setProperty("user", USUARIO)
        properties.setProperty("password", SENHA)
        properties.setProperty("ssl", "false")

        try {
            Class.forName("org.postgresql.Driver")
            return DriverManager.getConnection(URL_SERVIDOR, properties)
        } catch (ClassNotFoundException e) {
            throw e
        } catch (SQLException e) {
            throw e
        }
    }

    static void desconectar(Connection conn) {

        if (conn != null) {
            try {
                conn.close()
            } catch (Exception e) {
                e.printStackTrace()
            }
        }
    }

}

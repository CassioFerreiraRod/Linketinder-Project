package br.com.linketinder.dao

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConexaoDAO {

    ConexaoDAO() {}

    static Connection conectar() {
        Properties properties = new Properties()
        properties.setProperty("user", "postgres")
        properties.setProperty("password", "postgres")
        properties.setProperty("ssl", "false")

        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"

        try {
            Class.forName("org.postgresql.Driver")
            return DriverManager.getConnection(URL_SERVIDOR, properties)
        } catch (ClassNotFoundException e) {
            System.err.println("Verifique o driver de conexão")
        } catch (SQLException e) {
            System.err.println("Verifique se o servidor está ativo: " + e.getMessage())
        }
    }

    static void desconectar(Connection conn) {

        if (conn != null) {
            try {
                conn.close()
            }catch (Exception e) {
                e.printStackTrace()
            }
        }

    }
}

package br.com.linketinder.dao

import java.sql.Connection
import java.sql.DriverManager

class ConexaoDAO {
    public Connection connection

    ConexaoDAO() {}

    static Connection conectar() {
        Properties properties = new Properties()
        properties.setProperty("user", "postgres")
        properties.setProperty("password", "postgres")
        properties.setProperty("ssl", "false")

        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"

        try {
            return DriverManager.getConnection(URL_SERVIDOR, properties)
        } catch (Exception e) {

            e.printStackTrace()
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão")
            } else {
                System.err.println("Verifique se o servidor está ativo");
            }

            return null

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

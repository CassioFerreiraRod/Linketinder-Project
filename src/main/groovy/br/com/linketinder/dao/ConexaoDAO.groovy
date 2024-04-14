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
            e.printStackTrace()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

}

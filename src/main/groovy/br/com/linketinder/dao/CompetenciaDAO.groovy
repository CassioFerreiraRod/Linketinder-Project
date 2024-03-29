package br.com.linketinder.dao

import br.com.linketinder.model.entity.Competencia

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAO {
    Connection conn = null

    List<Competencia> listar() {
        String sql = "SELECT * FROM competencias ORDER BY id"
        List<Competencia> retorno = new ArrayList<>()

        try {

            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)

            ResultSet resultado = stm.executeQuery()
            while (resultado.next()) {
                Competencia competencia = new Competencia(
                        resultado.getInt("id"),
                        resultado.getString("competencia")
                )
                retorno.add(competencia)
            }

        } catch (Exception e) {

            e.printStackTrace()

        } finally {
            if (conn != null) {
                ConexaoDAO.desconectar(conn)
            }
        }
        return retorno
    }

    boolean inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias (competencia) VALUES (?)"
        try {

            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)

            stm.setString(1, competencia.getCompetencia())
            stm.execute()

            return true

        } catch (Exception e) {

            e.printStackTrace()
            return false

        } finally {
            if (conn != null) {
                ConexaoDAO.desconectar(conn)
            }
        }
    }

    boolean alterar(Competencia competencia) {
        String sql = "UPDATE competencias SET competencia = ? WHERE id = ?"

        try {

            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)
            stm.setString(1, competencia.getCompetencia())
            stm.setInt(2, competencia.getId())
            stm.execute()

            return true

        } catch (Exception e) {

            e.printStackTrace()
            return false

        } finally {
            if (conn != null) {
                ConexaoDAO.desconectar(conn)
            }
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM clientes WHERE id=?"
        try {

            this.conn = ConexaoDAO.conectar()
            PreparedStatement stmt = conn.prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.execute()

            return true

        } catch (Exception e) {

            e.printStackTrace()
            return false

        } finally {
            if (conn != null) {
                ConexaoDAO.desconectar(conn)
            }
        }
    }
}

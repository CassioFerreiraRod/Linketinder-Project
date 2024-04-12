package br.com.linketinder.dao

import br.com.linketinder.model.entity.Competencia

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CompetenciaDAO {

    static List<Competencia> listar() {
        String sql = "SELECT * FROM competencias ORDER BY id"
        List<Competencia> retorno = new ArrayList<>()

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            ResultSet resultado = stm.executeQuery()
            while (resultado.next()) {
                Competencia competencia = new Competencia(
                        resultado.getInt("id"),
                        resultado.getString("competencia")
                )
                retorno.add(competencia)
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao listar competência: " + e.getMessage())
        }
        return retorno
    }

    static boolean inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias (competencia) VALUES (?)"
        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, competencia.getCompetencia())
            stm.execute()

            return true

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir competência: " + e.getMessage())
        }
    }

    static boolean alterar(Competencia competencia) {
        String sql = "UPDATE competencias SET competencia = ? WHERE id = ?"

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, competencia.getCompetencia())
            stm.setInt(2, competencia.getId())
            stm.execute()

            return true

        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar competência: " + e.getMessage())
        }
    }

    static boolean remover(Integer id) {
        String sql = "DELETE FROM competencias WHERE id=?"
        try(Connection conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, id)
            stm.execute()

            return true

        } catch (SQLException e) {
            throw new SQLException("Erro ao remover competência: " + e.getMessage())
        }
    }
}

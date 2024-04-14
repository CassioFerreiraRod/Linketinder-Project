package br.com.linketinder.dao

import br.com.linketinder.model.entity.Competencia

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CompetenciaDAO {

    List<Competencia> listar() {
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
            e.printStackTrace()
        }
        return retorno
    }

    boolean inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias (competencia) VALUES (?)"
        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, competencia.getCompetencia())
            stm.execute()

            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean alterar(Competencia competencia) {
        String sql = "UPDATE competencias SET competencia = ? WHERE id = ?"

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, competencia.getCompetencia())
            stm.setInt(2, competencia.getId())
            stm.execute()

            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM competencias WHERE id=?"
        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, id)
            stm.execute()

            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean inserirCandidatoCompetencia(int competencia_id, int candidato_id) {
        String sql = """
                    insert into candidato_competencias (candidato_id, competencia_id)
                    values (?, ?)
                    """

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, candidato_id)
            stm.setInt(2, competencia_id)
            stm.execute()

            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean inserirVagaCompetencia(int competencia_id, int vaga_id) {
        String sql = """
                    insert into vaga_competencias (vaga_id, competencia_id)
                    values (?, ?);
                    """

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, vaga_id)
            stm.setInt(2, competencia_id)

            stm.execute()

            return true

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir competência vaga: " + e.getMessage())
        }
    }

}

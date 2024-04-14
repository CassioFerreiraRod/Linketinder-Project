package br.com.linketinder.dao

import br.com.linketinder.utils.DatabaseUtils
import br.com.linketinder.model.entity.Candidato

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO {

    List<Candidato> listar() {
        String sql = """
                SELECT c.*, es.nome AS estado, p.nome AS pais
                FROM candidatos AS c
                JOIN estados AS es ON c.estado_id = es.id
                JOIN pais AS p on c.pais_id = p.id
                ORDER BY c.id"""
        List<Candidato> retorno = new ArrayList<>()

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            ResultSet resultado = stm.executeQuery()

            adicionaCanditosNaLista(resultado, conn, retorno)

        } catch (SQLException e) {
            e.printStackTrace()
        }
        return retorno
    }


    boolean inserir(Candidato candidato) {
        String sql = "INSERT INTO  candidatos (nome, sobrenome, data_nascimento," +
                "email, cpf, estado_id, pais_id, cep, descricao_pessoal, senha)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, candidato.getEstado())
            int paisId = DatabaseUtils.obterPaisIdPorNome(conn, candidato.getPais())

            stm.setString(1, candidato.getNome())
            stm.setString(2, candidato.getSobrenome())
            stm.setDate(3, candidato.getDataNascimento())
            stm.setString(4, candidato.getEmail())
            stm.setString(5, candidato.getCpf())
            stm.setInt(6, estadoId)
            stm.setInt(7, paisId)
            stm.setString(8, candidato.getCep())
            stm.setString(9, candidato.getDescricao())
            stm.setString(10, candidato.getSenha())
            stm.execute()

            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean alterar(Candidato candidato) {
        String sql = """
            UPDATE candidatos 
            SET nome = ?, sobrenome = ?, data_nascimento = ?, email = ?, cpf = ?, estado_id = ?, pais_id = ?, 
            cep = ?, descricao_pessoal = ?, senha = ?
            WHERE  id = ?
            """

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, candidato.getEstado())
            int paisId = DatabaseUtils.obterPaisIdPorNome(conn, candidato.getPais())

            stm.setString(1, candidato.getNome())
            stm.setString(2, candidato.getSobrenome())
            stm.setDate(3, getDataNascimento())
            stm.setString(4, candidato.getEmail())
            stm.setString(5, candidato.getCpf())
            stm.setInt(6, estadoId)
            stm.setInt(7, paisId)
            stm.setString(8, candidato.getCep())
            stm.setString(9, candidato.getDescricao())
            stm.setString(10, candidato.getSenha())

            stm.setInt(11, candidato.getId())
            stm.execute()

            return true
        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM candidatos where id = ?"

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

    private void adicionaCanditosNaLista(ResultSet resultado, Connection conn, ArrayList<Candidato> retorno) {
        while (resultado.next()) {
            Candidato candidato = new Candidato(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("sobrenome"),
                    resultado.getString("email"),
                    resultado.getString("cep"),
                    resultado.getString("estado"),
                    resultado.getString("pais"),
                    resultado.getString("descricao_pessoal"),
                    resultado.getString("cpf"),
                    resultado.getString("data_nascimento"),
                    DatabaseUtils.competenciasCandidato(resultado.getInt("id"), conn)
            )
            retorno.add(candidato)
        }
    }
}


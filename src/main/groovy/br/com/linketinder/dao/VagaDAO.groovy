package br.com.linketinder.dao

import br.com.linketinder.Utils.DatabaseUtils
import br.com.linketinder.model.entity.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {
    Connection conn = null

    List<Vaga> listar() {
        String sql = """SELECT v.*, es.nome AS estado, e.nome_empresa AS empresa
                FROM vagas AS v
                JOIN estados AS es ON v.estado_id = es.id
                JOIN empresas AS e on v.empresa_id = e.id
                ORDER BY v.id"""
        List<Vaga> retorno = new ArrayList<>()

        try {

            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)
            ResultSet resultado = stm.executeQuery()
            while (resultado.next()) {
                Vaga vaga = new Vaga(
                        resultado.getInt("id"),
                        resultado.getString("empresa"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        DatabaseUtils.competenciasVaga(resultado.getInt("id"), conn)
                )
                retorno.add(vaga)
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


    boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade, estado_id, empresa_id) values (?, ?, ?, ?, ?)"

        try {
            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)
            stm.setString(1, vaga.getNome())
            stm.setString(2, vaga.getDescricao())
            stm.setString(3, vaga.getCidade())

            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, vaga.getEstado())
            stm.setInt(4, estadoId)

            int empresaId = DatabaseUtils.obterEmpresaIdPorNome(conn, vaga.getEmpresa())
            stm.setInt(5, empresaId)

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

    boolean alterar(Vaga vaga) {
        String sql = "UPDATE vagas SET nome = ?, descricao = ?, cidade = ?, estado_id = ?, empresa_id = ? WHERE id = ?"

        try {
            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)

            stm.setString(1, vaga.getNome())
            stm.setString(2, vaga.getDescricao())
            stm.setString(3, vaga.getCidade())

            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, vaga.getEstado())
            stm.setInt(4, estadoId)

            int empresaId = DatabaseUtils.obterEmpresaIdPorNome(conn, vaga.getEmpresa())
            stm.setInt(5, empresaId)

            stm.execute()
            return true

        } catch (Exception e) {
            e.printStackTrace()
            return false
        }

    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM vagas WHERE id = ?"
        try {
            this.conn = ConexaoDAO.conectar()
            PreparedStatement stm = conn.prepareStatement(sql)

            stm.setInt(1, id)
            stm.execute()

        } catch (Exception e) {
            e.printStackTrace()
        }
    }

}

package br.com.linketinder.dao

import br.com.linketinder.utils.DatabaseUtils
import br.com.linketinder.model.entity.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagaDAO {

    Connection conn

    List<Vaga> listar() {
        String sql = """SELECT v.*, es.nome AS estado, e.nome_empresa AS empresa
                FROM vagas AS v
                JOIN estados AS es ON v.estado_id = es.id
                JOIN empresas AS e on v.empresa_id = e.id
                ORDER BY v.id"""
        List<Vaga> retorno = new ArrayList<>()

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            this.conn = ConexaoDAO.conectar()
            ResultSet resultado = stm.executeQuery()
            adicionaVagaNaLista(resultado, conn, retorno)

        } catch (SQLException e) {
            e.printStackTrace()
        } finally {
            this.conn.close()
        }
        return retorno
    }


    boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade, estado_id, empresa_id) values (?, ?, ?, ?, ?)"

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            this.conn = ConexaoDAO.conectar()
            stm.setString(1, vaga.getNome())
            stm.setString(2, vaga.getDescricao())
            stm.setString(3, vaga.getCidade())

            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, vaga.getEstado())
            stm.setInt(4, estadoId)

            int empresaId = DatabaseUtils.obterEmpresaIdPorNome(conn, vaga.getEmpresa())
            stm.setInt(5, empresaId)

            stm.execute()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            this.conn.close()
        }
    }

    boolean alterar(Vaga vaga) {
        String sql = "UPDATE vagas SET nome = ?, descricao = ?, cidade = ?, estado_id = ?, empresa_id = ? WHERE id = ?"

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            this.conn = ConexaoDAO.conectar()

            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, vaga.getEstado())
            int empresaId = DatabaseUtils.obterEmpresaIdPorNome(conn, vaga.getEmpresa())

            stm.setString(1, vaga.getNome())
            stm.setString(2, vaga.getDescricao())
            stm.setString(3, vaga.getCidade())
            stm.setInt(4, estadoId)
            stm.setInt(5, empresaId)
            stm.setInt(6, vaga.getId())

            stm.execute()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            this.conn.close()
        }

    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM vagas WHERE id = ?"
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            this.conn = ConexaoDAO.conectar()

            stm.setInt(1, id)
            stm.execute()

            return true
        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            this.conn.close()
        }
    }

    private void adicionaVagaNaLista(ResultSet resultado, Connection conn, ArrayList<Vaga> retorno) {
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
    }
}

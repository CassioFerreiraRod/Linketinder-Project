package br.com.linketinder.dao

import br.com.linketinder.conn.ConexaoDB
import br.com.linketinder.utils.DAOUtils
import br.com.linketinder.model.entity.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagaDAO implements IOperacoesDBCRUD<Vaga> {

    Connection conn

    VagaDAO(Connection conn) {
        this.conn = conn
    }

    List<Vaga> listar() {
        String sql = """SELECT v.*, es.nome AS estado, e.nome_empresa AS empresa
                FROM vagas AS v
                JOIN estados AS es ON v.estado_id = es.id
                JOIN empresas AS e on v.empresa_id = e.id
                ORDER BY v.id"""
        List<Vaga> retorno = new ArrayList<>()

        try {
            PreparedStatement stm = this.conn.prepareStatement(sql)
            ResultSet resultado = stm.executeQuery()

            adicionaVagaNaLista(resultado, retorno)

        } catch (SQLException e) {
            e.printStackTrace()
        } finally {
            ConexaoDB.desconectar(this.conn)
        }
        return retorno
    }


    boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade, estado_id, empresa_id) values (?, ?, ?, ?, ?)"

        try {
            PreparedStatement stm = this.conn.prepareStatement(sql)
            stm.setString(1, vaga.getNome())
            stm.setString(2, vaga.getDescricao())
            stm.setString(3, vaga.getCidade())

            int estadoId = DAOUtils.obterEstadoIdPorNome(this.conn, vaga.getEstado())
            stm.setInt(4, estadoId)

            int empresaId = DAOUtils.obterEmpresaIdPorNome(this.conn, vaga.getEmpresa())
            stm.setInt(5, empresaId)

            stm.execute()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            ConexaoDB.desconectar(this.conn)
        }
    }

    boolean alterar(Vaga vaga) {
        String sql = "UPDATE vagas SET nome = ?, descricao = ?, cidade = ?, estado_id = ?, empresa_id = ? WHERE id = ?"

        try {
            PreparedStatement stm = this.conn.prepareStatement(sql)

            int estadoId = DAOUtils.obterEstadoIdPorNome(this.conn, vaga.getEstado())
            int empresaId = DAOUtils.obterEmpresaIdPorNome(this.conn, vaga.getEmpresa())

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
            ConexaoDB.desconectar(this.conn)
        }

    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM vagas WHERE id = ?"
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql)
            stm.setInt(1, id)
            stm.execute()

            return true
        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            ConexaoDB.desconectar(this.conn)
        }
    }

    private void adicionaVagaNaLista(ResultSet resultado, ArrayList<Vaga> retorno) {
        while (resultado.next()) {
            Vaga vaga = new Vaga(
                    resultado.getInt("id"),
                    resultado.getString("empresa"),
                    resultado.getString("nome"),
                    resultado.getString("descricao"),
                    resultado.getString("cidade"),
                    resultado.getString("estado"),
                    DAOUtils.competenciasVaga(resultado.getInt("id"), conn)
            )
            retorno.add(vaga)
        }
    }
}

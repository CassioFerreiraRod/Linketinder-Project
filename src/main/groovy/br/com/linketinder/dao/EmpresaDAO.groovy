package br.com.linketinder.dao

import br.com.linketinder.utils.DatabaseUtils
import br.com.linketinder.model.entity.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO {

    List<Empresa> listar() {
        String sql = """
                SELECT emp.*, es.nome AS estado, p.nome AS pais
                FROM empresas AS emp
                JOIN estados AS es ON emp.estado_id = es.id
                JOIN pais AS p on emp.pais_id = p.id
                ORDER BY emp.id"""

        List<Empresa> retorno = new ArrayList<>()

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            ResultSet resultado = stm.executeQuery()

            while (resultado.next()) {
                Empresa empresa = new Empresa(
                        resultado.getInt("id"),
                        resultado.getString("nome_empresa"),
                        resultado.getString("email_corporativo"),
                        resultado.getString("cnpj"),
                        resultado.getString("cep"),
                        resultado.getString("estado"),
                        resultado.getString("pais"),
                        resultado.getString("descricao_empresa")
                )
                retorno.add(empresa)
            }

        } catch (SQLException e) {
            e.printStackTrace()
        }
        return retorno

    }

    boolean inserir(Empresa empresa) {
        String sql = """
                      insert into empresas (nome_empresa, cnpj, email_corporativo, descricao_empresa, estado_id, pais_id, cep, senha)
                      values (?, ?, ?, ?, ?, ?, ?, ?);
                      """

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, empresa.getEstado())
            int paisId = DatabaseUtils.obterPaisIdPorNome(conn, empresa.getPais())

            stm.setString(1, empresa.getNome())
            stm.setString(2, empresa.getCnpj())
            stm.setString(3, empresa.getEmail())
            stm.setString(4, empresa.getDescricao())
            stm.setInt(5, estadoId)
            stm.setInt(6, paisId)
            stm.setString(7, empresa.getCep())
            stm.setString(8, empresa.getSenha())

            stm.execute()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }


    boolean alterar(Empresa empresa) {
        String sql =
                """
                UPDATE empresas 
                SET nome_empresa = ?,
                    cnpj = ?,
                    email_corporativo = ?,
                    descricao_empresa = ?,
                    estado_id = ?,
                    pais_id = ?,
                    cep = ?,
                    senha = ?
                WHERE id = ?;
                """

        try (Connection conn = ConexaoDAO.conectar()
             PreparedStatement stm = conn.prepareStatement(sql)) {
            int estadoId = DatabaseUtils.obterEstadoIdPorNome(conn, empresa.getEstado())
            int paisId = DatabaseUtils.obterPaisIdPorNome(conn, empresa.getPais())

            stm.setString(1, empresa.getNome())
            stm.setString(2, empresa.getCnpj())
            stm.setString(3, empresa.getEmail())
            stm.setString(4, empresa.getDescricao())
            stm.setInt(5, estadoId)
            stm.setInt(6, paisId)
            stm.setString(7, empresa.getCep())
            stm.setString(8, empresa.getSenha())

            stm.setInt(9, empresa.getId())

            stm.execute()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM empresas WHERE id = ?"
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

}

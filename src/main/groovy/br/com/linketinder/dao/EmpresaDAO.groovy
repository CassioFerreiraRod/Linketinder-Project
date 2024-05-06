package br.com.linketinder.dao

import br.com.linketinder.conn.ConexaoDB
import br.com.linketinder.utils.DAOUtils
import br.com.linketinder.model.entity.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO implements IOperacoesDBCRUD<Empresa>{

    Connection conn

    EmpresaDAO(Connection conn) {
        this.conn = conn
    }

    List<Empresa> listar() {
        String sql = """SELECT emp.*, es.nome AS estado, p.nome AS pais
                FROM empresas AS emp
                JOIN estados AS es ON emp.estado_id = es.id
                JOIN pais AS p on emp.pais_id = p.id
                ORDER BY emp.id"""

        List<Empresa> retorno = new ArrayList<>()

        try {
            PreparedStatement stm = conn.prepareStatement(sql)
            this.conn = ConexaoDB.conectar()
            ResultSet resultado = stm.executeQuery()

            adicionarEmpresaNaLista(resultado, retorno)

        } catch (SQLException e) {
            e.printStackTrace()
        } finally {
            ConexaoDB.desconectar(this.conn)
        }
        return retorno

    }


    boolean inserir(Empresa empresa) {
        String sql = """
                      insert into empresas (nome_empresa, cnpj, email_corporativo, descricao_empresa, estado_id, pais_id, cep, senha)
                      values (?, ?, ?, ?, ?, ?, ?, ?);
                      """

        try {
            PreparedStatement stm = conn.prepareStatement(sql)
            this.conn = ConexaoDB.conectar()
            int estadoId = DAOUtils.obterEstadoIdPorNome(conn, empresa.getEstado())
            int paisId = DAOUtils.obterPaisIdPorNome(conn, empresa.getPais())

            stm.setString(1, empresa.getNome())
            stm.setString(2, empresa.getCnpj())
            stm.setString(3, empresa.getEmail())
            stm.setString(4, empresa.getDescricao())
            stm.setInt(5, estadoId)
            stm.setInt(6, paisId)
            stm.setString(7, empresa.getCep())
            stm.setString(8, empresa.getSenha())

            stm.executeQuery()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            ConexaoDB.desconectar(this.conn)
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

        try {
            PreparedStatement stm = conn.prepareStatement(sql)
            this.conn = ConexaoDB.conectar()

            int estadoId = DAOUtils.obterEstadoIdPorNome(conn, empresa.getEstado())
            int paisId = DAOUtils.obterPaisIdPorNome(conn, empresa.getPais())

            stm.setString(1, empresa.getNome())
            stm.setString(2, empresa.getCnpj())
            stm.setString(3, empresa.getEmail())
            stm.setString(4, empresa.getDescricao())
            stm.setInt(5, estadoId)
            stm.setInt(6, paisId)
            stm.setString(7, empresa.getCep())
            stm.setString(8, empresa.getSenha())

            stm.setInt(9, empresa.getId())

            stm.executeUpdate()
            return true

        } catch (SQLException e) {
            e.printStackTrace()
            return false
        } finally {
            ConexaoDB.desconectar(this.conn)
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM empresas WHERE id = ?"
        try {
            PreparedStatement stm = conn.prepareStatement(sql)
            this.conn = ConexaoDB.conectar()

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

    private void adicionarEmpresaNaLista(ResultSet resultado, ArrayList<Empresa> retorno) {
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
    }
}

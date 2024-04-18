package br.com.linketinder.utils

import br.com.linketinder.dao.ConexaoDAO

import java.sql.Connection
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.text.ParseException
import java.text.SimpleDateFormat

class DatabaseUtils {
    static List<String> competenciasVaga(Integer id, Connection conn) {
        String sql = """
                    select c.competencia
                    from public.vaga_competencias AS cv
                    join public.competencias AS c on c.id = cv.competencia_id
                    WHERE cv.vaga_id =  ?
                    """

        List<String> retorno = new ArrayList<>()

        conn = ConexaoDAO.conectar()
        PreparedStatement stm = conn.prepareStatement(sql)
        stm.setInt(1, id)
        ResultSet resultado = stm.executeQuery()

        while (resultado.next()) {
            retorno.add(resultado.getString("competencia"))
        }

        return retorno

    }

    static List<String> competenciasCandidato(Integer id, Connection conn) {
        String sql = """
                    select c.competencia
                    from public.candidato_competencias AS cc
                    join public.competencias AS c on c.id = cc.competencia_id
                    WHERE cc.candidato_id =  ?
                    """

        List<String> retorno = new ArrayList<>()

        conn = ConexaoDAO.conectar()
        PreparedStatement stm = conn.prepareStatement(sql)
        stm.setInt(1, id)
        ResultSet resultado = stm.executeQuery()

        while (resultado.next()) {
            retorno.add(resultado.getString("competencia"))
        }

        return retorno

    }

    static int obterEstadoIdPorNome(Connection conn, String nomeEstado) {
        String sql = "SELECT id FROM estados WHERE nome = ?"

        conn = ConexaoDAO.conectar()
        PreparedStatement stm = conn.prepareStatement(sql)
        stm.setString(1, nomeEstado)

        ResultSet resultado = stm.executeQuery()

        if (resultado.next()) {
            return resultado.getInt("id")
        } else {
            throw new IllegalAccessException()
        }

    }

    static int obterPaisIdPorNome(Connection conn, String nomePais) {
        String sql = "SELECT id FROM pais WHERE nome = ?"

        conn = ConexaoDAO.conectar()
        PreparedStatement stm = conn.prepareStatement(sql)
        stm.setString(1, nomePais)

        ResultSet resultado = stm.executeQuery()

        if (resultado.next()) {
            return resultado.getInt("id")
        } else {
            throw new IllegalAccessException()
        }

    }


    static int obterEmpresaIdPorNome(Connection conn, String nomeEmpresa) throws SQLException{
        String sql = "SELECT id FROM empresas WHERE nome_empresa = ?"

        PreparedStatement stm = conn.prepareStatement(sql)
        stm.setString(1, nomeEmpresa)

        ResultSet resultado = stm.executeQuery()

        if (resultado.next()) {
            return resultado.getInt("id")
        } else {
            throw new IllegalAccessException()
        }

    }

    static int obterIdCandidatoRecente(Connection conn) {
        String sql = "SELECT id FROM candidatos ORDER BY id DESC LIMIT 1"

        PreparedStatement stm = conn.prepareStatement(sql)
        ResultSet resultado = stm.executeQuery()

        if (resultado.next()) {
            return resultado.getInt("id")
        } else {
            throw new IllegalAccessException()
        }

    }

    static List<Integer> obterCompetenciasIdPorNome(Connection conn, List<String> listaCompetencias) {
        String sql = "SELECT id FROM competencias WHERE competencia = ?"

        List<Integer> retorno = new ArrayList<>()

        for (String competencia : listaCompetencias) {

            PreparedStatement stm = conn.prepareStatement(sql)
            stm.setString(1, competencia)

            ResultSet resultado = stm.executeQuery()

            if (resultado.next()) {
                retorno.add(resultado.getInt("id"))
            } else {
                throw new IllegalAccessException()
            }
        }
        return retorno
    }

    static Date converterParaSQLDate(String dataString) {
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
            java.util.Date dataUtil = formatador.parse(dataString)
            return new Date(dataUtil.getTime())
        } catch (ParseException e) {
            return e.printStackTrace()
        }

    }

    static int obterIdVagaRecente(Connection conn) {
        String sql = "SELECT id FROM vagas ORDER BY id DESC LIMIT 1"

        PreparedStatement stm = conn.prepareStatement(sql)
        ResultSet resultado = stm.executeQuery()

        if (resultado.next()) {
            return resultado.getInt("id")
        } else {
            throw new IllegalAccessException()
        }
    }
}

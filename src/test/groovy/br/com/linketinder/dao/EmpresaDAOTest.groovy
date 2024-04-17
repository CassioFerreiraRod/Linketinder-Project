package br.com.linketinder.dao

import br.com.linketinder.model.entity.Empresa
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

import static org.junit.jupiter.api.Assertions.*
import static org.mockito.ArgumentMatchers.anyInt
import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

class EmpresaDAOTest {
    private EmpresaDAO empresaDAO

    @BeforeEach
    void setup() {
        Connection connectionMock = mock(Connection.class)
        PreparedStatement prepareStatementMock = mock(PreparedStatement.class)
        ResultSet resultSetMock = mock(ResultSet.class)

        when(connectionMock.prepareStatement(anyString())).thenReturn(prepareStatementMock)
        when(connectionMock.prepareStatement(anyString(), anyInt(), anyInt())).thenReturn(prepareStatementMock)
        when(prepareStatementMock.executeQuery()).thenReturn(resultSetMock)

        empresaDAO = new EmpresaDAO(conn: connectionMock)
    }

    @Test
    void inserir() {
        // Given:
        Empresa novaEmpresa = new Empresa(
                "Playsoft",
                "palysoft@email.com",
                "55.579.878/0001-90",
                "56842-78",
                "Goiás",
                "Brasil",
                "Movidos por inovação",
                "senha5789")
        // When:
        boolean retorno = empresaDAO.inserir(novaEmpresa)
        // Then:
        assertTrue(retorno)
    }

    @Test
    void listarTest() {
        // Given:
        List<Empresa> empresas
        // When:
        empresas = empresaDAO.listar()
        // Then:
        assertNotNull(empresas)
    }


    @Test
    void alterarTest() {
        // Given:
        Empresa novaEmpresa = new Empresa(
                3,
                "Playsoft",
                "palysoft@email.com",
                "55.579.878/0001-90",
                "56842-78",
                "Goiás",
                "Brasil",
                "Movidos por inovação",
                "senha5789")
        // When:
        boolean retorno = empresaDAO.alterar(novaEmpresa)
        // Then:
        assertTrue(retorno)

    }

    @Test
    void removerTest() {
        // Given:
        int id = 4
        // When:
        boolean retorno = empresaDAO.remover(id)
        // Then:
        assertTrue (retorno)
    }
}
package br.com.linketinder.dao

import br.com.linketinder.model.entity.Vaga
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

class VagaDAOTest {
    private VagaDAO vagaDAO

    @BeforeEach
    void setup() {
        Connection connectionMock = mock(Connection.class)
        PreparedStatement prepareStatementMock = mock(PreparedStatement.class)
        ResultSet resultSetMock = mock(ResultSet.class)

        when(connectionMock.prepareStatement(anyString())).thenReturn(prepareStatementMock)
        when(connectionMock.prepareStatement(anyString(), anyInt(), anyInt())).thenReturn(prepareStatementMock)
        when(prepareStatementMock.executeQuery()).thenReturn(resultSetMock)

        vagaDAO = new VagaDAO(connectionMock)
    }

    @Test
    void inserirTest() {
        // Given:
        Vaga novaVaga = new Vaga(
                "Analista de requisitos",
                "Estamos em busca de um analista de requistos para fazer parte de nossa equipe.",
                "Fortaleza",
                "Ceará",
                "MarketMasters")
        // When:
        boolean retorno = vagaDAO.inserir(novaVaga)
        // Then:
        assertTrue(retorno)
    }

    @Test
    void listarTest() {
        // Given:
        List<Vaga> vagas
        // When:
        vagas = vagaDAO.listar()
        // Then:
        assertNotNull(vagas)
    }

    @Test
    void alterar() {
        // Given:
        Vaga novaVaga = new Vaga(
                4,
                "Analista de requisitos",
                "Estamos em busca de um analista de requistos para fazer parte de nossa equipe.",
                "Fortaleza",
                "Ceará",
                "MarketMasters")
        // When:
        boolean retorno = vagaDAO.alterar(novaVaga)
        // Then:
        assertTrue(retorno)
    }

    @Test
    void removerTest() {
        // Given:
        int id = 4
        // When:
        boolean retorno = vagaDAO.remover(id)
        // Then:
        assertTrue(retorno)
    }
}
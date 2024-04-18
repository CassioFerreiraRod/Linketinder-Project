package br.com.linketinder.dao

import br.com.linketinder.model.entity.Competencia
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

class CompetenciaDAOTest {

    private CompetenciaDAO competenciaDAO

    @BeforeEach
    void setup() {
        Connection connectionMock = mock(Connection.class)
        PreparedStatement prepareStatementMock = mock(PreparedStatement.class)
        ResultSet resultSetMock = mock(ResultSet.class)

        when(connectionMock.prepareStatement(anyString())).thenReturn(prepareStatementMock)
        when(connectionMock.prepareStatement(anyString(), anyInt(), anyInt())).thenReturn(prepareStatementMock)
        when(prepareStatementMock.executeQuery()).thenReturn(resultSetMock)

        competenciaDAO = new CompetenciaDAO(connectionMock)
    }

    @Test
    void inserir() {
        // Given:
        Competencia novaCompetencia = new Competencia(
                "GO")
        // When:
        boolean retorno = competenciaDAO.inserir(novaCompetencia)
        // Then:
        assertTrue(retorno)
    }

    @Test
    void listarTest() {
        // Given:
        List<Competencia> competencias
        // When:
        competencias = competenciaDAO.listar()
        // Then:
        assertNotNull(competencias)
    }


    @Test
    void alterarTest() {
        // Given:
        Competencia novaCompetencia = new Competencia(
                3,
                "Ruby")
        // When:
        boolean retorno = competenciaDAO.alterar(novaCompetencia)
        // Then:
        assertTrue(retorno)

    }

    @Test
    void removerTest() {
        // Given:
        int id = 4
        // When:
        boolean retorno = competenciaDAO.remover(id)
        // Then:
        assertTrue(retorno)
    }

    @Test
    void inserirCandidatoCompetenciaTest() {
        // Given:
        int idCompetencia = 4
        int idCandidato = 4
        // When:
        boolean retorno = competenciaDAO.inserirCandidatoCompetencia(idCompetencia, idCandidato)
        // Then:
        assertTrue(retorno)
    }

    @Test
    void inserirVagaCompetenciaTest() {
        // Given:
        int idCompetencia = 4
        int idCandidato = 4
        // When:
        boolean retorno = competenciaDAO.inserirVagaCompetencia(idCompetencia, idCandidato)
        // Then:
        assertTrue(retorno)
    }
}
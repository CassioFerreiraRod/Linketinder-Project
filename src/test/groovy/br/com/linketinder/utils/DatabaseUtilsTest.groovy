package br.com.linketinder.utils

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.model.entity.Candidato
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.sql.Connection
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet

import static org.junit.Assert.*
import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.mockito.ArgumentMatchers.anyInt
import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

class DatabaseUtilsTest {

    DatabaseUtils databaseUtils
    Connection connectionMock
    private CandidatoDAO candidatoDAO
    private VagaDAO vagaDAO

    @BeforeEach
    void setUp() {
        connectionMock = mock(Connection.class)
        databaseUtils = new DatabaseUtils()
        PreparedStatement prepareStatementMock = mock(PreparedStatement.class)
        ResultSet resultSetMock = mock(ResultSet.class)

        when(connectionMock.prepareStatement(anyString())).thenReturn(prepareStatementMock)
        when(connectionMock.prepareStatement(anyString(), anyInt(), anyInt())).thenReturn(prepareStatementMock)
        when(prepareStatementMock.executeQuery()).thenReturn(resultSetMock)

        candidatoDAO = new CandidatoDAO(ConexaoDAO.conectar())
        vagaDAO = new VagaDAO(ConexaoDAO.conectar())
    }

    @Test
    void obterEstadoIdPorNomeTest() {
        // Given:
        int idEstadoEsperado = 27

        // When:
        int idEstadoObtido = databaseUtils.obterEstadoIdPorNome(connectionMock, "Tocantins")

        // Then:
        assertEquals(idEstadoEsperado, idEstadoObtido)
    }

    @Test
    void obterPaisIdPorNomeTest() {
        // Given:
        int idPaisEsperado = 1
        // When:
        int idPaisObtido = DatabaseUtils.obterPaisIdPorNome(connectionMock, "Brasil")
        // Then:
        assertEquals(idPaisEsperado, idPaisObtido)
    }

    @Test
    void obterEmpresaIdPorNomeTest() {
        // Given:
        int idEmpresaEsperada = 9

        // When:
        int idEmpresaObtida = databaseUtils.obterEmpresaIdPorNome(connectionMock, "Paçoca tech")

        // Then:
        assertEquals(idEmpresaEsperada, idEmpresaObtida)
    }

    @Test
    void obterIdCandidatoRecenteTest() {
        // Given:
        int idCandidatoEsperado = candidatoDAO.listar().last().getId()

        // When:
        int idCandidatoObtido = databaseUtils.obterIdCandidatoRecente(connectionMock)

        // Then:
        assertEquals(idCandidatoEsperado, idCandidatoObtido)
    }

    @Test
    void obterIdVagaRecenteTest() {
        // Given:
        int idVagaEsperado = vagaDAO.listar().last().id

        // When:
        int idVagaObtido = databaseUtils.obterIdVagaRecente(connectionMock)

        // Then:
        assertEquals(idVagaEsperado, idVagaObtido)
    }

    @Test
    void competenciasCandidatoTest() {
        //Given:
        List<String> candidatos

        //When:
        candidatos = databaseUtils.competenciasCandidato(1, connectionMock)

        //Then:
        assertNotNull(candidatos)
    }

    @Test
    void competenciasVagaTest() {
        //Given:
        List<String> vagas

        //When:
        vagas = databaseUtils.competenciasVaga(1, connectionMock)

        //Then:
        assertNotNull(vagas)
    }

    @Test
    void obterCompetenciasIdPorNomeTest() {
        //Given:
        List<String> stringCompetencias = ["Git", "Java"]
        //When:
        databaseUtils.obterCompetenciasIdPorNome(connectionMock, stringCompetencias)
        //Then:
        assertNotNull(stringCompetencias)
    }

    @Test
    void converterParaSQLDateTest() {
        //Given:
        String stringData = "20/07/1999"
        //When:
        Date dataSql = databaseUtils.converterParaSQLDate(stringData)
        //Then:
        assertNotEquals(stringData,dataSql)
    }

}
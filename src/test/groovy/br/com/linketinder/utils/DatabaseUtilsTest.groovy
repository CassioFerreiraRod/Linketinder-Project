package br.com.linketinder.utils

import br.com.linketinder.dao.CandidatoDAO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.sql.Connection

import static org.junit.Assert.*
import static org.mockito.Mockito.mock

class DatabaseUtilsTest {

    static DatabaseUtils databaseUtils
    static Connection connectionMock
    private static CandidatoDAO candidatoDAO

    @BeforeEach
    void setUp() {
        databaseUtils = new DatabaseUtils()
        connectionMock = mock(Connection.class)
        candidatoDAO = new CandidatoDAO(connectionMock)
    }

    @Test
    void obterEstadoIdPorNome() {
        // Given:
        int idEstadoEsperado = 27

        // When:
        int idEstadoObtido = databaseUtils.obterEstadoIdPorNome(connectionMock, "Tocantins")

        // Then:
        assertEquals(idEstadoEsperado, idEstadoObtido)
    }

    @Test
    void obterPaisIdPorNome() {
        // Given:
        int idPaisEsperado = 1
        // When:
        int idPaisObtido = DatabaseUtils.obterPaisIdPorNome(connectionMock, "Brasil")
        // Then:
        assertEquals(idPaisEsperado, idPaisObtido)
    }

    @Test
    void obterEmpresaIdPorNome() {
        // Given:
        int idEmpresaEsperada = 9

        // When:
        int idEmpresaObtida = DatabaseUtils.obterEmpresaIdPorNome(connectionMock, "Paçoca tech")

        // Then:
        assertEquals(idEmpresaEsperada, idEmpresaObtida)
    }

    @Test
    void obterIdCandidatoRecente() {
        // Given:
        int idCandidatoEsperado = candidatoDAO.listar().last().id

        // When:
        int idCandidatoObtido = DatabaseUtils.obterIdCandidatoRecente(connectionMock)

        // Then:
        assertEquals(idCandidatoEsperado, idCandidatoObtido)
    }
}
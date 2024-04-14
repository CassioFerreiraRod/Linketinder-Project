package br.com.linketinder.utils

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.dao.ConexaoDAO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.sql.Connection

import static org.junit.Assert.*

class DatabaseUtilsTest {

    static DatabaseUtils databaseUtils
    static Connection connection
    private static CandidatoDAO candidatoDAO

    @BeforeEach
    void setUp() {
        databaseUtils = new DatabaseUtils()
        connection = ConexaoDAO.conectar()
        candidatoDAO = new CandidatoDAO()
    }

    @Test
    void obterEstadoIdPorNome() {
        // Given:
        int idEstadoEsperado = 27

        // When:
        int idEstadoObtido = DatabaseUtils.obterEstadoIdPorNome(connection, "Tocantins")

        // Then:
        assertEquals(idEstadoEsperado, idEstadoObtido)
    }

    @Test
    void obterPaisIdPorNome() {
        // Given:
        int idPaisEsperado = 1
        // When:
        int idPaisObtido = DatabaseUtils.obterPaisIdPorNome(connection, "Brasil")
        // Then:
        assertEquals(idPaisEsperado, idPaisObtido)
    }

    @Test
    void obterEmpresaIdPorNome() {
        // Given:
        int idEmpresaEsperada = 9

        // When:
        int idEmpresaObtida = DatabaseUtils.obterEmpresaIdPorNome(connection, "Paçoca tech")

        // Then:
        assertEquals(idEmpresaEsperada, idEmpresaObtida)
    }

    @Test
    void obterIdCandidatoRecente() {
        // Given:
        int idCandidatoEsperado = candidatoDAO.listar().last().id

        // When:
        int idCandidatoObtido = DatabaseUtils.obterIdCandidatoRecente(connection)

        // Then:
        assertEquals(idCandidatoEsperado, idCandidatoObtido)
    }
}
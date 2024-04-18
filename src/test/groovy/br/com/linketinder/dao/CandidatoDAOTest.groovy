package br.com.linketinder.dao

import br.com.linketinder.model.entity.Candidato
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

import static org.mockito.ArgumentMatchers.anyInt
import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

import static org.junit.jupiter.api.Assertions.*

class CandidatoDAOTest {
    private CandidatoDAO candidatoDAO

    @BeforeEach
    void setup() {
        Connection connectionMock = mock(Connection.class)
        PreparedStatement prepareStatementMock = mock(PreparedStatement.class)
        ResultSet resultSetMock = mock(ResultSet.class)

        when(connectionMock.prepareStatement(anyString())).thenReturn(prepareStatementMock)
        when(connectionMock.prepareStatement(anyString(), anyInt(), anyInt())).thenReturn(prepareStatementMock)
        when(prepareStatementMock.executeQuery()).thenReturn(resultSetMock)

        candidatoDAO = new CandidatoDAO(connectionMock)
    }

    @Test
    void testeDeInserir() {
        //Given:
        Candidato candidato = new Candidato(
                "Edson",
                "Rodrigues",
                "edson.rodrigues@email",
                "73912-54",
                "Amapá",
                "Brasil",
                "Arquiteto de software",
                "816.556.457-45",
                "18/11/1995",
                "senha45665"
        )

        //When:
        boolean cadastro = candidatoDAO.inserir(candidato)

        //Then:
        assertTrue(cadastro)
    }

    @Test
    void testeDeListar() {
        //Given:
        List<Candidato> candidatos

        //When:
        candidatos = candidatoDAO.listar()

        //Then:
        assertNotNull(candidatos)
    }

    @Test
    void testeDeAlterar() {
        //Given:
        Candidato candidato = new Candidato(
                6,
                "Edson",
                "Rodrigues",
                "edson.rodrigues@email",
                "73912-54",
                "Amapá",
                "Brasil",
                "Arquiteto de software",
                "816.556.457-45",
                "18/11/1995",
                "senha45665"
        )

        //When:
        boolean retorno = candidatoDAO.alterar(candidato)

        //Then:
        assertTrue(retorno)
    }

    @Test
    void testeDeDeletar() {
        //Given:
        Candidato candidato = new Candidato(
                6,
                "Edson",
                "Rodrigues",
                "edson.rodrigues@email",
                "73912-54",
                "Amapá",
                "Brasil",
                "Arquiteto de software",
                "816.556.457-45",
                "18/11/1995",
                "senha45665"
        )

        //When:
        boolean retorno = candidatoDAO.alterar(candidato)

        //Then:
        assertTrue(retorno)
    }

    @Test
    void testeDeRemover() {
        //Given:
        int id = 8

        //When:
        boolean retorno = candidatoDAO.remover(id)

        //Then:
        assertTrue(retorno)
    }


}
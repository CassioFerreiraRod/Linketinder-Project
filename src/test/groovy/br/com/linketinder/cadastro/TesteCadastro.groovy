package br.com.linketinder.cadastro

import br.com.linketinder.usuario.candidato.Candidato
import br.com.linketinder.usuario.empresa.Empresa
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

class TesteCadastro {

    static Cadastro cadastro

    @BeforeAll
    static void instanciaCadastroEUsuarios() {
        cadastro = new Cadastro()
    }

    @Test
    void testaCadastroEmpresa() {
        // Given:
        Empresa empresaCadastro = new Empresa(
                "Sherlock Solutions",
                "shelorcksolutions@solutions.com",
                "12543-234",
                "CE",
                ["Ruby", "Docker", "GIT"],
                "Empresa focada em investigar problemas voltados a tecnologia",
                "48.689.552/4521-78", "Brasil")

        // When:
        cadastro.cadastrarEmpresa(empresaCadastro)

        // Then:
        assertEquals(6, cadastro.listaEmpresas.size())
        assertEquals(empresaCadastro, cadastro.listaEmpresas[-1])
    }

    @Test
    void testaCadastroCandidato() {
        // Given:
        Candidato candidatoCadastro = new Candidato(
                "Pablo Da Silva",
                "silvapablo@email.com",
                "70813-467",
                "RJ",
                ["Java", "Spring Boot", "AWS"],
                "Estudante de Sistema de Informação pela UFRJ",
                "349.785.167-90", 25)

        // When:
        cadastro.cadastrarCandidato(candidatoCadastro)

        // Then:
        assertEquals(6, cadastro.listaCandidatos.size())
        assertEquals(candidatoCadastro, cadastro.listaCandidatos[-1])
    }
}
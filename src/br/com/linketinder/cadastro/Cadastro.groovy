package br.com.linketinder.cadastro

import br.com.linketinder.pessoa.candidato.Candidato
import br.com.linketinder.pessoa.empresa.Empresa


class Cadastro {
    List<Empresa> listaEmpresas = [
            new Empresa('XLR8Bank',
                    'xrl8bank@example.com',
                    '36985-489',
                    'RJ',
                    ['AWS', 'Ruby', 'JavaScript'],
                    'Banco Digital focado em trazer inovações',
                    '12.345.678/0001-01',
                    'Brasil'
            ),
            new Empresa('Ilha Tech',
                    'ilhatech@example.com',
                    '65089-829',
                    'MA',
                    ['Java', 'Pytohn', 'GIT'],
                    'Inovação em software',
                    '23.456.789/0001-23',
                    'Brasil'
            ),
            new Empresa('XPTO Studios',
                    'xpptostudios@example.com',
                    '74125-456',
                    'GO',
                    ['C++', 'Unreal', 'PhysX'],
                    'Estúdio de jogos digitais',
                    '45.678.901/0001-67',
                    'Brasil'
            ),
            new Empresa('QWERTY Solutions',
                    'qwertysolutions@example.com',
                    '15928-753',
                    'PR',
                    ['TypeScript', 'Angular', 'PostegreSQL'],
                    'Banco Digital focado em trazer inovações',
                    '56.789.012/0001-89',
                    'Brasil'
            ),
            new Empresa('ABC Tech',
                    'abctech@example.com',
                    '26710-10',
                    'CE',
                    ['Groovy', 'Grails', 'GIT'],
                    'É uma empresa inovadora que se destaca na vanguarda da tecnologia',
                    '34.567.890/0001-45',
                    'Brasil'
            )
    ]
    List<Candidato> listaCadidatos = [
            new Candidato(
                    'Francisco',
                    'francisco@email.com',
                    '12345-678',
                    'SP',
                    ['Java', 'Python', 'GIT'],
                    'Formado em Engenharia de Software pela Uninter',
                    '123.456.789-01',
                    25),
            new Candidato('Rebeca',
                    'rebeca@email.com',
                    '54321-012',
                    'AM',
                    ['JavaScript', 'C#', 'GIT'],
                    'Formado em Ciêcias da Computação pela UFAM',
                    '333.444.555-66',
                    26),
            new Candidato('Mario',
                    'mario@email.com',
                    '55367-906',
                    'CE',
                    ['Unity', 'C++', 'Blender'],
                    'Sou ex-encanador e busco transição de carreira para área de desenvolvimento de jogos',
                    '555.666.777-88',
                    32),
            new Candidato('Eduardo',
                    'eduardo@email.com',
                    '86723-024',
                    'MA',
                    ['Java', 'Spring Boot', 'GIT'],
                    'Formado em Engenharia da computação pela UEMA',
                    '987.654.321-00',
                    28),
            new Candidato('Francisco',
                    'francisco@email.com',
                    '12345-678',
                    'SP',
                    ['Angular', 'JavaScript', 'GIT'],
                    'Estudante de Análise e desenvolvimento de sistemas pela Uninter',
                    '369.741.852-40',
                    21)
    ]

    void cadastrarCandidato(Candidato candidato) {
        listaCadidatos.add(candidato)
    }
    void cadastrarEmpresa(Empresa empresa) {
        listaCadidatos.add(empresa)
    }

    void listarCandidatos() {
        listaCadidatos.each {println it}
    }

    void listareEmpresas() {
        listaEmpresas.each {println it}
    }
}

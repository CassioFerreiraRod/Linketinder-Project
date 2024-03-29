package br.com.linketinder.model.entity

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
    List<Candidato> listaCandidatos = [
            new Candidato(
                    'Francisco',
                    'Silva',
                    'francisco@email.com',
                    '12345-678',
                    'Sáo Paulo',
                    'Brasil',
                    'Formado em Engenharia de Software pela Uninter',
                    '123.456.789-01',
                    '1999-02-25',
                    ['Java', 'Python', 'GIT']
            ),
            new Candidato(
                    'Rebeca',
                    'Ferreira',
                    'rebeca@email.com',
                    '54321-012',
                    'Amazonas',
                    'Brasil',
                    'Formado em Ciêcias da Computação pela UFAM',
                    '333.444.555-66',
                    '1998-03-15',
                    ['JavaScript', 'C#', 'GIT']
            ),
            new Candidato(
                    'Mario',
                    'Portela',
                    'mario@email.com',
                    '55367-906',
                    'Ceará',
                    'Brasil',
                    'Sou ex-encanador e busco transição de carreira para área de desenvolvimento de jogos',
                    '555.666.777-88',
                    '1992-05-03',
                    ['Unity', 'C++', 'Blender']
            ),
            new Candidato(
                    'Eduardo',
                    'Souza',
                    'eduardo@email.com',
                    '86723-024',
                    'Maranhão',
                    'Brasil',
                    'Formado em Engenharia da computação pela UEMA',
                    '987.654.321-00',
                    '1996-11-12',
                    ['Java', 'Spring Boot', 'GIT']
            ),
            new Candidato(
                    'Francisco',
                    'Silveira',
                    'francisco@email.com',
                    '12345-678',
                    'São Paulo',
                    'Brasil',
                    'Estudante de Análise e desenvolvimento de sistemas pela Uninter',
                    '369.741.852-40',
                    '2001-07-20',
                    ['Angular', 'JavaScript', 'GIT']
            )
    ]

    void cadastrarCandidato(Candidato candidato) {
        listaCandidatos.add(candidato)
    }
    void cadastrarEmpresa(Empresa empresa) {
        listaEmpresas.add(empresa)
    }

    void listarCandidatos() {
        listaCandidatos.each {println it}
    }

    void listarEmpresas() {
        listaEmpresas.each {println it}
    }
}
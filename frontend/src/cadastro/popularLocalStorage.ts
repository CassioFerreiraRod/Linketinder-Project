import { Candidato } from "../usuario/Candidato";
import { Empresa } from "../usuario/Empresa";
import { CandidatoStorage } from "./CandidatoStorage";
import { EmpresaStorage } from "./EmpresaStorage";

const empresaStorage = new EmpresaStorage()

const empresa1 = new Empresa(
    'XLR8Bank',
    '12.345.678/0001-01',
    'xrl8bank@example.com',
    '36985-489',
    'Rio de Janeiro',
    'Brasil',
    'Banco Digital focado em trazer inovações',
    ['TypeScript', 'JavaScript'],
)
const empresa2 = new Empresa(
    'Ilha Tech',
    '23.456.789/0001-23',
    'ilhatech@example.com',
    '65089-829',
    'Maranhão',
    'Brasil',
    'Inovação em software',
    ['Java', 'Groovy', 'Git']
)
const empresa3 = new Empresa(
    'XPTO Tech',
    '45.678.901/0001-67',
    'xpptostudios@example.com',
    '74125-456',
    'Goiás',
    'Brasil',
    'Inovações Tecnológicas',
    ['Git', 'TypeScript', 'Java']
)
const empresa4 = new Empresa(
    'QWERTY Solutions',
    '56.789.012/0001-89',
    'qwertysolutions@example.com',
    '15928-753',
    'Paraná',
    'Brasil',
    'Banco Digital focado em trazer inovações',
    ['TypeScript', 'Git', 'JavaScript']
)
const empresa5 = new Empresa(
    'ABC Tech',
    '34.567.890/0001-45',
    'abctech@example.com',
    '26710-10',
    'Ceará',
    'Brasil',
    'É uma empresa inovadora que se destaca na vanguarda da tecnologia',
    ['Groovy', 'Git']
)

empresaStorage.add(empresa1)
empresaStorage.add(empresa2)
empresaStorage.add(empresa3)
empresaStorage.add(empresa4)
empresaStorage.add(empresa5)

const candidatoStorage = new CandidatoStorage()

const candidato1 = new Candidato(
    'Francisco',
    25,
    '123.456.789-01',
    'francisco@email.com',
    '12345-678',
    'São Paulo',
    'Formado em Engenharia de Software pela Uninter',
    ['Java', 'Groovy', 'Git']
)
const candidato2 = new Candidato(
    'Rebeca',
    26,
    '333.444.555-66',
    'rebeca@email.com',
    '54321-012',
    'Amazonas',
    'Formado em Ciêcias da Computação pela UFAM',
    ['JavaScript', 'TypeScript', 'Git']
)
const candidato3 = new Candidato(
    'Mario',
    32,
    '555.666.777-88',
    'mario@email.com',
    '55367-906',
    'Ceará',
    'Sou ex-encanador e busco transição de carreira para área de desenvolvimento de software',
    ['Java', 'Testes Unitários']
)
const candidato4 = new Candidato(
    'Eduardo',
    28,
    '987.654.321-00',
    'eduardo@email.com',
    '86723-024',
    'Maranhão',
    'Formado em Engenharia da computação pela UEMA',
    ['Java', 'Groovy', 'Git'],
)
const candidato5 = new Candidato(
    'Francisco',
    21,
    '369.741.852-40',
    'francisco@email.com',
    '12345-678',
    'São Paulo',
    'Estudante de Análise e desenvolvimento de sistemas pela Uninter',
    ['TypeScript', 'JavaScript', 'Git'],
)

candidatoStorage.add(candidato1)
candidatoStorage.add(candidato2)
candidatoStorage.add(candidato3)
candidatoStorage.add(candidato4)
candidatoStorage.add(candidato5)
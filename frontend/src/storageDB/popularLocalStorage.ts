import {Candidato} from "../model/Candidato";
import {Empresa} from "../model/Empresa";
import {CandidatoStorage} from "./CandidatoStorage";
import {VagaStorage} from "./VagaStorage";
import {EmpresaStorage} from "./EmpresaStorage";
import {Vagas} from "../model/Vagas";

const empresaStorage = new EmpresaStorage()

const empresa1 = new Empresa(
    'XLR8Bank',
    '12.345.678/0001-01',
    'xrl8bank@example.com',
    '36985-489',
    'Rio de Janeiro',
    'Brasil',
    'Banco Digital focado em trazer inovações'
)
const empresa2 = new Empresa(
    'Ilha Tech',
    '23.456.789/0001-23',
    'ilhatech@example.com',
    '65089-829',
    'Maranhão',
    'Brasil',
    'Inovação em software'
)
const empresa3 = new Empresa(
    'XPTO Tech',
    '45.678.901/0001-67',
    'xpptostudios@example.com',
    '74125-456',
    'Goiás',
    'Brasil',
    'Inovações Tecnológicas'
)
const empresa4 = new Empresa(
    'QWERTY Solutions',
    '56.789.012/0001-89',
    'qwertysolutions@example.com',
    '15928-753',
    'Paraná',
    'Brasil',
    'Banco Digital focado em trazer inovações'
)
const empresa5 = new Empresa(
    'ABC Tech',
    '34.567.890/0001-45',
    'abctech@example.com',
    '26710-10',
    'Ceará',
    'Brasil',
    'É uma empresa inovadora que se destaca na vanguarda da tecnologia'
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
    'José',
    21,
    '369.741.852-40',
    'jose@email.com',
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

const vagaStorage = new VagaStorage()

const vaga1 = new Vagas(
    'Desenvolvedor Full Stack',
    'Estamos em busca de um desenvolvedor full stack altamente motivado para se juntar à nossa equipe de tecnologia.',
    'Rio de Janeiro',
    empresa1.estado,
    empresa1.nome,
    ['Java', 'JavaScript', 'Git']
)

const vaga2 = new Vagas(
    'Engenheiro de Software',
    'Estamos contratando um engenheiro de software talentoso para desenvolver soluções inovadoras para nossos clientes.',
    'São Luís',
    empresa2.estado,
    empresa2.nome,
    ['TypeScript', 'JavaScript', 'Testes Unitarios']
)

const vaga3 = new Vagas(
    'Gerente de Projetos',
    'Buscamos um gerente de projetos experiente para liderar nossa equipe e garantir a entrega bem-sucedida de nossos projetos.',
    'Goiânia',
    empresa3.estado,
    empresa3.nome,
    ['TypeScript', 'JavaScript', 'Testes Unitarios']
)

const vaga4 = new Vagas(
    'Analista de Negócios',
    'Procuramos um analista de negócios experiente para nos ajudar a melhorar nossas operações e alcançar nossos objetivos.',
    'Curitiba',
    empresa4.estado,
    empresa4.nome,
    ['Groovy', 'TypeScript', 'Git']
)

const vaga5 = new Vagas(
    'Desenvolvedor Full Stack',
    'Desenvolvedor Full Stack',
    'Fortaleza',
    empresa5.estado,
    empresa5.nome,
    ['Groovy', 'TypeScript', 'Git']
)

vagaStorage.add(vaga1)
vagaStorage.add(vaga2)
vagaStorage.add(vaga3)
vagaStorage.add(vaga4)
vagaStorage.add(vaga5)
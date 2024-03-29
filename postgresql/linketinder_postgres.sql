CREATE TABLE "pais"
(
    "id"   serial PRIMARY KEY,
    "nome" varchar(20) NOT NULL
);

CREATE TABLE "estados"
(
    "id"   serial PRIMARY KEY,
    "uf"   char(2)     NOT NULL,
    "nome" varchar(20) NOT NULL
);

CREATE TABLE "candidatos"
(
    "id"                serial PRIMARY KEY,
    "nome"              VARCHAR(50)        NOT NULL,
    "sobrenome"         varchar(50)        NOT NULL,
    "data_nascimento"   date               NOT NULL,
    "email"             varchar(100)       NOT NULL,
    "cpf"               varchar(15) UNIQUE NOT NULL,
    "estado_id"         int                NOT NULL,
    "pais_id"           int                NOT NULL,
    "cep"               varchar(15)        NOT NULL,
    "descricao_pessoal" text               NOT NULL,
    "senha"             varchar(255)       NOT NULL
);

CREATE TABLE "competencias"
(
    "id"          serial PRIMARY KEY,
    "competencia" varchar(100) NOT NULL
);

CREATE TABLE "candidato_competencias"
(
    "candidato_id"   int NOT NULL,
    "competencia_id" int NOT NULL
);

CREATE TABLE "empresas"
(
    "id"                serial PRIMARY KEY,
    "nome_empresa"      varchar(100)       NOT NULL,
    "cnpj"              varchar(20) UNIQUE NOT NULL,
    "email_corporativo" varchar(100)       NOT NULL,
    "descricao_empresa" text               NOT NULL,
    "estado_id"         int                NOT NULL,
    "pais_id"           int                NOT NULL,
    "cep"               varchar(15)        NOT NULL,
    "senha"             varchar(255)       NOT NULL
);

CREATE TABLE "vagas"
(
    "id"         serial PRIMARY KEY,
    "nome"       varchar(100),
    "descricao"  text,
    "cidade"     varchar(50),
    "estado_id"  int NOT NULL,
    "empresa_id" int NOT NULL
);

CREATE TABLE "vaga_competencias"
(
    "vaga_id"        int NOT NULL,
    "competencia_id" int NOT NULL
);

CREATE TABLE "curtidas"
(
    "id"           serial PRIMARY KEY,
    "candidato_id" int,
    "vaga_id"      int,
    "empresa_id"   int
);

ALTER TABLE "candidatos"
    ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("id") ON DELETE CASCADE;

ALTER TABLE "candidatos"
    ADD FOREIGN KEY ("pais_id") REFERENCES "pais" ("id") ON DELETE CASCADE;

ALTER TABLE "candidato_competencias"
    ADD FOREIGN KEY ("candidato_id") REFERENCES "candidatos" ("id") ON DELETE CASCADE;

ALTER TABLE "candidato_competencias"
    ADD FOREIGN KEY ("competencia_id") REFERENCES "competencias" ("id") ON DELETE CASCADE;

ALTER TABLE "empresas"
    ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("id") ON DELETE CASCADE;

ALTER TABLE "empresas"
    ADD FOREIGN KEY ("pais_id") REFERENCES "pais" ("id") ON DELETE CASCADE;

ALTER TABLE "vagas"
    ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("id") ON DELETE CASCADE;

ALTER TABLE "vagas"
    ADD FOREIGN KEY ("empresa_id") REFERENCES "empresas" ("id") ON DELETE CASCADE;

ALTER TABLE "vaga_competencias"
    ADD FOREIGN KEY ("vaga_id") REFERENCES "vagas" ("id") ON DELETE CASCADE;

ALTER TABLE "vaga_competencias"
    ADD FOREIGN KEY ("competencia_id") REFERENCES "competencias" ("id") ON DELETE CASCADE;

ALTER TABLE "curtidas"
    ADD FOREIGN KEY ("candidato_id") REFERENCES "candidatos" ("id") ON DELETE CASCADE;

ALTER TABLE "curtidas"
    ADD FOREIGN KEY ("vaga_id") REFERENCES "vagas" ("id") ON DELETE CASCADE;

ALTER TABLE "curtidas"
    ADD FOREIGN KEY ("empresa_id") REFERENCES "empresas" ("id") ON DELETE CASCADE;

insert into public.pais (nome)
values ('Brasil');

INSERT INTO estados (uf, nome)
VALUES ('AC', 'Acre'),
       ('AL', 'Alagoas'),
       ('AP', 'Amapá'),
       ('AM', 'Amazonas'),
       ('BA', 'Bahia'),
       ('CE', 'Ceará'),
       ('DF', 'Distrito Federal'),
       ('ES', 'Espírito Santo'),
       ('GO', 'Goiás'),
       ('MA', 'Maranhão'),
       ('MT', 'Mato Grosso'),
       ('MS', 'Mato Grosso do Sul'),
       ('MG', 'Minas Gerais'),
       ('PA', 'Pará'),
       ('PB', 'Paraíba'),
       ('PR', 'Paraná'),
       ('PE', 'Pernambuco'),
       ('PI', 'Piauí'),
       ('RJ', 'Rio de Janeiro'),
       ('RN', 'Rio Grande do Norte'),
       ('RS', 'Rio Grande do Sul'),
       ('RO', 'Rondônia'),
       ('RR', 'Roraima'),
       ('SC', 'Santa Catarina'),
       ('SP', 'São Paulo'),
       ('SE', 'Sergipe'),
       ('TO', 'Tocantins');

insert into competencias (competencia)
values ('Java'),
       ('Groovy'),
       ('JavaScript'),
       ('TypeScript'),
       ('Git'),
       ('PostgreSQL'),
       ('Testes Unitários');

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, estado_id, pais_id, cep, descricao_pessoal, senha)
VALUES ('João', 'Silva', '1990-05-15', 'joao.silva@email.com', '123.456.789-00', 13, 1, '12345-678',
        'Sou um profissional dedicado em busca de novas oportunidades.', 'senha123'),

       ('Maria', 'Santos', '1985-08-20', 'maria.santos@email.com', '987.654.321-00', 25, 1, '54321-098',
        'Tenho experiência em diversas áreas e estou sempre em busca de desafios.', 'senha456'),

       ('Pedro', 'Oliveira', '1995-03-10', 'pedro.oliveira@email.com', '456.789.012-00', 5, 1, '98765-432',
        'Busco uma posição onde possa aplicar minhas habilidades analíticas.', 'senha789'),

       ('Ana', 'Silveira', '1988-11-25', 'ana.silveira@email.com', '321.654.987-00', 17, 1, '34567-890',
        'Sou uma pessoa comunicativa e apaixonada por tecnologia.', 'senhaabc'),

       ('Carlos', 'Ferreira', '1992-07-03', 'carlos.ferreira@email.com', '654.321.098-00', 22, 1, '87654-321',
        'Tenho uma sólida experiência em liderança de equipes.', 'senhabcd');

INSERT INTO empresas (nome_empresa, cnpj, email_corporativo, descricao_empresa, estado_id, pais_id, cep, senha)
VALUES ('TechInnovate', '12.345.678/0001-90', 'contato@techinnovate.com', 'Empresa inovadora no ramo de tecnologia.', 1, 1,
        '12345-678', 'senhatech'),
       ('Consultoria360', '98.765.432/0001-21', 'contato@consultoria360.com',
        'Líder em consultoria empresarial, proporcionando soluções integradas.', 2, 1, '54321-098', 'consultoria123'),
       ('FutureTech Solutions', '11.223.334/0001-45', 'contato@futuretech.com',
        'Soluções tecnológicas avançadas para empresas de todos os tamanhos.', 3, 1, '98765-432', 'future456'),
       ('EngenharSoluções', '55.666.777/0001-88', 'contato@engenhar.com',
        'Especializada em engenharia e soluções inovadoras para o mercado.', 4, 1, '87654-321', 'engenharia789'),
       ('MarketMasters', '99.888.777/0001-44', 'contato@marketmasters.com',
        'Líder em marketing digital e estratégias de vendas online.', 5, 1, '23456-789', 'market123');

INSERT INTO vagas (nome, descricao, cidade, estado_id, empresa_id)
VALUES ('Desenvolvedor Full Stack',
        'Estamos em busca de um desenvolvedor full stack altamente motivado para se juntar à nossa equipe de tecnologia.', 'São Paulo',
        25, 1),
       ('Analista de Negócios',
        'Procuramos um analista de negócios experiente para nos ajudar a melhorar nossas operações e alcançar nossos objetivos.',
        'Rio de Janeiro', 19, 2),
       ('Engenheiro de Software',
        'Estamos contratando um engenheiro de software talentoso para desenvolver soluções inovadoras para nossos clientes.',
        'Brasília', 7, 3),
       ('Gerente de Projetos',
        'Buscamos um gerente de projetos experiente para liderar nossa equipe e garantir a entrega bem-sucedida de nossos projetos.',
        'Curitiba', 16, 4),
       ('Especialista em Marketing Digital',
        'Procuramos um especialista em marketing digital para desenvolver e implementar estratégias de marketing eficazes.',
        'São Paulo', 25, 5);

insert into candidato_competencias (candidato_id, competencia_id)
values (1, 3),
       (1, 2),
       (1, 7),
       (2, 5),
       (2, 3),
       (2, 2),
       (3, 2),
       (3, 5),
       (3, 7),
       (4, 1),
       (4, 2),
       (2, 7),
       (5, 5),
       (5, 3),
       (5, 4);

INSERT INTO vaga_competencias (vaga_id, competencia_id)
VALUES (1, 1),
       (1, 4),
       (1, 3),
       (2, 2),
       (2, 5),
       (2, 4),
       (3, 3),
       (3, 6),
       (3, 5),
       (4, 4),
       (4, 7),
       (4, 5),
       (5, 2),
       (5, 3),
       (5, 7);

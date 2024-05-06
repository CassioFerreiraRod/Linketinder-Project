# Documentação REST
## Visão Geral
Esta API permite fazer a persistência informações sobre vagas de emprego, empresas e candidatos no banco de dados.
## Tecnologias usadas
* [Tomcat](https://tomcat.apache.org/)
* [Jersey](https://eclipse-ee4j.github.io/jersey/)
## Endpoints

### Criar Vaga (POST)
Cria uma nova vaga.
#### URL
```http request
    http://localhost:8080/linketinder/usuario/empresas/vagas
```

#### Parâmetros de Solicitação

![img.png](prints/printDadosVaga.png)
![img.png](prints/printDadosVagasCompetencias.png)

#### Exemplo de Corpo de Solicitação
```json
{
  "nome": "Analista de Requisitps",
  "descricao": "Buscamos um analista de requistos para fazer parte da nossa equipe.",
  "cidade": "São Paulo",
  "estado": "São Paulo",
  "empresa": "Mega Soluções LTDA",
  "competencias": ["Java", "Groovy"]
}
```
#### Exemplo de resposta
***Sucesso***
```json
{
  "status": 201,
  "mensagem": "Cadastro feito com sucesso"
}
```

### Criar Empresa (POST)
Cria uma nova empresa.

#### URL
```http request
    http://localhost:8080/linketinder/usuario/empresas
```

#### Parâmetros de Solicitação

![img.png](prints/printDadosEmpresa.png)

#### Exemplo de Corpo de Solicitação
```json
{
  "nome": "Mega Soluções LTDA",
  "email":"megasolucoes@contato.com",
  "cnpj":"42.538.044/0001-46",
  "cep": "95175-896",
  "estado": "São Paulo",
  "pais": "Brasil",
  "descricao": "Trazendo mega soluções",
  "senha": "454848461"
}
```
#### Exemplo de resposta
***Sucesso***
```json
{
  "status": 201,
  "mensagem": "Cadastro feito com sucesso"
}
```

### Criar Candidato (POST)
Cria um novo candidato.

#### URL
```http request
    http://localhost:8080/linketinder/usuario/candidatos
```
#### Parâmetros de Solicitação

![img.png](prints/printDadosCandidato.png)
![img.png](prints/printDadosCandidatosCompetencias.png)

#### Exemplo de Corpo de Solicitação
```json
{
  "nome": "Fulano",
  "sobrenome": "Ciclano",
  "email":"fulano@email.com",
  "cep" : "95178-35",
  "estado": "Ceará",
  "pais":  "Brasil",
  "descricao":"EScrava uma descrição",
  "cpf": "123.456.789-10",
  "dataNascimento":"01/01/2000",
  "senha":"senha4515665",
  "competencias": ["Java", "Groovy"]
}
```
#### Exemplo de resposta
***Sucesso***
```json
{
  "status": 201,
  "mensagem": "Cadastro feito com sucesso"
}
```
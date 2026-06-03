# project-java-back-end

Este repositório reúne uma sequência de projetos desenvolvidos para estudar integração entre aplicações Java, arquitetura Front-end/Back-end, APIs REST, banco de dados, CI/CD e testes automatizados.

Ao longo dos projetos, foram utilizados JavaFX, Spring Boot, PostgreSQL, Maven, GitLab CI, TeamCity, Swagger, Hibernate, Mockito, TestFX e outras ferramentas relacionadas ao ecossistema Java.

# Projeto 1 — Estrutura Inicial com Front-end

### Primeira etapa do projeto focada apenas na construção da interface gráfica utilizando JavaFX.

### Tecnologias utilizadas
- Java 8
- JavaFX
- Scene Builder
- IntelliJ IDEA
- TortoiseGit

### Estrutura
- Main → inicia a aplicação
- Controller → controla os componentes da interface
- .fxml → telas geradas pelo Scene Builder

### Conceitos trabalhados
- Estruturação inicial do projeto
- Criação e organização de branches (main, develop e feature/projeto01)
- Desenvolvimento de interface gráfica com FXML
- Comunicação entre JavaFX e controllers

### Execução
- Executar a classe Main.

# Projeto 2 — Separação entre Front-end e Back-end

Projeto focado na separação de responsabilidades entre interface gráfica e lógica de dados.

### Tecnologias utilizadas
- Maven
- JavaFX
- Java 8

## Front-end

O front-end passa a consumir os dados do back-end através de dependência Maven.

### Estrutura

- `Main` → inicia a aplicação
- `Controller` → consome os dados do back-end e atualiza a interface

## Back-end

O back-end contém os modelos:

* `Category`
* `Model`
* `Line`

### Relacionamentos

* Uma `Line` possui várias `Category`
* Cada `Category` possui vários `Model`

### Conceitos trabalhados

* Modularização
* Separação de camadas
* Uso de dependências Maven
* Relacionamento entre entidades

### Instalação do back-end

```bash
mvn clean install
```

Esse comando instala o back-end no repositório Maven local para ser utilizado pelo front-end.

# Projeto 3 — Banco de Dados e Geração de Instalador

Projeto dividido em:

- Persistência com banco de dados
- Empacotamento e geração de instalador

### Tecnologias utilizadas

* PostgreSQL
* Hibernate
* Maven
* Inno Setup
* JavaFX Maven Plugin

## Banco de Dados

A conexão é configurada no `hibernate.cfg.xml`.

### Funcionalidades

* Configuração do PostgreSQL
* Mapeamento Hibernate
* Persistência das entidades:

  * `Line`
  * `Model`
  * `Category`

## Instalador

O projeto gera um executável `.exe` utilizando Maven + jpackage e posteriormente empacota tudo utilizando Inno Setup.

### Fluxo de geração

1. Maven gera o `.jar` e o executável
2. Arquivos são enviados para a pasta usada pelo Inno Setup
3. O Inno Setup gera o instalador final
4. O instalador copia os arquivos para:

   - `AppData\Local\project-java-integration`

### Conceitos trabalhados
- Persistência com Hibernate
- Integração com PostgreSQL
- Empacotamento desktop
- Geração de executáveis
- Distribuição de aplicações Java

# Projeto 4 — API REST e Integração Contínua (CI)

Projeto focado em APIs REST com Spring Boot e automação de builds utilizando GitLab CI e TeamCity.

### Tecnologias utilizadas
- Spring Boot
- Swagger
- GitLab CI
- TeamCity
- Maven

## API REST

### Estrutura

- `repositories` → acesso aos dados
- `services` → regras de negócio e criação de DTOs
- `controllers` → endpoints da API
- `DTOs` → objetos de transporte de dados

### Conceitos trabalhados

- Arquitetura em camadas
- APIs REST
- Swagger
- DTOs
- Spring Boot

## GitLab CI

### Runner

O Runner é responsável por executar automaticamente os builds após commits e pushes.

### Maven Cache

Foi utilizada a pasta:

```text
C:\maven_cache
```
para:

- armazenar dependências
- acelerar builds
- compartilhar dependências entre projetos

### Fluxo da CI

1. Clona o back-end
2. Executa build do front-end
3. Executa `mvn clean install` no back-end
4. Executa a API via:

```bash
java -jar project-java-back-end-2-1.0-SNAPSHOT.jar
```

### Conceitos trabalhados

- Integração contínua
- Automação de build
- Maven cache
- Execução automatizada de aplicações

## TeamCity

### Configurações principais

- Configuração de múltiplos repositórios
- Uso de cache Maven customizado
- Build automático do front-end e back-end
- Execução automática da API

### Build Steps

- `clean package` do front-end
- `clean install` do back-end
- execução do `.jar` da API

### Conceitos trabalhados

- Pipelines CI
- Integração entre projetos
- Cache de dependências
- Build automatizado

# Projeto 5 — Testes Automatizados

Projeto voltado para testes unitários e testes de interface.

### Tecnologias utilizadas

* JUnit
* Mockito
* Spring Test
* TestFX

## Testes do Controller (Back-end)

### Recursos utilizados

* `@WebMvcTest`
* `MockMvc`
* `Mockito`
* `jsonPath`

### Objetivos

* Testar endpoints REST isoladamente
* Simular requisições HTTP
* Validar respostas JSON
* Garantir chamadas corretas aos services

### Conceitos trabalhados

* Mock de dependências
* Testes isolados
* Validação de APIs REST

## Testes do Controller (Front-end)

### Recursos utilizados

* TestFX
* JavaFX
* Mockito

### Objetivos

* Validar componentes gráficos
* Simular ações do usuário
* Testar comportamento da interface
* Validar tratamento de erros

### Conceitos trabalhados

* Testes de interface
* Simulação de eventos
* Integração entre controller e componentes JavaFX


## Testes do ApiLineService

### Recursos utilizados

* `RestTemplate`
* `ResponseEntity`
* `ParameterizedTypeReference`
* Mockito

### Objetivos

* Simular consumo de API REST
* Mockar respostas HTTP
* Validar comunicação entre front-end e API

### Conceitos trabalhados

* Mock de chamadas HTTP
* Testes de serviços
* Simulação de APIs REST

# Evolução dos Projetos

Os projetos foram desenvolvidos de forma incremental:

1. Interface gráfica JavaFX
2. Separação Front-end/Back-end
3. Persistência e geração de instalador
4. API REST + CI/CD
5. Testes automatizados

Essa sequência permitiu explorar desde conceitos básicos de aplicações desktop em Java até integração contínua e testes automatizados em aplicações completas.

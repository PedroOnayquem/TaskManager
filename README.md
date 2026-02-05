# TaskManager

Aplicação Full Stack para gerenciamento de tarefas. O projeto consiste em uma API REST desenvolvida com Spring Boot e um frontend para interação com o usuário, permitindo criar, listar, atualizar e remover tarefas, além de controlar seu status.

## Demonstração

Frontend disponível em:
http://task-manager-umber-seven-55.vercel.app

---

## Tecnologias Utilizadas

### Backend
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

### Frontend
- TypeScript
- JavaScript
- Framework SPA (frontend localizado na pasta `frontend`)

---

## Funcionalidades

- Criar tarefas
- Listar tarefas
- Buscar tarefa por ID
- Atualizar tarefa
- Remover tarefa
- Marcar tarefas como concluídas
- Integração entre frontend e API REST

---

## Estrutura do Projeto

TaskManager
│
├── src # Código do backend (Spring Boot)
├── frontend # Aplicação frontend
├── pom.xml # Gerenciamento de dependências Maven
└── README.md


---

## Configuração do Banco de Dados

O projeto utiliza PostgreSQL.

### 1. Criar banco de dados

``sql
CREATE DATABASE taskmanager;

Configurar application.properties
Localizado em:

src/main/resources/application.properties

Configuraçao Exemplo

spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

### Como Executar o Projeto
Clonar repositório

git clone https://github.com/PedroOnayquem/TaskManager.git
cd TaskManager

## Executar Backend

Pré-requisitos:
Java 17+
Maven
PostgreSQL

## Executar:
mvn spring-boot:run

A API estará disponível em:

http://localhost:8080

## Executar Frontend
cd frontend
npm install
npm run dev

## Endpoints da API
Criar tarefa
POST /tasks

Listar tarefas
GET /tasks

Buscar tarefa por ID
GET /tasks/{id}

Atualizar tarefa
PUT /tasks/{id}

Remover tarefa
DELETE /tasks/{id}

## Modelo de Tarefa (Exemplo)
{
  "title": "Estudar Spring Boot",
  "description": "Revisar conceitos de API REST",
  "completed": false
}

## Variáveis de Ambiente
Recomenda-se configurar variáveis sensíveis como credenciais do banco através de arquivos .env ou variáveis do sistema.

## Melhorias Futuras
Autenticação de usuários
Filtros e paginação
Dashboard com estatísticas
Deploy automatizado
Testes automatizados

## Autor
Pedro Onayquem

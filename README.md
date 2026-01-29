# TaskManager

API REST para gerenciamento de tarefas desenvolvida em Java com Spring Boot.  
Permite criar, listar, atualizar e remover tarefas, além de marcar como concluídas.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Funcionalidades

- Criar tarefa
- Listar tarefas
- Buscar tarefa por ID
- Atualizar tarefa
- Remover tarefa
- Marcar tarefa como concluída

## Configuração do banco

O projeto utiliza PostgreSQL.

Crie o banco:
sql 
CREATE DATABASE taskmanager;
Configure o arquivo application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

## Executando o projeto

Clone o repositório:
git clone https://github.com/PedroOnayquem/TaskManager.git

Entre na pasta:
cd TaskManager

Execute:
mvn spring-boot:run

A API estará disponível em:
http://localhost:8080

## Endpoints principais

POST /tasks - Criar tarefa

GET /tasks - Listar tarefas

GET /tasks/{id} - Buscar por ID

PUT /tasks/{id} - Atualizar tarefa

DELETE /tasks/{id} - Remover tarefa

Autor,
Pedro Onayquen

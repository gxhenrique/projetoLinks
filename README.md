# Projeto Links

Projeto backend inspirado em plataformas como Linktree, desenvolvido para estudo com Java, Spring Boot, JPA e H2/MySQL.

## Objetivo

Criar uma API REST para gerenciar usuários e seus links personalizados, permitindo cadastrar, listar, atualizar e remover informações.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Banco H2
- Maven

## Funcionalidades

- Cadastro de usuários
- Listagem de usuários
- Busca de usuário por id
- Atualização de usuário
- Remoção de usuário
- Cadastro de links
- Listagem de links
- Relacionamento entre usuário e links

## Estrutura do projeto

### Entidade User
- id
- name
- username
- email
- password
- bio
- photoUrl

### Entidade Link
- id
- title
- url
- visible
- displayOrder
- user

## Relacionamentos

- Um usuário pode ter vários links
- Um link pertence a um único usuário

## Endpoints principais

### User
- `GET /users`
- `GET /users/{id}`
- `POST /users`
- `PUT /users/{id}`
- `PATCH /users/{id}`
- `DELETE /users/{id}`

### Link
- `GET /links`
- `GET /links/{id}`
- `POST /links`
- `PUT /links/{id}`
- `PATCH /links/{id}`
- `DELETE /links/{id}`

## Exemplo de JSON para User

```json
{
  "name": "Henrique",
  "username": "gxhenrique",
  "email": "henrique@email.com",
  "password": "123456",
  "bio": "Desenvolvedor em aprendizado",
  "photoUrl": "https://meusite.com/foto.jpg"
}
```
## Exemplo de JSON para Link
```json
{
  "title": "Meu GitHub",
  "url": "https://github.com/gxhenrique",
  "visible": true,
  "displayOrder": 1,
  "user": {
    "id": 1
  }
}

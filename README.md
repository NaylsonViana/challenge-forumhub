PI REST de fórum desenvolvida como desafio de back-end, inspirada no fórum da Alura. Permite cadastro de usuários, criação e gerenciamento de tópicos e respostas, com autenticação e autorização.

## Objetivo

Permitir que usuários possam:

- Criar, listar, atualizar e deletar tópicos
- Visualizar tópicos e respostas
- Cadastrar novos usuários
- Autenticar e proteger rotas

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security (Basic Auth e JWT)
- MySQL
- Maven

## Como rodar o projeto localmente

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/NaylsonViana/challenge-forumhub.git
   cd challenge-forumhub
   ```

2. **Configure o banco de dados:**

   - Crie um banco MySQL chamado `forumhub`.
   - Copie o arquivo `src/main/resources/application-example.properties` para `src/main/resources/application.properties` e preencha com seus dados do banco.

3. **Instale as dependências e rode o projeto:**
   ```bash
   ./mvnw spring-boot:run
   ```
   ou
   ```bash
   mvn spring-boot:run
   ```

## Exemplo de configuração (`application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Autenticação

- As rotas protegidas exigem autenticação via Basic Auth (usuário: email, senha: senha cadastrada).
- Também há autenticação via JWT pelo endpoint `/auth/login`.

### Exemplo de login (JWT)

```
POST /auth/login
{
  "email": "seu@email.com",
  "senha": "123456"
}
```

## Endpoints principais

### Usuários

- `POST /usuarios` — Cadastrar usuário
- `GET /usuarios` — Listar usuários

### Tópicos

- `POST /topicos` — Criar tópico
- `GET /topicos` — Listar tópicos
- `GET /topicos/{id}` — Buscar tópico por ID
- `PUT /topicos/{id}` — Atualizar tópico
- `DELETE /topicos/{id}` — Deletar tópico

### Respostas

- `POST /respostas` — Criar resposta
- `GET /respostas` — Listar respostas

## Observações

- Senhas são criptografadas com BCrypt.
- Não suba seu arquivo `application.properties` com dados sensíveis para o GitHub.

---

Desafio realizado por Naylson Viana para a formação Back End da Alura.

# 🎬 MovieFlix

Uma aplicação desenvolvida em **Java** com **Spring Boot**, **Spring Security**, **JWT** e **PostgreSQL**, focada na **gestão de catálogos de filmes**.

## 📚 Descrição

O MovieFlix é uma API RESTful que permite gerenciar filmes, streamings e categorias. A autenticação é feita via **JWT** e o sistema foi projetado para oferecer segurança e organização no controle de um catálogo completo de filmes.

---

## 🚀 Funcionalidades

- 🔐 Autenticação e autorização com Spring Security + JWT  
- 🎞️ Cadastrar, listar, editar e excluir filmes  
- 📂 Cadastrar e gerenciar categorias  
- 📡 Associar filmes a plataformas de streaming  
- 🔎 Consultas por ID e listagens gerais  
- 📦 Integração com PostgreSQL  
- 📁 Estrutura RESTful clara e organizada  

---

## 📌 Endpoints principais

### 🔐 Autenticação
- `POST /auth/login` — Realiza login e retorna o token JWT  
- `POST /auth/cadastrar` — (Opcional) Cadastro de usuário  

### 🎬 Filmes
- `POST /movie` — Cadastrar filme  
- `GET /movie` — Listar todos os filmes  
- `GET /movie/{id}` — Listar filme por ID  
- `PUT /movie/{id}` — Atualizar filme  
- `DELETE /movie/{id}` — Deletar filme  

### 🗂️ Categorias
- `POST /category` — Cadastrar categoria  
- `GET /category` — Listar categorias
- `DELETE /category/{id}` — Deletar categoria

### 📺 Streaming
- `POST /streaming` — Cadastrar plataforma de streaming  
- `GET /streaming` — Listar streamings
- `DELETE /streaming/{id}` — Deletar streaming

---

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **PostgreSQL**
- **Lombok**
- **Maven**

---

## 🏁 Como rodar o projeto

```bash
# Clone o repositório
git clone https://github.com/eronfelix-js/MovieFlix.git
cd MovieFlix

# Configure o application.properties com seu banco PostgreSQL

# Execute a aplicação
./mvnw spring-boot:run

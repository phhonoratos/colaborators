<h1 align="center">
    Colaborator
    Cadastro de usuários web
</h1>

## 💻 Sobre o projeto 

Colaborators é uma aplicação para cadastro e atualização de dados cadastrais de usuários na web.
O projeto foi desenvolvido durante a etapa de testes do processo seletivo da empresa PontoTel.

Experimente: [Clique aqui](https://colaborators.netlify.app/)

---

## ⚙️ Funcionalidades

- Usuários podem se cadastrar na plataforma web enviando:
  - [x] nome
  - [x] email
  - [x] CPF
  - [x] pis
  - [x] Endereço:
    - CEP
    - rua
    - número
    - complemento
    - município
    - estado
    - país
  - [x] Senha

- Os usuários tem acesso ao aplicativo web, onde podem:
  - [x] cadastrar-se
  - [x] atualizar seus dados cadastrais
  - [x] remover/excluir seu cadastro

---

## 🚀 Como executar o projeto

Este projeto é divido em duas partes:
1. Backend (pasta backend) 
2. Frontend (pasta frontend)

💡 Para que o frontend funcione, é necessário que o projeto backend esteja em execução.

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [Git](https://git-scm.com)
- [Node.js](https://nodejs.org/en/)
- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [PostgreSQL 12 ou superior](https://www.postgresql.org/download/)
- [PgAdmin 4](https://www.pgadmin.org/download/)
- [Yarn](https://yarnpkg.com/getting-started/install)
- [VSCode](https://code.visualstudio.com/)
- [STS 4](https://spring.io/tools)
___

#### 🛠 Configurando o banco de dados local

```bash
# Crie uma base de dados (postgres) local utilizando o PgAdmin com o nome:
	colaborators

# Depois de criado a base de dados, clique com o botão direito sobre a mesma e selecione:
	QUERY TOOL

#Copie, cole e execute o seguinte código na aba de Query Editor (no pgadmin) para criar a tabela de colaborador na base de dados colaborators:
	create table tb_colaborators (id int8 generated by default as identity, cep varchar(255), complemento varchar(255), cpf varchar(255), email varchar(255), estado varchar(255), municipio varchar(255), nome varchar(255), numero varchar(255), pais varchar(255), pis varchar(255), rua varchar(255), senha varchar(255), primary key (id));

Pronto, o banco de dados local já está preparado!

```
___

#### 🎲 Rodando o Backend (servidor)

```bash

# Clone este repositório
$ git clone https://github.com/phhonoratos/colaborators.git

# Abra o projeto backend
***Com VSCode***
	1 - Com o terminal aberto na raiz do projeto vá para a pasta backend: 
		$ cd backend
	2 - Agora digite o seguinte comando para abrir o projeto:
		$ code .

***Com STS***
	1 - Abra o aplicativo do STS e indique como WorkSpace a pasta principal do projeto (não é a pasta do backend);

# Altere  APENAS os campos USERNAME e PASSWORD do arquivo de configuração APPLICATION-DEV.PROPERTIES com o seu username e password cadastrado durante a instalação do postgres. Deve ficar da seguinte forma:
	spring.datasource.username=<seu_usuario_do_postgres>
	spring.datasource.password=<sua_senha_do_postgres>

# Execute o projeto backend
***Com VSCode***
	1 - Na aba SPRING BOOT DASHBOARD selecione o arquivo COLABORATORS e clique em START

***Com STS***
	1 - Na aba BOOT DASHBOARD expanda o LOCAL;
	2 - Quando expandir o local irá aparecer o arquivo COLABORATORS, clique com o botão direito sobre o mesmo e selecione (RE)start;
	
	
💡 Tanto no VSCode como no STS será instalada as dependencias e o projeto iniciará na porta 8080. Acesse http://localhost:8080

```
___

#### 🧭 Rodando a aplicação web (Frontend)

```bash

# Com o terminal/cmd aberto na raiz do projeto vá para a pasta frontend
$cd frontend

# Instale as dependências
$ yarn

# Execute a aplicação em modo de desenvolvimento
$ yarn start

💡 O projeto iniciará na porta 3000 e abrirá o navegador para o mesmo.

```

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas para o desenvolvimento do projeto:

#### **Frontend (Website)**  ([React JS](https://reactjs.org/))

#### **Backend (servidor)**  ([Java](https://docs.oracle.com/en/java/)  +  [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/))

___

#### **Utilitários**

-   API:  **[ViaCep API](https://viacep.com.br/exemplo/javascript/)**  
-   Editor:  **[VSCode](https://code.visualstudio.com/)** 
-   IDE: **[STS 4](https://spring.io/tools)**
-   Teste de API:  **[Postman](https://www.postman.com/)**

---

## 🦸 Autor

 <img style="border-radius: 50%" src="https://avatars.githubusercontent.com/u/54782227?v=4" width="100px;" alt=""/>

<b>Paulo Honorato</b>

[![Linkedin Badge](https://img.shields.io/badge/-Paulo-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/paulohonorato/)](https://www.linkedin.com/in/paulohonorato/)
[![Hotmail Badge](https://img.shields.io/badge/-paulohonoratos@hotmail.com-blue?style=flat-square&logo=Gmail&logoColor=white&link=mailto:paulohonoratos@hotmail.com)](mailto:paulohonoratos@hotmail.com)
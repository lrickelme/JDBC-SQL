# 📚 Projeto de Conexão com Banco de Dados Relacional e Operações CRUD

Este projeto demonstra como realizar uma conexão com um banco de dados relacional utilizando Spring Boot e JDBC, e executar operações de CRUD (Criar, Ler, Atualizar, Deletar) em uma tabela de livros. O programa também permite que o usuário faça escolhas e insira dados.

## 🛠 Tecnologias utilizadas

- **JDK**: Java Development Kit 17 ☕.
- **Spring Boot**
- **Banco de Dados Relacional**: PostgreSQL 🗄.
- **IDE**: IntelliJ IDEA 🖥️.
- **Driver JDBC**: Driver JDBC do PostgreSQL 🔌.

## 🗂 Estrutura do Projeto

O projeto consiste nas seguintes classes:

- **`jdbcConnection`**: Classe que faz a conexão com o banco de dados🗄 .
- **`Book`**: Classe que representa um livro, com os campos `id`, `title`, `author`, `genre`, `publication_year` e `price` 📖.
- **`bookDAO`**: Classe que contém as operações de CRUD (Criar, Ler, Atualizar, Deletar) para interagir com o banco de dados 🔧.
- **`Application`**: Classe principal que contém a lógica de execução do programa e interage com o usuário 👨‍💻.

### Execução

Execute a classe `Application.java` 🏃‍♂️. O programa vai interagir com o banco de dados, realizando as seguintes operações:

1. **Criar Livro**: O programa cria um novo livro no banco de dados ✍️.
2. **Ler Livros**: O programa lê e exibe todos os livros cadastrados no banco de dados 📚.
3. **Atualizar Livro**: O programa permite que um livro seja atualizado com novos dados 🔄.
4. **Deletar Livro**: O programa deleta o livro criado 🗑️.

### Exemplo de Execução:

```plaintext
Livro criado com ID: 1

Livros no banco de dados:
ID: 1, Título: O homem mais rico da Babilonia, Autor: George S. Clason, Gênero: Crônica, Ano: 1926, Preço: 22.70

Livro atualizado: true

Livro deletado: true

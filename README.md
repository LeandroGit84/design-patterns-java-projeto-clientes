s
# 🚀 API REST de Clientes com Spring Boot

Sistema desenvolvido durante os estudos na plataforma DIO - Digital Innovation One com foco em construção de APIs REST profissionais utilizando o ecossistema Spring.
Apoio Venilton Falvo Jr. - professor

O projeto aplica conceitos reais de arquitetura backend, tratamento global de exceções, integração com API externa de CEP e organização em camadas seguindo boas práticas do mercado.

---

## ✨ Visão Geral

Esta aplicação permite o gerenciamento completo de clientes:

- ✅ Buscar todos os clientes
- ✅ Buscar cliente por ID
- ✅ Inserir novo cliente
- ✅ Atualizar cliente existente
- ✅ Remover cliente
- ✅ Integração automática com CEP
- ✅ Tratamento elegante de exceções
- ✅ Documentação com Swagger/OpenAPI

Uma API construída não apenas para funcionar, mas para ser lida como um mapa limpo de arquitetura backend. 🧭

---

# 🛠️ Tecnologias Utilizadas

- ☕ Java
- 🌱 Spring Boot
- 🔗 Spring Web
- 🗄️ Spring Data JPA
- 📘 Swagger / OpenAPI
- 🧩 Maven
- 🐘 Banco de Dados relacional
- 🌍 Integração com ViaCEP

---

# 📂 Estrutura Profissional do Projeto

```bash
src/main/java
│
├── controller
│   └── ClienteRestController
│
├── exceptions
│   ├── ClienteNaoEncontradoException
│   ├── ClienteNaoExistException
│   └── EnderecoInvalidoException
│
├── handler
│   └── GlobalExceptionHandler
│
├── model
│   ├── Cliente
│   ├── ClienteRepository
│   ├── Endereco
│   └── EnderecoRepository
│
├── service
│   ├── ClienteService
│   └── impl
│       └── ClienteServiceImpl
```

---

# 🧠 Arquitetura Aplicada

O projeto foi dividido em camadas para manter:

- Separação de responsabilidades
- Facilidade de manutenção
- Código desacoplado
- Melhor escalabilidade
- Leitura mais limpa e profissional

Cada camada possui um propósito específico:

| Camada | Responsabilidade |
|---|---|
| `.controller` | Recebe requisições HTTP |
| `.service` | Regras de negócio |
| `.model` | Entidades e persistência |
| `.exceptions` | Exceções personalizadas |
| `.handler` | Tratamento global de erros |

---

# 🎯 Controller

## `ClienteRestController`

Responsável pelos endpoints da API REST.

### Principais annotations utilizadas

```java
@RestController
@RequestMapping("/clientes")
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PathVariable
@RequestBody
```

Aqui acontece o “porto de entrada” da aplicação.
As requisições chegam como navios HTTP 🚢 e o controller direciona cada uma para sua rota correta.

---

# ⚙️ Service

## `ClienteService`

Interface responsável pelo contrato da aplicação.

### Métodos implementados

```java
buscarTodos()
buscarPorId()
inserir()
atualizar()
deletar()
```

A ideia aqui é desacoplar regra de negócio da implementação.

---

# 🔥 Implementação da Regra de Negócio

## `ClienteServiceImpl`

Classe responsável pela implementação real dos métodos da aplicação.

### Destaque especial

## Método privado:

```java
salvarClienteComCep()
```

Este método centraliza a lógica de persistência do cliente junto ao endereço.

Fluxo aplicado:

```text
Cliente chega →
CEP é validado →
Busca endereço →
Caso não exista:
    consulta ViaCEP →
    salva endereço →
Cliente é persistido
```

Um pequeno motor invisível trabalhando nos bastidores ⚙️

---

# 🌍 Integração com ViaCEP

A aplicação consulta automaticamente os dados do endereço através da API:

https://viacep.com.br

Assim, ao cadastrar um cliente com CEP válido:

- Rua
- Bairro
- Cidade
- Estado

são preenchidos automaticamente.

---

# 🧨 Tratamento Global de Exceções

## Exceptions personalizadas

```java
ClienteNaoEncontradoException
ClienteNaoExistException
EnderecoInvalidoException
```

## `GlobalExceptionHandler`

Centraliza o tratamento de erros utilizando:

```java
@ControllerAdvice
@ExceptionHandler
```

Resultado:

✅ Respostas padronizadas
✅ API mais robusta
✅ Melhor experiência para consumo frontend
✅ Código mais profissional

---

# 📘 Swagger / OpenAPI

A documentação da API foi integrada utilizando Swagger.

Com isso, é possível:

- Testar endpoints
- Visualizar requisições
- Validar respostas
- Explorar a API via navegador

## Endpoint do Swagger

```bash
http://localhost:8080/swagger-ui.html
```

ou

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# 🔄 Exemplo de Endpoints

## Buscar todos os clientes

```http
GET /clientes
```

## Buscar cliente por ID

```http
GET /clientes/{id}
```

## Inserir cliente

```http
POST /clientes
```

## Atualizar cliente

```http
PUT /clientes/{id}
```

## Remover cliente

```http
DELETE /clientes/{id}
```

---

# 🚀 Como Executar o Projeto

## Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

## Acesse a pasta

```bash
cd seu-repositorio
```

## Execute o projeto

```bash
./mvnw spring-boot:run
```

ou diretamente pela IDE.

---

# 🧪 Exemplo de JSON

```json
{
  "nome": "Leandro Santos",
  "telefone": "(13) 99999-9999",
  "endereco": {
    "cep": "11700-000"
  }
}
```

---

# 📚 Conceitos Praticados

- API REST
- Arquitetura em camadas
- Injeção de dependência
- Spring Data JPA
- Persistência de dados
- Tratamento global de exceções
- Consumo de API externa
- Clean Code
- Boas práticas backend

---

# 🏁 Considerações Finais

Este projeto representa mais do que um CRUD.

Ele demonstra:

- preocupação com arquitetura,
- organização profissional,
- separação de responsabilidades,
- tratamento adequado de erros,
- integração entre serviços,
- e construção de APIs escaláveis.

Código backend também comunica personalidade.
Aqui, cada camada conversa como uma engrenagem bem encaixada de uma pequena cidade Java movida a Spring. ☕🌱

---

# 👨‍💻 Autor

Desenvolvido por Venilton Falvo Jr. - professor DIO.

**Leandro Santos**
Estudante de desenvolvimento backend Java & Spring Boot 🚀

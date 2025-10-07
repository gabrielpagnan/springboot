# 🧩 Spring Boot API - Sistema de Chamados

Este projeto é uma **API REST desenvolvida em Java com Spring Boot**, criada para demonstrar conceitos fundamentais de desenvolvimento backend, incluindo herança, relacionamentos JPA, CRUD, validações e tratamento de exceções.  
O sistema gerencia **chamados técnicos**, **clientes** e **técnicos** em um ambiente de suporte.

---

## 🚀 Funcionalidades

- **Herança**:  
  As classes `Cliente` e `Técnico` herdam de `Pessoa`, aplicando o conceito de reutilização de código.

- **Relacionamentos JPA**:  
  Uso de `@OneToMany` e `@ManyToOne` entre `Chamado`, `Cliente` e `Técnico`.

- **CRUD Completo**:  
  Criação, leitura, atualização e exclusão para todas as entidades.

- **Validações**:  
  Anotações como `@Valid`, `@NotBlank` e `@Email` garantem integridade dos dados.

- **Tratamento de Exceções**:  
  Handler global com respostas personalizadas para erros comuns.

- **Documentação Interativa**:  
  Integração com **Swagger UI** para testar endpoints diretamente pelo navegador.

- **Mapeamento Automático**:  
  Uso do **MapStruct** para conversão entre entidades e DTOs.

- **Banco de Dados**:  
  Integração com **PostgreSQL** via JPA/Hibernate.

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **PostgreSQL**
- **MapStruct**
- **SpringDoc OpenAPI (Swagger UI)**
- **Maven**
- **IntelliJ IDEA**

---

## 📋 Pré-requisitos

Antes de executar o projeto, verifique se você possui:

- ☕ **Java 21** ou superior
- 🐘 **PostgreSQL** instalado e rodando
- 🔧 **Maven** instalado
- 💻 **Git** (opcional, para clonar o repositório)

---

## 🔧 Instalação e Configuração

### 1️⃣ Clone o Repositório
```bash
git clone https://github.com/gabrielpagnan/springboot.git
cd springboot
2️⃣ Configure o Banco de Dados
Crie o banco no PostgreSQL:

sql
Copiar código
CREATE DATABASE bd_springboot;
Edite o arquivo:

css
Copiar código
src/main/resources/application.properties
Com as credenciais:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/bd_springboot
spring.datasource.username=postgres
spring.datasource.password=postgres
3️⃣ Instale as Dependências
bash
Copiar código
mvn clean install
🚀 Executando o Projeto
Via terminal:
bash
Copiar código
mvn spring-boot:run
Ou via IntelliJ:
Execute a classe principal:

Copiar código
SpringbootApplication.java
Acesse:
API: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html

📖 Estrutura do Projeto
less
Copiar código
springboot/
├── src/main/java/com/gabrielpagnan/springboot/
│   ├── controller/          # Controladores REST (@RestController)
│   │   ├── ClienteController.java
│   │   ├── TecnicoController.java
│   │   └── ChamadoController.java
│   ├── dto/                 # Data Transfer Objects (DTOs)
│   │   ├── ClienteDTO.java
│   │   ├── TecnicoDTO.java
│   │   └── ChamadoDTO.java
│   ├── exception/           # Tratamento de Exceções
│   │   ├── GlobalExceptionHandler.java
│   │   └── ResourceNotFoundException.java
│   ├── model/               # Entidades JPA (@Entity)
│   │   ├── Pessoa.java
│   │   ├── Cliente.java
│   │   ├── Tecnico.java
│   │   └── Chamado.java
│   ├── model/enums/         # Enums (Perfil, Status, Prioridade)
│   ├── repository/          # Repositórios (@Repository)
│   │   ├── ClienteRepository.java
│   │   ├── TecnicoRepository.java
│   │   └── ChamadoRepository.java
│   ├── service/             # Lógica de Negócio (@Service)
│   │   ├── ClienteService.java
│   │   ├── TecnicoService.java
│   │   └── ChamadoService.java
│   └── SpringbootApplication.java  # Classe Principal
├── src/main/resources/
│   └── application.properties
├── pom.xml                  # Dependências Maven
└── README.md
📡 Endpoints da API
👤 Cliente
Método	Endpoint	Descrição
GET	/api/clientes	Lista todos os clientes
GET	/api/clientes/{id}	Busca cliente por ID
POST	/api/clientes	Cria novo cliente
PUT	/api/clientes/{id}	Atualiza cliente existente
DELETE	/api/clientes/{id}	Remove cliente

🧰 Técnico
Método	Endpoint	Descrição
GET	/api/tecnicos	Lista todos os técnicos
GET	/api/tecnicos/{id}	Busca técnico por ID
POST	/api/tecnicos	Cria novo técnico
PUT	/api/tecnicos/{id}	Atualiza técnico
DELETE	/api/tecnicos/{id}	Remove técnico

🛠 Chamado
Método	Endpoint	Descrição
GET	/api/chamados	Lista todos os chamados
GET	/api/chamados/{id}	Busca chamado por ID
POST	/api/chamados	Cria novo chamado
PUT	/api/chamados/{id}	Atualiza um chamado
POST	/api/chamados/{id}/fechar	Fecha o chamado
DELETE	/api/chamados/{id}	Remove o chamado

🔒 Tratamento de Erros
Código	Descrição	Exemplo
404	Recurso não encontrado	Cliente inexistente
400	Requisição inválida	Campos obrigatórios ausentes
500	Erro interno do servidor	Exceção não tratada

🤝 Contribuindo
Faça um fork do projeto

Crie uma branch para sua modificação

bash
Copiar código
git checkout -b feature/nova-funcionalidade
Faça o commit das mudanças

bash
Copiar código
git commit -m "Adiciona nova funcionalidade"
Envie para o repositório remoto

bash
Copiar código
git push origin feature/nova-funcionalidade
Abra um Pull Request
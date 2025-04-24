# Desafio Técnico de QA Automatizado

Este repositório contém a resolução do desafio técnico para a vaga de Estágio/Júnior em Quality Assurance Engineer da dti digital.

## Cenários de Teste Criados

**Cenário: Tentativa de login com campos vazios**
- Dado que o usuário esteja na página de login do site "Automation Practice"
- Quando o usuário clicar no botão "Sign in" sem preencher os campos de e-mail e senha.
- Então o sistema deve exibir uma mensagem de erro informando que o e-mail é obrigatório.

**Cenário: Criar conta com e-mail inválido**
- Dado que o usuário esteja na página de login do site "Automation Practice"
- Quando o usuário preencher o campo de e-mail com um email inválido (ex: "user@invalid")
- E clicar no botão "Create an account"
- Então o sistema deve exibir uma mensagem de erro informando que o e-mail não é válido.

**Cenário: Recuperação de senha com e-mail não cadastrado**
- Dado que o usuário esteja na página de login do site "Automation Practice"
- Quando o usuário clicar no link "Forgot your password?"
- E preencher o campo de e-mail com um e-mail que não está cadastrado (ex: "notregistered@example.com")
- E clicar no botão "Retrieve password"
- Então o sistema deve exibir uma mensagem informando que não há conta registrada com o e-mail fornecido.

---

## Tecnologias Utilizadas
- **Linguagem**: Java
- **Gerenciador de Dependências**: Maven
- **Framework de Testes**: JUnit 5
- **Framework**: Selenium WebDriver (para automação de testes)
- **Gerenciador de WebDriver**: WebDriverManager
- **IDE**: IntelliJ IDEA

---

## Como Rodar o Projeto

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Google Chrome](https://www.google.com/chrome/)
- Acesso à internet (para o WebDriverManager baixar o `chromedriver` na primeira execução)

---

## Instalação e Execução

1. Clone este repositório:

   ```bash
   git clone https://github.com/JoaoGperez/desafio-tecnico-qa
   cd desafio-tecnico-qa

2. Execute os testes com Maven:

   ```bash
   mvn clean test

---

## Observações
- O WebDriverManager cuida automaticamente do download e configuração do `chromedriver` compatível com a versão do Google Chrome instalada no seu sistema.
- Os testes estão localizados na classe `AuthenticationTests`.
   

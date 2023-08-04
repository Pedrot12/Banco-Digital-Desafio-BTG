
# Projeto Banco Digital

O projeto tem o objetivo de simular o sistema de um banco digital, ele foi feito focado no back-end da aplicação, utilizando Java com Spring Boot e um banco de dados para suas entidades com o PostgreSQL, sendo possível fazer a integração da API.

## Diagrama Entidade Relacionamento e Modelo Entidade Relacionamento

A relação entre as entidades da aplicação foi feita de um modo um para um, em que toda entidade Conta possui um Cliente sendo atribuido sua relação na criação do Cliente, portanto para todo cliente criado uma conta é criada armazenando os atributos do cliente. Sendo essas duas entidades compostas pelos atributos listados no diagrama abaixo.

<p align="center">
    <img  src="Screenshots\DER.jpg">
</p>

## Arquitetura do Projeto

O código principal do projeto foi dividido em 5 instâncias:

Controller - Responsável por receber a requisição do usuário

Entity - Responsável pela estrutura das tabelas e variáveis dos objetos

Form - Responsável por formatar a estrutura dos dados recebidos pela API

Repository - Responsável por se comunicar com o banco de dados através do Spring Data JPA

Service - Responsável por implementar os métodos e serviços realizados pela API

<p align="center">
    <img  src="Screenshots\Arquitetura.png">
</p>

## Execução da aplicação
Para executar a aplicação, primeiramente é necessário iniciar um banco de dados com o nome "bancodigital" no ambiente do PostgreSQL, seguindo os comando abaixos:

    psql -U postgres

    create database bancodigital

Após isso basta iniciar a aplicação em alguma IDE, como o IntelliJ, e abrir a dependência "http://localhost:8080/swagger-ui/index.html", onde é possível testar as requisições e retornos dos serviços da API.

## Teste da API
Através do Swagger UI é possível fazer o teste da API utilizando os métodos GET e POST que controlam os serviços da aplicação. Abaixo serão listados os serviços da aplicação e seus testes no Swagger. Para executar os métodos é necessário clicar no botão "Try it out" para executar o request.

### Cadastro de Cliente
Através desse método é possível cadastrar um novo cliente utilizando o Request body no padrão mostrado abaixo.

<p align="center">
    <img  src="Screenshots\CadastroCliente.jpg">
</p>

### Mostrar todos os cliente
Executando esse request é possível visualizar todos os clientes que estão no banco de dados através do Response body.

<p align="center">
    <img  src="Screenshots\MostraClientes.jpg">
</p>

### Atualizar cadastro do cliente
Essa função altera as informações principais do cliente, deve se fornecer o cpf do cliente que deseja ser atualizado e colocar os novos dados.
<p align="center">
    <img  src="Screenshots\AtualizaCliente.jpg">
</p>

### Buscar cliente
Busca o cliente de acordo com o CPF solicitado
<p align="center">
    <img  src="Screenshots\BuscaCliente.jpg">
</p>

### Mostrar todas as contas

<p align="center">
    <img  src="Screenshots\MostraContas.jpg">
</p>

### Buscar conta
Busca a conta de acordo com o número de conta solicitado
<p align="center">
    <img  src="Screenshots\BuscaConta.jpg">
</p>

### Depositar
Deposita determinado valor na conta de acordo com o numero de conta 
<p align="center">
    <img  src="Screenshots\Depositar.jpg">
</p>

### Sacar
Saca determinado valor da conta de acordo com o numero de conta 
<p align="center">
    <img  src="Screenshots\Sacar.jpg">
</p>

### Apresentar movimentações de saque de uma conta
Mostra o histórico de saques a partir do numero de conta 
<p align="center">
    <img src="Screenshots\MostraSaques.jpg">
</p>

### Apresentar movimentações de deposito de uma conta
Mostra o histórico de depósito a partir do numero de conta 
<p align="center">
    <img src="Screenshots\MostraDepositos.jpg">
</p>




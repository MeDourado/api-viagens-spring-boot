# VSL Viagens API

Bem-vindo à API da VSL Viagens, uma agência de viagens especializada em reservas de voos.

## Seções Principais

1. [Configuração do Ambiente](#configuração-do-ambiente)
2. [Execução da Aplicação](#execução-da-aplicação)
3. [Endpoints Disponíveis](#endpoints-disponíveis)
4. [Testando a API](#testando-a-api)
5. [Futuras Melhorias](#futuras-melhorias)
6. [Contribuição](#contribuição)

## Descrição

Esta API oferece funcionalidades para gerenciar reservas de voos, clientes, detalhes de voos, cadastro de clientes com autenticação e criptografia de senhas.

## Configuração do Ambiente

## Execução

1. Clone o repositório: `git clone https://github.com/seu-usuario/vslviagens-api.git`
2. Navegue até o diretório clonado: `cd vslviagens-api`
3. Execute a aplicação

## Endpoints Disponíveis

A API fornece as seguintes rotas:

- **Login**: Autenticação de usuário.

  - Método: `POST`
  - URL: `http://localhost:8080/auth/logar`

  - Corpo:

```
{
    "email": "teste@example.com",
    "senha": "123"
}
```

- **Cadastrar Usuário**: Registro de novos usuários.

  - Método: `POST`
  - URL: `http://localhost:8080/auth/cadastrar`
  - Corpo:

```
{
    "nome": "teste",
    "email": "teste@example.com", "senha": "123",
    "cargo": "ADMIN"
}
```

- **Listar Países**: Obter a lista de países.

  - Método: `GET`
  - URL: `http://localhost:8080/paises`

- **Atualizar País**: Atualização de informações de um país.

  - Método: `PUT`
  - URL: `http://localhost:8080/paises/id`

- **Deletar País**: Remover um país específico.

  - Método: `DELETE`
  - URL: `http://localhost:8080/paises/id`

- **Buscar País por ID**: Obter informações de um país específico.

  - Método: `GET`
  - URL: `http://localhost:8080/paises/85`

- **Cadastrar País**: Criar um novo país na base de dados.

  - Método: `POST`
  - URL: `http://localhost:8080/paises`
  - Corpo:

```
{
    "nome": ""
}
```

- **Atualizar Voo**: Atualizar informações de um voo existente.

- Método: `PUT`
- URL: `http://localhost:8080/voos/id`
- Corpo:

```
{
    "codigo": "",
    "origem": { "id": "" },
    "destino": { "id": "" },
    "partida": "",
    "chegada": ""
}
```

- **Listar Voos**: Obter a lista de voos disponíveis.

- Método: `GET`
- URL: `http://localhost:8080/voos`

- **Deletar Voo**: Remover um voo específico.

- Método: `DELETE`
- URL: `http://localhost:8080/voos/id`

- **Buscar Voo por ID**: Obter informações de um voo específico.

- Método: `GET`
- URL: `http://localhost:8080/voos/id`

- **Cadastrar Voo**: Adicionar um novo voo à base de dados.

- Método: `POST`
- URL: `http://localhost:8080/voos`
- Corpo:

  ```
  {
    "codigo": "",
    "origem": {
      "id": ""
    },
    "destino": {
      "id": ""
    },
    "partida": "",
    "chegada": ""
  }
  ```

- **Atualizar Detalhes do Voo**: Atualizar detalhes específicos de um voo.

- Método: `PUT`
- URL: `http://localhost:8080/voos/detalhes/8`
- Corpo:

  ```
  {
    "vooId": "",
    "classe": "",
    "preco": "",
    "passageiros": ""
  }
  ```

- **Listar Detalhes do Voo por ID do Voo**: Obter os detalhes de um voo específico pelo ID do voo.

- Método: `GET`
- URL: `http://localhost:8080/voos/detalhes/por-voo/1`

- **Cadastrar Detalhes do Voo**: Adicionar detalhes específicos a um voo.

- Método: `POST`
- URL: `http://localhost:8080/voos/detalhes`
- Corpo:

  ```
  {
    "vooId": "",
    "classe": "",
    "preco": "",
    "passageiros": ""
  }
  ```

- **Buscar Reserva por ID**: Obter informações de uma reserva específica.
- Método: `GET`
- URL: `http://localhost:8080/reservas/39`

## Testando a API

Recomendamos o uso do Insomnia para testar os endpoints. Siga as etapas abaixo:

1. Baixe e instale o Insomnia: [Insomnia](https://insomnia.rest/download).
2. Importe o arquivo `testeApi.json` disponobilizado para o Insomnia na pasta Insomnia_Json.
3. Acesse os endpoints e envie as requisições conforme necessário.

## Futuras Melhorias

#### Sistema de Envio de E-mails

Ira ser incluido confirmações de reserva, atualizações de status (reserva confirmada, reservada em processo, reserva cancelada)

#### Desenvolvimento do Frontend

Desenvolver a interface do usuário do sistema, melhorando a usabilidade e a estética
.

#### Aprimoramento da Segurança

Reforçar as medidas de segurança existentes e implementar práticas adicionais para proteger os dados dos usuários.

#### Entre outros

A api está em progresso e terá constantes atualizações e melhorias.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir pull requests para melhorias na API ou enviar sugestões para o email mariaeduarda.s.dourado@gmail.com

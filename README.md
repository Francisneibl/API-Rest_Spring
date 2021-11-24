# API REST SPRING

## SOBRE O PROJETO

Uma API construída com Spring Boot, para cadastro de filmes e usuários, onde os usuários são classificados em admins ou usuários comuns. 

Usuários comuns podem se cadastrar e listar filmes e classifica-los de 0 a 4, também podem visualizar as classificações de outros usuários e desativar seu próprio usuário.

Usuários admins podem criar, atualizar e apagar filmes, e também podem desativar qualquer usuário.

## :book:  INSTRUÇÕES

Para autenticações de usuários foi utilizado a tecnica de Basic Auth do Spring Security. Esta autenticação pode ser facilmente executado pelo Postman. O projeto inicia com dois usuários, um deles com permissão de admin e outro como usuário comum. 

| USERNAME  | PASSWORD | ROLE  |
| --------- | -------- | ----- |
| superuser | admin    | ADMIN |
| user      | 12345    | USER  |

Antes de iniciar o projeto é necessário criar um banco no Postgres com o nome de 'apimovies', o restante das tabelas serão criadas e populadas pelo **Flyway**.

Nas pasta 'Postman_schema' deste mesmo repositório existe um .json com as requisições utilizadas para testar o projeto.

### Exemplo do uso do Basic Auth no PostMan:

![Alt text](https://github.com/Francisneibl/API-Rest_Spring/blob/master/img/BASIC%20AUTH.PNG)

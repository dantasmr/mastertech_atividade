Sistema simples para controle de ponto de uma empresa.
Permite o cadastro de usuarios e o registro de ponto dos mesmos.

Tecnologias: 
 - Java 8, Spring Boot e Maven.
 - Banco de dados H2.

Arquitetura:
 - Camadas Web, servicos e persistencia.

Formato de dados:
 - JSON

Testes automatizados:
- Na camada de servicos e controller.

Endpoints da API:

POST Criacao de usuario

http://localhost:8080/api/v1/usuarios

API de criacao de usuario.
Todos os atributos devem ser preenchidos, com excecao do id, que sera gerado automaticamente no momento do cadastro.

Atributos: id, nome completo, cpf, email , data de cadastro
headers: Content-Type, application/json


BODY raw

{
	"nome": "XPTO da Silva",
	"cpf": "96170387300",
	"email": "xpto@teste.com.br",
	"datacadastro": "22/03/2020"
}


curl --location --request POST 'http://localhost:8080/api/v1/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
	"nome": "XPTO da Silva",
	"cpf": "96170387300",
	"email": "xpto@teste.com.br",
	"datacadastro": "22/03/2020"
}'


PUT Edicao de usuario 
http://localhost:8080/api/v1/usuarios/1

headers: Content-Type, application/json

BODY raw

{
	"nome": "XPTO da Silva Santos",
	"cpf": "96170387300",
	"email": "xpto@teste.com"
}

curl --location --request PUT 'http://localhost:8080/api/v1/usuarios/1' \
--header 'Content-Type: application/json' \
--data-raw '{
	"nome": "XPTO da Silva Santos",
	"cpf": "96170387300",
	"email": "xpto@teste.com"
}'


GET Consulta de usuario 
http://localhost:8080/api/v1/usuarios/1
Exibi os dados de um usuario de acordo com o id informado.

curl --location --request GET 'http://localhost:8080/api/v1/usuarios/1'

GET Listagem de usuarios 
http://localhost:8080/api/v1/usuarios
Listagem de todos os usuarios cadastrados na base.

curl --location --request GET 'http://localhost:8080/api/v1/usuarios'

POST Batida de ponto (entrada) 
http://localhost:8080/api/v1/usuarios/1/registro_ponto

Criacao: cadastro de uma batida de ponto (seja entrada ou saida) para um usuario especifico, de acordo com o id informado.

Batidas de Ponto:

atributos: id, usuario responsavel pela Batida, data/hora de Batida, tipo da batida (entrada ou saida)
headers: Content-Type, application/json

BODY raw

{
	"batida": "Entrada",
	"datahora": "22/03/2020 01:00:00"
}

curl --location --request POST 'http://localhost:8080/api/v1/usuarios/1/registro_ponto' \
--header 'Content-Type: application/json' \
--data-raw '{
	"batida": "Entrada",
	"datahora": "22/03/2020 01:00:00"
}'

BODY raw

{
	"batida": "Saida",
	"datahora": "22/03/2020 02:00:00"
}

curl --location --request POST 'http://localhost:8080/api/v1/usuarios/1/registro_ponto' \
--header 'Content-Type: application/json' \
--data-raw '{
	"batida": "Saida",
	"datahora": "22/03/2020 02:00:00"
}'

GET Batida de ponto (listagem) 
http://localhost:8080/api/v1/usuarios/1/registro_ponto

Listagem de todas as batidas de ponto de um unico usuario. Retorna na resposta, alem da lista de batidas, o total de horas trabalhadas.

curl --location --request GET 'http://localhost:8080/api/v1/usuarios/1/registro_ponto'

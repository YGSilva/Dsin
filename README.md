# Dsin
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/YGSilva/Iniflex/blob/master/LICENCE) 

# Sobre o projeto

Projetinho construido para um teste mão na massa referente a uma vaga de Desenvolvedor na empresa [DSIN | Tecnologia da Informação](https://www.dsin.com.br).

O projeto tem como premissa a criação de um sistema de salão de beleza onde: 

1 – Os clientes poderiam fazer seu agendamento de forma online.

2 – Seria permitido a alteração via sistema até 2 dias antes do agendado, faltando menos que 2 dias a alteração via sistema é impossível, se só poderá ser feita via telefobe.

3 – Imprimir todos os agendamentos realizados (com seus detalhes) em determinado período.

## Opção operacional e gerencial

4 – Permitido alterar os dados de um agendamento quando ligassem via telefone.

5 – Permitido alterar o status do agendamento do cliente.

6 – Desempenho semanal.

## Observações adicionais sobre o projeto

Foram deixado de ser feitos as rotas referentes ao topico 3 e 6 por erro não solucionado em relação a passagem de parametro por data na hora em que ia dar o SELECT na base de dados.

Projeto feito totalmente em inglês.

Utilizado Padrão REST.

Projeto feito usando a IDE STS, por onde eu recomendo eu recomendo que seja rodado o projeto em caso de teste.

Foi utilizado o banco de dados H2, as informações para acesso estão no arquivo [application-test](https://github.com/YGSilva/Dsin/blob/master/src/main/resources/application-test.properties), a [URL](http://localhost:8080/h2-console) para acesso ao banco de dados ficara disponível após rodar aplicação pela IDE.

Deixei alguns inserts na base por meio do arquivo [import.sql](https://github.com/YGSilva/Dsin/blob/master/src/main/resources/import.sql).

As imagens com os testes feito via Postman estão na pasta [assets](https://github.com/YGSilva/Dsin/tree/master/assets).

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Banco de dados
- H2 database

## Testes
- Postman

# Autor

Yago Gonçalves da Sivla

https://www.linkedin.com/in/yago-gonçalves-da-silva/


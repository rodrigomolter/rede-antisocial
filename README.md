# Rede Antisocial - Projeto Crescer

Uma rede social similar ao twitter, onde o usuário pode 'descurtir' as publicações. 
Ao descurtir uma publicação o usuário deixa de receber em seu feed qualquer publicação que contenha as hashtags contidas na publicação que ele descurtiu.

Por exemplo, ao descurtir a publicação:
```
"Neymar joga muito ein #futebol #neymar".
```
O usuário deixara de receber todas as publicações que contenham as hashtags futebol e neymar.

Assim como em uma rede social, também foi implementada as funcionalidades básicas como login, cadastro de usuário, busca por usuários e a possibilidade de "perseguir" outros usuários.

### Tecnologias
O projeto foi desenvolvido em JAVA, utilizando Maven e Spring Framework. Também foram realizadas a criação de alguns testes unitários com JUnit
A base de dados foi H2 com Hibernate para o relacionamento das entidades.
Ja o front end foi desenvolvido através da modificação de um template e a utilização de Mustache JS e JQuery

###
Esse projeto foi usado como Trabalho de Conclusão de curso no [Programa Crescer, pela CWI Software](https://cwi.com.br/talentos/formacao/crescer) em 2014.

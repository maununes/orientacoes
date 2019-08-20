# orientacoes
Projeto para implementação de lista de tarefas onde o usuário pode criar, remover e marcar/desmarcar as concluídas.
Tecnologias utilizadas: Spring Framework 5, Springboot 2 , JSF,
 Primefaces, Hibernate, JPA, HSQLDB, REST, AngularJS e Bootstrap 4.

## Hospedagem
Versão Spring:
https://mauriciomoia-orientacoes.herokuapp.com/
Versão AngularJS:
https://mauriciomoia-orientacoes.herokuapp.com/angular

## Deploy em ambiente local
1. Eclipse com o plugin SpringTools
2. Eclipse > Run > SpringBoot Application

## Implementação Spring

Foi criada a entidade **Item** que possui as pripriedades:
>id
>nome
>ativo

Onde **nome** é o nome da tarefa e **ativo** determina de a tarefa foi marcada como feita, os valores desse campo são 1 para feito e 0 para não feito.

Para o banco de dados foi utilizado o HSQLDB, que é um banco interno à aplicação.Foi criado o arquivo **src/main/resources/db/migration/V1__items.sql** para guardar o sql de criação da tabela referente a entidade **Item**.

A interface **ItemRepository** extende JpaRepository que fornece a comunicação com o banco.

O controller **ItemListController** se encarrega de mostrar a rota "/" raiz da url do sistema.
O arquivo **item-list.xhtml** contém um formulário para criação da tarefa e um datatable que mostra as tarefas cadastradas.

## Implementação AngularJS

Nessa arquitetura foi construída uma api REST onde o front-end consulta a api para obter e modificar dados.
O controller **ApiController** possui os métodos:
>list: lista todas as tarefas
>add: cadastra uma nova tarefa
>ativa: muda atributo ativo para 1, de uma tarefa
>inativa: muda atributo ativo para 0, de uma tarefa
>remove: remove uma tarefa
Todas as interfaces acima retornam um json com a lista atualizada de tarefas.

O controller **AngularController** foi criado para serir a página **angular.jsp** que contém o html da one-page-app e o arquivo **app.js** contém o código da aplicação AngularJS.

Na aplicação Angular, foram colocados métodos nos componentes para seus eventos de onclick dispararem a consulta à api.



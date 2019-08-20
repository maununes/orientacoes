<!DOCTYPE html>
<html>
  <head>  
	<meta charset="UTF-8">
    <title>AngularJS Lista de Tarefas</title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  </head>
  <body ng-app="app" class="ng-cloak" ng-controller="AppController">
      <div class="content" style="text-align:center">
      <h1>Lista de Tarefas</h1>
      	<div class="row">
      		<div class="col-md-4">
      		</div>
      		<div class="col-md-3" style="text-align:left">
      			<input class="form-control" placeholder="informe a tarefa e marque/desmarque" type="text" ng-model="tarefa" >
      		</div>
      		<div class="col-md-1" style="text-align:left">
      			<button class="btn btn-primary" ng-click="add()">Criar</button>
      		</div>
      		<div class="col-md-4">
      		</div>
      	</div>
      	<br>
      	<div class="row">
      		<div class="col-md-4">
      		</div>
      		<div class="col-md-4" style="text-align:left">
		  		<div ng-repeat="item in lista">
		  			<input class="" type="checkbox" ng-checked="item.ativo" ng-click="toggle(item.id,item.ativo)">
		  			{{item.nome}}
		  			<button class="btn btn-danger btn-sm" ng-click="remove(item.id)">x</button>
		  			<br>
		  		</div>
      		</div>
      		<div class="col-md-4">
      		</div>
      	</div>
      	
          
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="js/app.js"></script>
  </body>
</html>
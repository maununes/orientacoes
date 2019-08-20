var app = angular.module('app', []);
app.controller('AppController', ['$scope', '$http',function($scope,$http) {
	$scope.lista = [];
	$scope.tarefa = null;
	$scope.list = function(){
	    $http({
	      method: 'GET',
	      url: '../../list'
	    }).then(function successCallback(response) {
	        $scope.lista = response.data;
	      }, function errorCallback(response) {
	        alert('Ocorreu um erro');
	    });
	};
	
	$scope.add = function(){
		if(!$scope.tarefa){return;}
	    $http({
	      method: 'GET',
	      url: '../../add/'+$scope.tarefa
	    }).then(function successCallback(response) {
	        $scope.lista = response.data;
	        $scope.tarefa = null;
	      }, function errorCallback(response) {
	        alert('Ocorreu um erro');
	    });
	};
	
	$scope.toggle = function(id,ativo){
		if(ativo){
			$scope.inativa(id);
		}else{
			$scope.ativa(id);
		}
	}
	
	$scope.ativa = function(id){
	    $http({
	      method: 'GET',
	      url: '../../ativa/'+id
	    }).then(function successCallback(response) {
	        $scope.lista = response.data;
	      }, function errorCallback(response) {
	        alert('Ocorreu um erro');
	    });
	};
	
	$scope.inativa = function(id){
	    $http({
	      method: 'GET',
	      url: '../../inativa/'+id
	    }).then(function successCallback(response) {
	        $scope.lista = response.data;
	      }, function errorCallback(response) {
	        alert('Ocorreu um erro');
	    });
	};
	
	$scope.remove = function(id){
	    $http({
	      method: 'GET',
	      url: '../../remove/'+id
	    }).then(function successCallback(response) {
	        $scope.lista = response.data;
	      }, function errorCallback(response) {
	        alert('Ocorreu um erro');
	    });
	};
	
	//init
	$scope.list();
}]);
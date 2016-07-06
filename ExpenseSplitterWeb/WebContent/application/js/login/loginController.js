'use strict';

angular.module('login').controller('LoginController', function(LoginService, $scope, $state){
	
	$scope.user = {};
	$scope.message = "";
	
	
	this.login = function(){
		if(LoginService.validateUser($scope.user.username, $scope.user.password)){
			$state.go('/home');
		}
		$scope.message = "Username/Password is invalid";
	}
})
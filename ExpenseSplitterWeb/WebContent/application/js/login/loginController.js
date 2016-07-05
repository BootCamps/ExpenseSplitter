var loginModule = angular.module("login",[]);
loginModule.controller("LoginController", function($state, $scope){
	$scope.createGroup = function(){
		$state.go("group");
	}
})
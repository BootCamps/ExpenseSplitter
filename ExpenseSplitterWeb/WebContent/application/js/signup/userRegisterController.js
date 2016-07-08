angular.module('signup').controller('UserRegistrationController', function(UserService, $scope){
	$scope.user = {};
	$scope.register = function(){
		UserService.register($scope.user);
	}
})

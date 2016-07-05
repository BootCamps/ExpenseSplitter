var signUpModule = angular.module('signup', []);

signUpModule.controller("userRegisterController", ['$scope', 'userService', function($scope , userService) {
	alert($scope.user.userName);
	$scope.registerUser = userService.registerUser($scope.user);
}])


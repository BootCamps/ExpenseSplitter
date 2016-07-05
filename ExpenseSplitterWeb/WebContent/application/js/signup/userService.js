var signUpModule = angular.module("group", []);

signUpModule.service("UserService", function($scope, $http) {

	$scope.registerUser = function(user) {
		var user = angular.toJson($scope.user);
		$http.post('/rest/user/register', user).success(function(data) {
			if (data) {
				$scope.message = "User registered successfully";
				$scope.errorStyle = "alert alert-success";
				return data;
			} else {
				$scope.message = "Username already exists!";
				$scope.errorStyle = "alert alert-danger";
			}
		}).error(function(data, status) {
			alert("AJAX failed to get data, status=" + status);
		});

	}
});

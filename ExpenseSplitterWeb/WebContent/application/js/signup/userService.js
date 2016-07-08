(function() {
	angular.module('signup').factory('UserService', userService);

	function userService($http) {
		return {
			register: function(user){
				alert(user)
				$http.post('rest/user/register', user).success(function(data) {
					if (data) {
						$state.go("/home");
					} else {
						$scope.message = "Username already exists!";
						$scope.errorStyle = "alert alert-danger";
					}
				}).error(function(data, status) {
					alert("AJAX failed to get data, status=" + status);
				});
			}
		}
    }
})();


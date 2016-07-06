(function() {
	angular.module('login').factory('LoginService', loginService);

	function loginService($http) {
		
		return {
			validateUser: function(user, pass){
				
			}
		}
    }
})();


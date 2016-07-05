'use strict';

angular.module('expenseSplitterApp').controller('LoginController', function(loginService){
	var validuser = function(username, password){
			if(loginService.validateUser(username, password)){
				return "Success";
			}
			return "Username/Password is invalid";
		}
})
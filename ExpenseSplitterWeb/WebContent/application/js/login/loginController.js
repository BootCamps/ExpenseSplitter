function login(loginService){
	this.validUser = function(username, password){
		
		if(loginService.validateUser(username, password)){
			return "Success";
		}
		return "Username/Password is invalid";
	}
}
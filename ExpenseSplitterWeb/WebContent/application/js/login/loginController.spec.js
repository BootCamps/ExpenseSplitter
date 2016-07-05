
describe("ExpenseSplitter",function(){
	
	var loginService = {
			validateUser:function(user, pass){
				return false;
			}
	}
	it("Should return Success if username and password is valid", function(){
		spyOn(loginService,'validateUser').and.returnValue(true);
		var message= new login(loginService).validUser("user", "pass");
		expect(message).toEqual("Success");
	});
	
	it("Should pass password and username to userService ", function(){
		var loginServiceSpy = spyOn(loginService,'validateUser');
		new login(loginService).validUser("user", "pass");
		expect(loginServiceSpy).toHaveBeenCalledWith("user", "pass");
	});
	
	it("Should return Username/Password is invalid message if userService says it is invalid", function(){
		var message= new login(loginService).validUser("user", "pass");
		expect("Username/Password is invalid").toEqual(message);
	});
	
});
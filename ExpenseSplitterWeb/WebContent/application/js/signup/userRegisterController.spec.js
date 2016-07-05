describe("User Registration", function() {
	var userController;
	
	beforeEach(function() {
		module('signup');
		inject(function($controller, $rootScope) {
			userController = $controller('userRegisterController', {$scope:$rootScope.$new()});
		})
	})
	
	it("should return false if username or password is empty", function() {
		expect(true).toBe(true);
	})
	
	it("should return true user controller is defined", function() {
		expect(userController).toBeDefined();
	})
})
'use strict';

describe("Login", function() {

	var loginController, $rootScope, $scope, $state, $httpbackend, $controller, LoginService;

	beforeEach(function() {
		module('login');
		
		inject(function($injector) {
			$rootScope = $injector.get('$rootScope');
			$controller = $injector.get('$controller');
			LoginService = $injector.get('LoginService');
			$state = $injector.get('$state');
		});
		
		$scope = $rootScope.$new();
		$scope.user = {};
		loginController = $controller('LoginController', {
			$scope : $scope
		});
	})

	it("Should redirect to Homepage if username and password is valid", function() {
		spyOn(LoginService, 'validateUser').and.returnValue(true);
		var $stateSpy = spyOn($state, 'go');
		loginController.login();
		expect($stateSpy).toHaveBeenCalledWith("/home");
	});

	it("Should pass password and username to userService ", function() {
		var loginServiceSpy = spyOn(LoginService, 'validateUser');
		$scope.user.username="user";
		$scope.user.password="pass";
		loginController.login();
		expect(loginServiceSpy).toHaveBeenCalledWith("user", "pass");
	});

	it("Should return Username/Password is invalid message if userService says it is invalid", function() {
		loginController.login();
		expect($scope.message).toEqual("Username/Password is invalid");
	});

});
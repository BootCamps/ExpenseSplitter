'use strict';

describe('GroupController', function () {
	var ctrl;
	var _scope;
	beforeEach(function() {
		
		module('group');
		
		inject(function($controller, $rootScope) {
			_scope = $rootScope.$new();
			var  _http = {};
			ctrl = $controller('GroupController', {$scope : _scope, $http : _http});
		});
		
	});
	
	it("Should define the Group Controller", function(){
		expect(ctrl).toBeDefined();
	});
	
	it("should invoke createGroup method on click of button and return group name", function(){
		_scope.groupName= "test";
		expect("test").toBe(_scope.createGroup());
	});

});
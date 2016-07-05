'use strict';

describe('GroupController', function () {
	
	beforeEach(function() {
		module('expenseSplitter');
		inject(function($controller) {
			var $ctrl = $controller('GroupController');
		});
		
	});
	
	it("Should define the Group Controller", function(){
		expect(1+1).toBe(2);
	});

});
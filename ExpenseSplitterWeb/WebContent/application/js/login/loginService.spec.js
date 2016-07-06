'use strict';

describe('LoginService:', function () {

    var LoginService, $httpBackend;

    beforeEach(function () {
        module('login');

        inject(function ($injector) {
            LoginService = $injector.get('LoginService');
            $httpBackend = $injector.get('$httpBackend');
        });

    });

    afterEach(function () {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    it('is defined', function() {
    	expect(LoginService).toBeDefined();
    });
});

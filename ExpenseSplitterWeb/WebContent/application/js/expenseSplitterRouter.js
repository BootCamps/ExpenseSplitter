'use strict';

/*
 * Define application module
 */
var expenseSplitterApp = angular.module('expenseSplitterApp', ['ui.router']);


expenseSplitterApp.config(['$stateProvider', function($stateProvider){

    $stateProvider
        .state('login', {
            url: "/login",
            templateUrl: "application/login/login.html"
        });
        
    }]).run(function($state) {
    	$state.go("login");
    })

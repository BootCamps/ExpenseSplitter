'use strict';

/*
 * Define application module
 */
var expenseSplitterApp = angular.module('expenseSplitterApp', ['ui.router']);


expenseSplitterApp.config(['$stateProvider', function($stateProvider){

    $stateProvider
        .state('login', {
            url: "/login",
            //controller: "LoginController",
            templateUrl: "application/login/login.html"
        });
        
    }]).run(function($state) {
    	$state.go("login");
    })

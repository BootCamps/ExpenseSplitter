'use strict';

/*
 * Define application module
 */
var expenseSplitterApp = angular.module('expenseSplitterApp', ['ui.router', 'group', 'signup']);


expenseSplitterApp.config(['$stateProvider', function($stateProvider){

    $stateProvider
        .state('login', {
            url: "/login",
            templateUrl: "application/login/login.html"
        })
        .state('signup', {
            url: "/user",
            templateUrl: "application/signup/userRegister.html"
        })
        .state('group', {
            url: "/group",
            controller: "GroupController",
            templateUrl: "application/group/createGroup.html"
        });
        
    }]).run(function($state) {
    	$state.go("login");
    })

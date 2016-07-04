'use strict';

expenseSplitterApp.controller('expenseSplitterController',
        [ '$scope', '$state', '$stateParams', '$rootScope', '$location', function($scope, $state, $stateParams, $rootScope, $location) {

            $rootScope.$on('$stateChangeError', function() {
                var error = arguments[5];
                console.info('ERROR ($stateChangeError): ', error);
            });
            
            $scope.logout = function() {
            	$rootScope.loggedUser = '';
            }
                       
        } ]);

groupModule.controller("GroupController", [ '$scope', '$http', function($scope, $http) {

    $scope.createGroup = function() {
        var groupName = angular.toJson($scope.groupName);
        // groupService.createGroup($scope.groupName);
        // groupService.retrieveGroups();
        /*
         * $scope.gridGroupOptions.data.push({ "name" : $scope.groupName });
         */
        $scope.groupName = '';
    };

    $scope.groupColumns = [ {
        field : 'name'
    } ];

    $scope.gridGroupOptions = {
        enableSorting : true,
        enableRowSelection : true,
        columnDefs : $scope.groupColumns,
        onRegisterApi : function(gridApi) {
            $scope.gridApi = gridApi;
            var cellTemplate = 'ui-grid/selectionRowHeader';
            $scope.gridApi.core.addRowHeaderColumn({
                name : 'rowHeaderCol',
                displayName : '',
                width : 30,
                cellTemplate : cellTemplate
            });
        }
    };

    $scope.gridGroupOptions.data = $scope.groups;

    $scope.columns = [ {
        field : 'name'
    }, {
        field : 'email'
    } ];
    $scope.gridOptions = {
        enableSorting : true,
        enableRowSelection : true,
        columnDefs : $scope.columns,
        onRegisterApi : function(gridApi) {
            $scope.gridApi = gridApi;
            var cellTemplate = 'ui-grid/selectionRowHeader';
            $scope.gridApi.core.addRowHeaderColumn({
                name : 'rowHeaderCol',
                displayName : '',
                width : 30,
                cellTemplate : cellTemplate
            });
        }
    };

    $scope.gridOptions.data = [ {
        'name' : 'Ilangovan',
        'email' : 'rilangov@ford.com'
    }, {
        'name' : 'Kamal',
        'email' : 'rkamala1@ford.com'
    }, {
        'name' : 'Devakumar',
        'email' : 'gdevakum@ford.com'
    } ];
} ])
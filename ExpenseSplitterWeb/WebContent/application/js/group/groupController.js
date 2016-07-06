angular.module("group").controller("GroupController", [ '$scope', '$http', 'GroupService',
		function($scope, $http, groupService) {

			$scope.createGroup = function() {
				var groupName = $scope.groupName;
				var promise = groupService.createGroup(groupName);
	            promise.then(function(response) {
	                var groupName = response.data.groupName;
	                var groupCreatedBy = response.data.createdBy;
	                $scope.gridOptions.data.push({'name': groupName});
	            }, function() {
	                alert("Error");
	            });
				return groupName;
			};

			var groupColumns = [ {
				field : 'name'
			} ];
			
			$scope.gridOptions = {
				enableSorting : true,
				enableRowSelection : true,
				columnDefs : groupColumns
			};
			
			$scope.gridOptions.data = [];

		} ])
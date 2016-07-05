var groupModule = angular.module("group", []);

groupModule.service("GroupService", function($scope, $http) {

	$scope.createGroup = function(groupName) {
		$http.post('/rest/group/create', groupName).success(function(data) {
			if (data) {
				$scope.message = "GroupName created successfully";
				$scope.errorStyle = "alert alert-success";
				return data;
			} else {
				$scope.message = "GroupName already exists!";
				$scope.errorStyle = "alert alert-danger";
			}
		}).error(function(data, status) {
			alert("AJAX failed to get data, status=" + status);
		});

	}

	$scope.retrieveGroups = function() {
		$http.get('/rest/group/groupList').success(function(data) {
			$scope.groups = data;
		}).error(function(data, status) {
			alert("AJAX failed to get data, status=" + status);
		});
	}

});

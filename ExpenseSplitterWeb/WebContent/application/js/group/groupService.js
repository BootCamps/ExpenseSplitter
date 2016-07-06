angular.module("group").service("GroupService", function($http) {

	this.createGroup = function(groupName) {
		return $http({
            method : 'POST',
            url : 'rest/group/createGroup',
            data : groupName,
            headers : {
                'Content-Type' : 'application/json'
            }
        });
	}
});

var ctCenter = angular.module('ctCenter',[]);
ctCenter.controller('TeacherController',function($scope,$http) {
    $http.get({
        method : "GET",
        url : ""
    }).then(function mySuccess(response) {
        $scope.teachers = response.data;
    });
});
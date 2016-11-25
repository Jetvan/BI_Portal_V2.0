/**
 * index加载 controller
 */
infopowerWebApp.controller('indexCtrl', ['$scope', '$http', '$controller', '$routeParams',
    function ($scope, $http, $controller, $routeParams) {
        $controller('baseCtrl', {$scope: $scope, $http: $http});
        $scope.leftMenuClickedId=null;

    }
]);

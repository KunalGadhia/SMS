angular.module("sms.states.admin.main", [])
        .config(function ($stateProvider, adminTemplateRoot) {
            $stateProvider.state('admin', {
                'url': '/admin',
                'templateUrl': adminTemplateRoot + '/main.html',
                'controller': 'AdminMainController'
            });
//            $stateProvider.state('admin.masters_menu', {
//                'url': '/masters_menu',
//                'templateUrl': adminTemplateRoot + '/masters_menu.html',
//                'controller': 'AdminMasterMenuController'
//            });

        })
        .controller('AdminMainController', function ($scope, $stateParams, $state, paginationLimit, UserService) {
            console.log("Admin Main Controller");
            $scope.logout = function () {
                console.log("Inside Logout");
                UserService.logout({}, function () {
                    $state.go("login", {
                        'message': 'Logged Out Successfully!'
                    });
                });
            };
        });
//        .controller('AdminMasterMenuController', function (PracticeDetailsService, CategoryService, UserService, $rootScope, $scope, $stateParams, $state, paginationLimit) {
//            $scope.user = $rootScope.currentUser;            
//            $scope.userPromise = UserService.findByUsername({
//                'username': $scope.user.username
//            }, function (userObject) {
//                $scope.userObject = userObject;
//            });
//            
//        });        
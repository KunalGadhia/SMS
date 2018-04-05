/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sms.states", ['ngAnimate', 'ui.bootstrap'])
        .config(function ($stateProvider, templateRoot, $sceDelegateProvider) {
            $stateProvider.state('login', {
                'url': '/login',
                'templateUrl': templateRoot + '/login.html',
                'controller': 'LoginController'
            });
            $stateProvider.state('signup', {
                'url': '/signup',
                'templateUrl': templateRoot + '/sign_up.html',
                'controller': 'SignupController'
            });
//            $stateProvider.state('login.register', {
//                'url': '/register',
//                'templateUrl': templateRoot + '/register.html',
//                'controller': 'RegisterController'
//            });
//            $stateProvider.state('main', {
//                'url': '/main',
//                'templateUrl': templateRoot + '/main.html'
//            });
//            $stateProvider.state('main.masters', {
//                'url': '/masters',
//                'templateUrl': templateRoot + '/masters/menu.html'
//            });
//            $sceDelegateProvider.resourceUrlWhitelist([
//                'https://www.youtube.com/embed/**'
//            ]);
        })
        .controller('LoginController', function ($scope, $state, $stateParams, $timeout, UserService, AuthFactory) {
            console.log("Coming to Login COntroller");
            $scope.username = $stateParams.username;
            $scope.message = $stateParams.message;
            $scope.error = $stateParams.error;
            $scope.showRegistration = true;
            $timeout(function () {
                $scope.message = false;
            }, 3000);
            $scope.login = function (username, password) {
                UserService.login({
                    'username': username,
                    'password': password
                }, function (data) {                    
                    AuthFactory.refresh();
                    UserService.findByUsername({
                        'username': data.username
                    }, function (data) {
                        if (data.role === "ROLE_ADMIN") {
                            console.log("Admin Login");
                            $state.go("admin");
                        } else if (data.role === "ROLE_SUPERVISOR") {
                            $state.go("admin");
                        } else if (data.role === "ROLE_TEACHER") {
                            $state.go("admin");
                        } else if (data.role === "ROLE_STUDENT") {
                            $state.go("admin");
                        } else if (data.role === "ROLE_PARENT") {
                            $state.go("admin");
                        }
                    });
                }, function () {
                    console.log("Invalid Person");
                    $scope.error = true;
                    $scope.username = "";
                    $scope.password = "";
                });
            };
        })
        .controller('SignupController', function (UserService, $scope, $state, $stateParams, $timeout, AuthFactory) {

        });


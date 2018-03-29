/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('sms.states.auth', ['sms.constants'])
        .factory('AuthFactory', ['$http', 'contextPath', '$q', '$timeout', function ($http, contextPath, $q, $timeout) {                
                function User() {
                }
                ;

                User.prototype.hasRole = function (roleString) {
                    var isRolePresent = false;
                    angular.forEach(this.authorities, function (authorityObj) {
                        if (authorityObj["authority"] === roleString) {
                            isRolePresent = true;
                        }
                    });
                    return isRolePresent;
                };
                User.prototype.isStudent = function () {
                    return this.hasRole("ROLE_STUDENT");
                };
                User.prototype.isParent = function () {
                    return this.hasRole("ROLE_PARENT");
                };
                User.prototype.isTeacher = function () {
                    return this.hasRole("ROLE_TEACHER");
                };
                User.prototype.isSupervisor = function () {
                    return this.hasRole("ROLE_SUPERVISOR");
                };                
                User.prototype.isAdmin = function () {
                    return this.hasRole("ROLE_ADMIN");
                };

                //Singleton Variable to store the currently logged in User
                var currentUser = null;

                var userChangeCallbacks = [];

                var notifyUserChange = function (newUser) {
                    angular.forEach(userChangeCallbacks, function (callback) {
                        $timeout(function () {
                            callback(newUser);
                        });
                    });
                };

                var exported = {
                    getCurrentUser: function () {
                        return currentUser;
                    },
                    refresh: function () {
                        return $q(function (resolve, reject) {
                            //Get the current user
                            $http.get(contextPath + '/rest/user/current')
                                    .success(function (data) {
                                        currentUser = new User();
                                        for (var key in data) {
                                            currentUser[key] = data[key];
                                        }
                                        notifyUserChange(currentUser);
                                        resolve(currentUser);
                                    })
                                    .error(function (reason) {
                                        reject(reason);
                                    });
                        });
                    },
                    registerUserChangeHandler: function (callback) {
                        console.log("registered handler: " + callback);
                        userChangeCallbacks.push(callback);
                    }
                };
                return exported;
            }]);


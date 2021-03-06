/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sms.services.user", []);
angular.module("sms.services.user")
        .factory('UserService', function ($resource, restRoot, contextPath) {
            console.log("Rest Root :" + restRoot);
            console.log("Context Path :" + contextPath);
            return $resource(restRoot + '/user/:id', {'id': '@id'}, {
                'login': {
                    'method': 'POST',
                    'url': contextPath + '/access/login',
                    'params': {
                        'username': '@username',
                        'password': '@password'
                    }
                },
                'logout': {
                    'method': 'POST',
                    'url': contextPath + '/access/logout'
                },
                'findByNameLike': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/user_like',
                    'params': {
                        'username': '@username'
                    },
                    'isArray': true
                },
                'findHod': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/hod',                    
                    'isArray': true
                },
                'findHodByCompanyId': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/hod/company_id',
                    'params': {
                      'companyId': '@companyId'  
                    },
                    'isArray': true
                },
                'findByUsername': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/username',
                    'params': {
                        'username': '@username'
                    },
                    'isArray': false
                },
                'findUsersByCompany': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/user/company',
                    'params': {
                        'companyId': '@companyId',
                        'offset': '@offset'
                    },
                    'isArray': true
                },
                'findSfplUsers': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/sfpl',
                    'params': {
                        'offset': '@offset'
                    },
                    'isArray': true
                },
                'findSosUsers': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/sos',
                    'params': {
                        'offset': '@offset'
                    },
                    'isArray': true
                },
                'findByEmployeeId': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/employeeId',
                    'params': {
                        'employeeId': '@employeeId'
                    },
                    'isArray': false
                }
//                ,
//                'findUnapprovedUser': {
//                    'method': 'GET',
//                    'url': restRoot + '/user/find/unapproved_user',
//                    'isArray': true
//                },
//                'countUnapprovedUser': {
//                    'method': 'GET',
//                    'url': restRoot + '/user/count/unapproved_user',
//                    'isArray': false
//                }
            });
        });


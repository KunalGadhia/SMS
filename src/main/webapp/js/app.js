angular.module("sms", [

    //    include libraries
    'ui.router',
    'ngResource',
    'angularFileUpload',
    'googlechart',
//    'kuber.map',
    'ngAnimate',
    'angular.filter',
    'sms.filters',

    //  include constants
    'sms.constants',
    // include directives

    // include services
    'sms.services.user',
//    'kuber.services.category',
//    'kuber.services.practice_details',
//    'kuber.services.office_details',
//    'kuber.services.reviews',
//    'kuber.services.payment_type',
//    'kuber.services.education_qualification',
//    'kuber.services.kuber_services',
//    'kuber.services.services_payment_info',
//    'kuber.services.kuber_services_transaction',
//    'kuber.services.services_availed',
//    'kuber.services.account',
//    'kuber.services.bank',
//    'kuber.services.customer',
//    'kuber.services.reviews',

    // directive services

    //Master States
//    'kuber.states.account',
//    'kuber.states.bank',
//    'kuber.states.customer',
//    'kuber.states.reviews',

    // include controllers and states
    'sms.states',    
    'sms.states.auth',    

    //include user states
//    'kuber.states.user.main',
//    'kuber.states.lawyer.main',
    'sms.states.admin.main'

])

        .run(['$state', '$rootScope', 'AuthFactory', '$location', 'UserService', function ($state, $rootScope, AuthFactory, $location, UserService) {

                AuthFactory.registerUserChangeHandler(function (currentUser) {
                    $rootScope.currentUser = currentUser;
                });

                AuthFactory.refresh().then(function (currentUser) {
                }, function (reason) {

                    $location.path("login");
                });

            }]);

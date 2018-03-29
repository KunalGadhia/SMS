<%-- 
    Document   : index
    Created on : Mar 27, 2018, 12:10:16 PM
    Author     : webdesign
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="sms">
    <head>
        <base href="/sms/" target="_blank">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">

        <!--Libraries-->
        <script src="${pageContext.request.contextPath}/webjars/jquery/1.12.0/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/angularjs/1.5.3/angular.min.js"></script>  
        <script src="${pageContext.request.contextPath}/webjars/nervgh-angular-file-upload/2.1.1/angular-file-upload.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/angular-animate/1.5.3/angular-animate.js"></script>  
        <script src="${pageContext.request.contextPath}/webjars/angular-resource/1.2.28/angular-resource.js"></script>  
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
        <script src="${pageContext.request.contextPath}/webjars/angular-ui-router/0.2.15/angular-ui-router.js"></script>  
        <script src="${pageContext.request.contextPath}/webjars/angular-ui-bootstrap/1.2.5/ui-bootstrap-tpls.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/underscorejs/1.5.1/underscore.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/angular-google-map.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/angular-simple-logger.js"></script>                
        <script src="${pageContext.request.contextPath}/js/lib/fusioncharts.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/fusioncharts.charts.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/fusioncharts.theme.fint.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/ng-google-chart.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/jquery.flexslider-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/scripts.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/lodash.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/angular.filter.min.js"></script>        
        <script src="${pageContext.request.contextPath}/js/lib/angular-bootstrap-lightbox.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/ngComboDatePicker.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/ngComboDatePicker.js"></script>        

        <!--Constants-->
        <script>
            angular.module("sms.constants", [])
                    .constant('contextPath', '${pageContext.request.contextPath}')
                    .constant('restRoot', '${pageContext.request.contextPath}/rest')
                    .constant('templateRoot', '${pageContext.request.contextPath}/templates')
                    .constant('adminTemplateRoot', '${pageContext.request.contextPath}/templates/admin')
                    .constant('supervisorTemplateRoot', '${pageContext.request.contextPath}/templates/supervisor')
                    .constant('teacherTemplateRoot', '${pageContext.request.contextPath}/templates/teacher')
                    .constant('parentTemplateRoot', '${pageContext.request.contextPath}/templates/parent')
                    .constant('studentTemplateRoot', '${pageContext.request.contextPath}/templates/student')
                    .constant('imageRoot', '${pageContext.request.contextPath}/images')
                    .constant('paginationLimit', 10);
        </script>        

        <!-- CSS Files -->

        <!-- Theme JS & CSS Libraries -->
        <!--   Core JS Files   -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>

        <!--  Charts Plugin -->
        <script src="${pageContext.request.contextPath}/assets/js/chartist.min.js"></script>

        <!--  Notifications Plugin    -->
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap-notify.js"></script>

        <!--  Google Maps Plugin    -->
        <!--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>-->

        <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
        <script src="${pageContext.request.contextPath}/assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

        <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
        <script src="${pageContext.request.contextPath}/assets/js/demo.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {

            demo.initChartist();
            $.notify({
            icon: 'pe-7s-gift',
                    message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

            }, {
            type: 'info',
                    timer: 4000
            });
            });
        </script>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <!-- Bootstrap core CSS     -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Light Bootstrap Table core CSS    -->
        <link href="${pageContext.request.contextPath}/assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="${pageContext.request.contextPath}/assets/css/demo.css" rel="stylesheet" />


        <!--     Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

        <!-- Icons & Images -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/icons/spacew.ico">

        <title>School Management System</title>        

        <!--Stylesheet-->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" media="all"/>
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/modal-override.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/corporate_site.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/angular-bootstrap-lightbox.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/w3.css"/>-->

        <!--JavaScript-->
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/js/auth.js"></script>
        <script src="${pageContext.request.contextPath}/js/filters.js"></script>
        <script src="${pageContext.request.contextPath}/js/states.js"></script>

        <!--states-->        
        <!--<script src="${pageContext.request.contextPath}/js/states/admin.js"></script>-->
        <!--<script src="${pageContext.request.contextPath}/js/states/user.js"></script>-->        

        <!--Services-->
        <!--<script src="${pageContext.request.contextPath}/js/services/user_service.js"></script>-->

    </head>
    <body style="font-family: 'Roboto', sans-serif;">
        <div data-ui-view></div>        
    </body>    
</html>

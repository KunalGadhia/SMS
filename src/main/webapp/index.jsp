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
        <!--Trial JS-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
        <!--<script src="${pageContext.request.contextPath}/js/lib/jquery.flexslider-min.js"></script>-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flexslider/2.7.0/jquery.flexslider-min.js"></script>
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
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/light-bootstrap-dashboard.css">
        <!--<script src="${pageContext.request.contextPath}/assets/js/core/botstrap.min.js" type="text/javascript"></script>-->
        <script src="${pageContext.request.contextPath}/assets/js/core/jquery.3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap-notify.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap-switch.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/chartist.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/nouislider.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/demo.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/light-bootstrap-dashboard.js?v=2.0.1" type="text/javascript"></script>
        

        <!-- Icons & Images -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/icons/spacew.ico">

        <title>School Management System</title>        

        <!--Stylesheet-->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" media="all"/>>

        <!--JavaScript-->
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/js/auth.js"></script>
        <script src="${pageContext.request.contextPath}/js/filters.js"></script>
        <script src="${pageContext.request.contextPath}/js/states.js"></script>

        <!--states-->        
        <script src="${pageContext.request.contextPath}/js/states/admin/admin_main.js"></script>
        <!--<script src="${pageContext.request.contextPath}/js/states/user.js"></script>-->        

        <!--Services-->
        <script src="${pageContext.request.contextPath}/js/services/user_service.js"></script>

    </head>
    <body data-ui-view="" style="font-family: 'Roboto', sans-serif;">
        <!--<div></div>-->        
    </body>    
</html>

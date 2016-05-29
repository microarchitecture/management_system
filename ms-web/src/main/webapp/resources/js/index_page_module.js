/**
 * Created by Alex on 08.05.2016.
 */
//Module configuration
angular.module("indexPageModule", ['ngRoute', 'limitsListModule', 'limitsUploadModule'])
    .config(function($routeProvider, $locationProvider){
        $locationProvider.html5Mode(true);
        $routeProvider.when("/limits_list", {
            templateUrl: "resources/static/limits_list.html",
            controller: "limitsListController"
        }).when("/limits_upload", {
            templateUrl: "resources/static/limits_upload.html",
            controller: "limitsUploadController"
        }).when("/exposures_list", {
            templateUrl: "resources/static/exposures_list.html"
        }).when("/exposures_upload", {
            templateUrl: "resources/static/exposures_upload.html"
        }).when("/breaches_list", {
            templateUrl: "resources/static/breaches_list.html"
        }).otherwise({
            templateUrl: "resources/static/default_main_page.html"
        })
    })
    .provider("navigationPanelRequestService", function(){
        return {
            $get : function($http) {
                return {
                    requestJson : function(pageUrl){
                        return $http.get(pageUrl);
                    }
                }
            }
        }
    })
    .service("sharedMainPageData", function(){
        var sharedData;
        return {
            getMainPageData : function(){
                return sharedData;
            },
            setMainPageData : function(mainPageJson){
                sharedData = mainPageJson;
            }
        }
    })
    .controller("indexPageRootController", function($scope, $http, $document, navigationPanelRequestService, sharedMainPageData){
        $scope.treeNavigationMenu = {};
        $scope.requestMainPanelData = function(pageUrl){
            var asyncRequestResult = navigationPanelRequestService.requestJson(pageUrl);
            asyncRequestResult.then(function(response){
                sharedMainPageData.setMainPageData(response.data);
            },
            function(error){
                console.error("Something has happened wrong in indexPageRootController" + error.status);
            });
        };
        angular.element($document).ready(function(){
            $http.get("/navigation_menu/navigation_tree.json")
                .success(function(response){
                    $scope.treeNavigationMenu = response;
                });
        });
});


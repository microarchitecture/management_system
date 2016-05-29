/**
 * Created by Alex on 09.05.2016.
 */
angular.module("limitsListModule", [])
    .controller("limitsListController", function($scope, sharedMainPageData){
        console.log("limitsListController is loaded");
        $scope.limitsGridData = sharedMainPageData.getMainPageData();
        console.log("The data is " + $scope.limitsGridData);
            //function(){
            //if (angular.isDefined(sharedMainPageData.getMainPageData())){
            //    var jsonData = sharedMainPageData.getMainPageData();
            //    console.log("Retrieved data is here - " + jsonData.gridData);
        //return sharedMainPageData.getMainPageData();
        //    }
        //}
    });
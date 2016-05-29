/**
 * Created by Alex on 22.05.2016.
 */
angular.module("limitsUploadModule", [])
    .service("uploadLimitsPageRequestService", function($http){
        return {
            validateUploadedFile : function(uploadData) {
                var requestObject = new FormData();
                requestObject.append("uploadedLimits", uploadData);
                $http.post("/limits_upload/validate_file", requestObject, {headers: {'Content-Type' : undefined}})
                    .then(function(response){
                        return response.data;
                    }, function(error) {
                        console.log("Error came when receiving response for '/limits_upload/validate_file'. " +
                        "Check uploadLimitsPageRequestService in limitsUploadModule: " + error);
                    });
            }
        }
    })
    .controller("limitsUploadController", function($scope, uploadLimitsPageRequestService) {
        console.log("limitsUploadController has been loaded");
        $scope.uploadedFile = {};
        $scope.uploadedFileValidationResult = {};
        $scope.validateUploadedFile = function() {
            $scope.uploadedFile = document.getElementById("fileUploadElement").files[0];
            $scope.uploadedFileValidationResult = uploadLimitsPageRequestService.validateUploadedFile($scope.uploadedFile);
        }
    });

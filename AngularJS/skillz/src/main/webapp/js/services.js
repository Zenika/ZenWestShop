'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).
  value('version', '0.1');

//angular.service('Cv', function ($resource) {
//    return $resource('services/consultants/:cvId', {}, {
//        update: {method:'PUT'}
//    });
//});

angular.module('cvService', ['ngResource']).
    factory('Cv', function($resource){

        return $resource('services/consultants/:cvId', {}, {
            query: {method:'GET', isArray:true},
            update: {method:'PUT'}
        });
    });

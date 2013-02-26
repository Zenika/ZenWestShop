'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
var skillzServices = angular.module('skillzApp.services', ['ngResource']);
skillzServices.value('version', '0.1');

skillzServices.factory('Cv', function($resource) {
        return $resource('services/consultants/:cvId', {}, {
            query: {method:'GET', isArray:true},
            update: {method:'PUT'}
        });
    });

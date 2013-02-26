'use strict';


// Declare app level module which depends on filters, and services
var skillzApp = angular.module('skillzApp', ['skillzApp.services', 'skillzApp.filters', 'skillzApp.directives']);

skillzApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/home', {templateUrl: 'partials/home.html', controller: HomeCtrl});
    $routeProvider.when('/example', {templateUrl: 'partials/example.html', controller: CvCtrl});
    $routeProvider.when('/consultants', {templateUrl: 'partials/consultants.html', controller: CvsCtrl});
    $routeProvider.when('/consultant/:id', {templateUrl: 'partials/consultant.html', controller: CvCtrl});
    $routeProvider.when('/editConsultant/:id', {templateUrl: 'partials/editConsultant.html', controller: CvCtrl});
    $routeProvider.when('/newConsultant', {templateUrl: 'partials/editConsultant.html', controller: newCvCtrl});
    $routeProvider.otherwise({redirectTo : '/home'});
  }]);

skillzApp.config(function($locationProvider) {
    $locationProvider.html5Mode(true);
});

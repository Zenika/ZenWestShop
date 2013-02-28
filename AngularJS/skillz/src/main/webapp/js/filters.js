'use strict';

/* Filters */

var skillzFilters = angular.module('skillzApp.filters', ['ngSanitize']);
skillzFilters.filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    }
  }]);

skillzFilters.filter('newlines', function() {
    return function(text){
        return text.replace(/\n/g, '<br/>');
    }
});
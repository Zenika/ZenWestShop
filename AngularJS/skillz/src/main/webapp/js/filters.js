'use strict';

/* Filters */

var skillzFilters = angular.module('skillzApp.filters', []);
skillzFilters.filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    }
  }]);

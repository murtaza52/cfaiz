'use strict';


// Declare app level module which depends on filters, and services
var app = angular.module('mod', ['ui','UIServices','myApp.filters', 'myApp.services', 'myApp.directives', 'btnbar.directive']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/lanes', {templateUrl: 'partials/lanes.html', controller: LanesCtrl});
    $routeProvider.otherwise({redirectTo: '/lanes'});
  }]);

app.run(function($rootScope){
  $rootScope.buttons = [{href: '#/students', icon:'icon-ok'},
                        {href: '#/students', icon:'icon-remove'},
                        {href: '#/students/new', icon:'icon-plus'}];
});

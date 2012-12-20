'use strict';

/* Directives */


angular.module('myApp.directives', []).
  directive('appVersion', ['version', function(version) {
    return function(scope, elm, attrs) {
      elm.text(version);
    };
  }]);

angular.module('btnbar.directive', ['UIServices']).
directive("btnBar", function(){
  return {
    restrict: 'E',
    controller: function($scope, $element,buttonBar) {
                $scope.buttons = buttonBar.buttons;
    },
    template:'<div class="btn-toolbar">' +
      '<a class="btn" ng-repeat="b in buttons" href={{b.href}}>' +
      '<i class={{b.icon}}></i></a></div>',
    replace:true
  }
});


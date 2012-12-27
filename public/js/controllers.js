'use strict';

/* Controllers */

function LanesCtrl($scope, $rootScope, buttonBar) {
  $scope.lanes = [];

  ButtonBar.buttons = [{href: '#/students', icon:'icon-ok'},
                         {href: '#/students', icon:'icon-remove'},
                         {href: '#/students/new', icon:'icon-plus'}];


  $scope.iconClass = function(show){
    if (show){
      return "icon-chevron-up"
    }
    else
    {
      return "icon-chevron-down"
    }
  };
}
LanesCtrl.$inject = ['$scope', '$rootScope'];

function LoginCtrl($scope, openid, authorization){
  $scope.signin = function(provider){
    openid.authenticate(provider);
  };

  $scope.me = "hello";

  $scope.auth = authorization.getAuthMap;
}

LoginCtrl.$inject = ['$scope', 'openid', 'authorization'];

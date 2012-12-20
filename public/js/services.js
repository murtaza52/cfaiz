'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).
  value('version', '0.1');

angular.module('UIServices',[]).
   service('buttonBar', function() {
    this.buttons = [];
});

app.service("openid", ['$http', function($http){
  var providers = {google: 'https://www.google.com/accounts/o8/id'};
  this.authenticate = function(provider){
    var endpoint = providers[provider];
    $http.post('/openid', {identifier: endpoint}).success(function(){});
  };
}]);

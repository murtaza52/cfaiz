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
    var endpoint = 'identifier=' + providers[provider];

    $http({method: 'POST', url: '/openid', headers: {'Content-Type': 'application/x-www-form-urlencoded', 'Accept':'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8', 'Cache-Control':''}, data: endpoint}).success(function(){});
  };
}]);

app.service("authorization", ['$http',function($http){
  var authMap = [];

  $http.get('/authmap').success(function(data){
    console.log("handler:" + data);
    authMap = data;});

  this.getAuthMap = function(){console.log("returning authmap:" + authMap); return authMap;
                       };
}]);



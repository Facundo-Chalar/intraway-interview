'use strict';

angular.module('myApp.fizzView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/fizzView', {
    templateUrl: 'fizzView/fizzView.html',
    controller: 'fizzViewController',
    controllerAs: 'fizzCtrl'
  });
}])

.controller('fizzViewController', ['$http',function($http) {

	this.minValue;
	this.maxValue;
	this.fizzBuzzResponse;
	this.endpointBaseUrl= 'http://localhost:8080/fizzbuzz';

	//Ideally this should be in another module in charge of requests and with params instead of concatenated values,
	//but no time for that today sorry :).

	this.fizzBuzz = function(){
		$http.get(this.endpointBaseUrl+'/'+this.minValue+'/'+this.maxValue).then(function(response){
			this.fizzBuzzResponse = response.data;
		}.bind(this));
	}
}]);
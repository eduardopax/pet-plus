'use strict';

//endereço padrão de acesso das funcionalidades
var path = window.location.protocol + '//' + window.location.hostname + ':'
		+ window.location.port;

var petApp = angular.module('petApp',['blockUI']);

petApp.config(['$locationProvider', function($locationProvider){
    $locationProvider.html5Mode(true);    
}]);


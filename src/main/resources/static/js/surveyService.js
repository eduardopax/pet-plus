'use strict';

petApp.factory('SurveyService', [
		'$http',
		'$q',
		function($http, $q) {

			return {
				submit : function(survey) {
					var deferred = $q.defer();
			        $http.post(path + '/survey/', survey)
			            .then(
			            function (response) {
			                deferred.resolve(response.data);
			            },
			            function(errResponse){
			                console.error('Error while creating User');
			                deferred.reject(errResponse);
			            }
			        );
			        return deferred.promise;
				},
				

				fetchAll : function() {
					return $http.get(path + '/survey/').then(
							function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error while fetching users');
								return $q.reject(errResponse);
							});
				}

			};

		} ]);

'use strict';

petApp.factory('SubscriptionService', [
		'$http',
		'$q',
		function($http, $q) {

			return {
				subscribe : function(subscription) {
					var deferred = $q.defer();
			        $http.post(path + '/subscription/', subscription)
			            .then(
			            function (response) {
			                deferred.resolve(response.data);
			            },
			            function(errResponse){
			                console.error('Error while subscribe');
			                deferred.reject(errResponse);
			            }
			        );
			        return deferred.promise;
				},

				fetchAllGroups : function() {
					return $http.get(path + '/command/groups').then(
							function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error while fetching survays');
								return $q.reject(errResponse);
							});
				}

			};

		} ]);

'use strict';

petApp.controller('SubscriptionController', [ '$scope', 'SubscriptionService',
		'blockUI', function($scope, SubscriptionService, blockUI) {
			var self = this;
		    self.subscription={email:''};
			self.groups = [];
			self.subscribe = function() {
				SubscriptionService.subscribe(self.subscription)
	            .then(function() {
	            	window.location.href = '/operationOk?message=Subscription has been completed!'
	            },
	            function(errResponse){
	            	window.location.href = '/operationNOk?message=' + errResponse.data.message + '!';
	            }
	        );
			};

		} ]);

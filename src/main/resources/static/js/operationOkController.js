'use strict';

petApp.controller('OperationOkController', [ '$scope', 
		'blockUI', '$location', function($scope, blockUI, $location) {
	
			var self = this;
			
		    self.data={message:''};
		    self.data.message = $location.search().message;
		    
		    self.redirect = function(){
		    	window.location.href = '/';
		    };

		} ]);

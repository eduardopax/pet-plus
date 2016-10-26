'use strict';

petApp.controller('SurveyController', [ '$scope', 'SurveyService',
		'blockUI', '$location', function($scope, SurveyService, blockUI, $location) {
	
			var self = this;
			
		    self.survey={email:'',suggestions:'', interesting:'', codeIdentification:''};
		    self.survey.codeIdentification = $location.search().codeIdentification;
		    self.survey.interesting = 5;
			self.surveys = [];
			
			self.submit = function() {
				SurveyService.submit(self.survey)
		            .then(function() {
		            	window.location.href = '/operationOk?message=Survey has been completed!'
		            },
		            function(errResponse){
		            	window.location.href = '/operationNOk?message=' + errResponse.data.message + '!';
		            }
		        );
				
			};
			

		} ]);

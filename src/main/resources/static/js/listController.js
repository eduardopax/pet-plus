'use strict';

petApp.controller('SurveyController', [ '$scope', 'SurveyService',
		'blockUI', function($scope, SurveyService, blockUI) {
	
			var self = this;
			
		    self.survey={email:'',suggestions:'', interesting:''};
			self.surveys = [];
			
			self.fetchAll = function() {
				SurveyService.fetchAll().then(function(surveysData) {
					self.surveys = surveysData;
				}, function(errResponse) {
					console.error('Error while fetching surveys');
				});
			};


			self.fetchAll();

		} ]);

<!DOCTYPE html>
<base href="/">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta charset="utf-8">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<core:url value="/img/icon.png" />" rel="icon"
	type="image/png" />

<title>Pet Plus</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<link href="/css/angular-block-ui.min.css" rel="stylesheet">

<script src="<core:url value='/js/lib/angular.min.js' />"></script>
<script src="<core:url value='/js/lib/angular-block-ui.min.js' />"></script>

</head>

<body ng-app="petApp" class="ng-cloak">
	<div class="container" ng-controller="SurveyController as ctrl">
		<div class="text-center">
			<h3>Please, give some information to improve our service.
			</h3>
			<br />
			<br />
			<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">

				<!-- RADIO BUTTONS -->
				<label>How much are you interested about Pet Plus?</label>
				<div class="form-group">
					<div class="radio">
						<label> <input type="radio" name="interesting" value="5"
							ng-model="ctrl.survey.interesting"> 5
						</label> <label> <input type="radio" name="interesting" value="4"
							ng-model="ctrl.survey.interesting"> 4
						</label> <label> <input type="radio" name="interesting" value="3"
							ng-model="ctrl.survey.interesting"> 3
						</label> <label> <input type="radio" name="interesting" value="2"
							ng-model="ctrl.survey.interesting"> 2
						</label> <label> <input type="radio" name="interesting" value="1"
							ng-model="ctrl.survey.interesting"> 1
						</label>
					</div>

				</div>

				<div class="form-group">
					<label for="suggestions">Suggestions:</label>
					<textarea class="form-control" rows="5" id="suggestions"
						ng-model="ctrl.survey.suggestions"></textarea>
				</div>

				<div class="form-group">
					<input type="submit" value="Send feedback"
						class="btn btn-primary btn-sm">
				</div>
		</div>
		<br/><br/><br/>
		<div class="text-center">Pet Plus Team</div>
		</form>
	</div>
	</div>

	<script src="<core:url value='/js/application.js' />"></script>
	<script src="<core:url value='/js/surveyService.js' />"></script>
	<script src="<core:url value='/js/surveyController.js' />"></script>

	<script src="<core:url value='/js/lib/jquery.min.js' />"></script>
	<script src="<core:url value='/js/lib/bootstrap.min.js' />"></script>
</body>
</html>

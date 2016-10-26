<!DOCTYPE html>
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

<title>Pet Plus</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<link href="/css/angular-block-ui.min.css" rel="stylesheet">

<script src="<core:url value='/js/lib/angular.min.js' />"></script>
<script src="<core:url value='/js/lib/angular-block-ui.min.js' />"></script>

</head>

<body ng-app="petApp" class="ng-cloak">

	<div class="container-fluid" ng-controller="SurveyController as ctrl">
		<div class="row">
			<div class="col-xs-12 text-center">Registrations</div>
		</div>
		<table class="table">
			<tr>
				<th>E-mail</th>
				<th>Interesting (1 to 5)</th>
				<th>Suggestions</th>
			</tr>
			<tr ng-repeat="survey in ctrl.surveys">
				<td><span ng-bind="survey.email"></td>
				<td><span ng-bind="survey.interesting"></td>
				<td><span ng-bind="survey.suggestions"></td>
			</tr>
		</table>
		<br/><br/><br/>
		<div class="text-center">Pet Plus Team</div>
	</div>

	<script src="<core:url value='/js/application.js' />"></script>
	<script src="<core:url value='/js/surveyService.js' />"></script>
	<script src="<core:url value='/js/listController.js' />"></script>

	<script src="<core:url value='/js/lib/jquery.min.js' />"></script>
	<script src="<core:url value='/js/lib/bootstrap.min.js' />"></script>

</body>
</html>

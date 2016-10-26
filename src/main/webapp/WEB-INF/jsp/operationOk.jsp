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

<title>Pet Plus</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<link href="/css/angular-block-ui.min.css" rel="stylesheet">

<script src="<core:url value='/js/lib/angular.min.js' />"></script>
<script src="<core:url value='/js/lib/angular-block-ui.min.js' />"></script>

</head>

<body ng-app="petApp" class="ng-cloak">
	<div class="container" ng-controller="OperationOkController as ctrl">
		<div class="text-center">
			<label>{{ctrl.data.message}}</label> <br /> <br /> <a
				ng-click='ctrl.redirect()'>Back to main page</a>
		</div>
	</div>
	<br />
	<br />
	<br />
	<div class="text-center">Pet Plus Team</div>
	<script src="<core:url value='/js/application.js' />"></script>
	<script src="<core:url value='/js/operationOkController.js' />"></script>

	<script src="<core:url value='/js/lib/jquery.min.js' />"></script>
	<script src="<core:url value='/js/lib/bootstrap.min.js' />"></script>

</body>
</html>

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
	<div class="container-fluid"
		ng-controller="SubscriptionController as ctrl">

		<div class="text-center">
			<form ng-submit="ctrl.subscribe()" name="myForm"
				class="form-horizontal">
				<div class="row"><h1>Pet Plus</h1></div>
				<div class="row"><h3>A new way take care of your pet!</h3></div>
				<div class="row"><h3>We don't just stay with your pet...</h3></div>
				<div class="row"><h3>We bring the concept of agility into your home...</h3></div>
				<div class="row"><h3>Your pet fine... and in shape ;)</h3></div>
				<div class="row"><h3>Subscribe to receive more information!</h3></div>
				<div class="row">
					<div class="col-md-4  col-md-offset-3">
						<input type="email" ng-model="ctrl.subscription.email"
							name="email" class="email form-control input-sm"
							placeholder="Enter your Email" required />

					</div>
					<input type="submit" value="Subscribe"
						class="btn btn-primary btn-sm col-md-2"
						ng-disabled="myForm.$invalid">
				</div>
		</div>
		<br/><br/><br/>
		<div class="text-center">Pet Plus Team</div>
		</form>
	</div>
	</div>

	<script src="<core:url value='/js/application.js' />"></script>
	<script src="<core:url value='/js/subscriptionService.js' />"></script>
	<script src="<core:url value='/js/subscriptionController.js' />"></script>

	<script src="<core:url value='/js/lib/jquery.min.js' />"></script>
	<script src="<core:url value='/js/lib/bootstrap.min.js' />"></script>

</body>
</html>

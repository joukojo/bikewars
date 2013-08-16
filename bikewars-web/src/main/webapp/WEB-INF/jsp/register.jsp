<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="taglibs.jsp"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
</head>
<body>
		<form:form commandName="userModel" cssClass="form-horizontal">
		<form:hidden path="userId" />
		<fieldset>

			<!-- Form Name -->
			<legend>Register</legend>

			<!-- Text input-->
			<div class="control-group">
				<label class="control-label">email address</label>
				<div class="controls">
					<input id="textinput" name="email" placeholder="your.email@server.com" class="input-xlarge" required="required" type="text" />
					<p class="help-block">enter your email address</p>
				</div>
			</div>

			<!-- Password input-->
			<div class="control-group">
				<label class="control-label">Password</label>
				<div class="controls">
					<input id="password" name="password" placeholder="input your password" class="input-xlarge" required="required" type="password" />
					<p class="help-block">enter your password</p>
				</div>
			</div>

			<!-- Password input-->
			<div class="control-group">
				<label class="control-label">Confirm password</label>
				<div class="controls">
					
					<input id="passwordinput" name="confirmedPassword" placeholder="confirm password" class="input-xlarge" required="required" type="password" />
					<p class="help-block">confirm your password</p>
				</div>
			</div>

			<!-- Button (Double) -->
			<div class="control-group">
				<label class="control-label"></label>
				<div class="controls">
					<button id="success" name="button1id" class="btn btn-success">Register</button>
					<button id="cancel" name="button2id" class="btn btn-danger">Cancel</button>
				</div>
			</div>

		</fieldset>
	</form:form>

</body>
</html>
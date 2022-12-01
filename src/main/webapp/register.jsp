<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<div class="container">
	<h1>Register Here</h1>
	<form action="userurl" method="post">
		<input type="hidden" name="action" value="register"/>
		<div class="mb-3">
			<label for="userName" class="form-label">Name </label> 
			<input type="text" class="form-control" id="userName" 
			name="userName" 
			placeholder="Enter Your Full Name" >
		</div>
		<div class="mb-3">
			<label for="userEmail" class="form-label">Email Id </label> 
			<input type="text" class="form-control" id="userEmail" 
			name="userEmail" 
			placeholder="Enter Your Full Name" >
		</div>
		<div class="mb-3">
			<label for="userRole" class="form-label">Role </label> 
			<select name="userRole" id="userRole" class="form-control">
				<option hidden>Select</option>
				<option value="admin">Admin</option>
				<option value="customer">Customer</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="userPassword" class="form-label">Password </label> 
			<input type="password" name="userPassword" class="form-control"
			id="userPassword" placeholder="Enter your password"/>
		</div>
		<input type="submit" class="btn btn-outline-success px-3 py-2 float-end " value="Register"/>
	</form>
</div>
<jsp:include page="footer.jsp"/>
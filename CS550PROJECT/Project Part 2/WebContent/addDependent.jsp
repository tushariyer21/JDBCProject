<%@ page import= "com.project.structure.ProjectsModel"%>
<%@ page import= "java.util.List"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
		<div class="container">
			<a class="navbar-brand" href="#">Employee Management</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/employee?action=get"">List Employee</a>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/logout?action=post">Logout</a></li>
					</li>
				</ul>

			</div>
		</div>
	</nav>

	<main class="my-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Add Dependent</div>
						<div class="card-body">
							<form name="my-form" action="Dependent" method="post">
				                <div class="form-group row">
									<label for="present_address"
										class="col-md-4 col-form-label text-md-right">Dependent Name</label>
									<div class="col-md-6">
										<input type="text" id="dependent_name" class="form-control" name ="dependent_name">
									</div>
								</div>
								
								<div class="form-group row">
									<label for="dob" class="col-md-4 col-form-label text-md-right">Dependent Date
										of birth</label>
									<div class="col-md-6">
										<input type="date" id="d_bdate" class="form-control" name="d_bdate">
									</div>
								</div>
								
								<div class="form-group row">
									<label for="d_sex" class="col-md-4 col-form-label text-md-right">Sex</label>
									<div class="col-md-6">
										<select class="form-control" name="d_sex">
											<option value="M">Male</option>
											<option value="F">Female</option>
										</select>
									</div>
								</div>
								
								<div class="form-group row">
											<label for="present_address"
												class="col-md-4 col-form-label text-md-right">Dependent Relationship</label>
											<div class="col-md-6">
												<input type="text" id="relationship" class="form-control" name ="relationship">
											</div>
										</div>
								
								 <input type="hidden" id="ssn" name="ssn" value="<%=request.getParameter("ssn")%>">
								 
								<div class="col-md-6 offset-md-4">
									<button type="submit" class="btn btn-primary">Add</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
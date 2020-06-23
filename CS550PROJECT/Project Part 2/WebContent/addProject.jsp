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
	<% List<ProjectsModel> listProjects = (List<ProjectsModel>)request.getAttribute("listProjects");%>
	<%int totalHours = (int)request.getAttribute("totalHours"); %>
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
						<div class="card-header">Add Project</div>
						<div class="card-body">
							<%if(totalHours >= 40) {%>
								<h2>Cannot assign project as the employee has reached 40 hours of work</h2>
							<%} else if(listProjects.isEmpty()){%>
								<h2>Cannot assign projects as the Employee is working on all projects</h2>
							<%} else {%>
							<form name="my-form" action="Project" method="post">
								<div class="form-group row">
									<label for="first_name"
										class="col-md-4 col-form-label text-md-right">First
										Name</label>
									<div class="col-md-6">
										<%= listProjects.get(0).getFname() %>
									</div>
								</div>

								<div class="form-group row">
									<label for="last_name"
										class="col-md-4 col-form-label text-md-right">Last
										Name</label>
									<div class="col-md-6">
										<%= listProjects.get(0).getLname() %>
									</div>
								</div>

								<div class="form-group row">
									<label for="present_address"
										class="col-md-4 col-form-label text-md-right">Department</label>
									<div class="col-md-6">
										<%= listProjects.get(0).getDname() %>
									</div>
								</div>
								
								<div class="form-group row">
									<label for="present_address"
										class="col-md-4 col-form-label text-md-right">Hours worked</label>
									<div class="col-md-6">
										<%= totalHours + " hours"%>
									</div>
								</div>

								<div class="form-group row">
									<label for="manager"
										class="col-md-4 col-form-label text-md-right">Project</label>
									<div class="col-md-6">
										<select class="form-control" name="pnumber">
											<%for(ProjectsModel p : listProjects) {	%>
											 <option value="<%=p.getPnumber() %>"><%=p.getPname() %></option>
											<% }%>
										</select>
									</div>
								</div>
								
								
								<div class="form-group row">
									<label for="manager"
										class="col-md-4 col-form-label text-md-right">Hours</label>
									<div class="col-md-6">
										<select class="form-control" name="hours">
											<%for(int i = 1; i <= 40 - totalHours; i++) {	%>
											 <option value="<%=i%>"><%=i%></option>
											<% }%>
										</select>
									</div>
								</div>
								
								 <input type="hidden" id="ssn" name="ssn" value="<%=request.getParameter("ssn")%>">
								 
								<div class="col-md-6 offset-md-4">
									<button type="submit" class="btn btn-primary">Add</button>
								</div>
							</form>
							<%}%>
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
<%@ page import= "com.project.structure.EmployeeStructure"%>
<%@ page import= "com.project.structure.DependentStructure"%>
<%@ page import= "com.project.structure.ProjectStructure"%>
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
	<%
		EmployeeStructure employee = (EmployeeStructure) request.getAttribute("employeeDetails");
	%>
	<%
		List<ProjectStructure> listProjects = (List<ProjectStructure>) request.getAttribute("listProjects");
	%>
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
						<div class="card-header">Employee details</div>
						<div class="card-body">
							<div class="form-group row">
								<label for="first_name"
									class="col-md-4 col-form-label text-md-right">First
									Name</label>
								<div class="col-md-6">
									<%=employee.getFname()%>
								</div>
							</div>

							<div class="form-group row">
								<label for="last_name"
									class="col-md-4 col-form-label text-md-right">Last
									Name</label>
								<div class="col-md-6">
									<%=employee.getLname()%>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="last_name"
									class="col-md-4 col-form-label text-md-right">SSN
									</label>
								<div class="col-md-6">
									<%=employee.getSsn()%>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="last_name"
									class="col-md-4 col-form-label text-md-right">Birth date
									</label>
								<div class="col-md-6">
									<%=employee.getBdate()%>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="present_address"
									class="col-md-4 col-form-label text-md-right">Department</label>
								<div class="col-md-6">
									<%=employee.getDname()%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<br>
		<br>
		
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Dependent details</div>
						<div class="card-body">
							<div class="content_box">
							    <div class="right_bar ">
							        <div class="tab-content ">
									<div class="tab-pane fade show active" id="lorem" role="tabpanel">
									<table class="table table-bordered">
									    <thead>
									      <tr>
									        <th>Dependent Name</th>
									        <th>dependent sex</th>
									        <th>dependent birthday</th>
									        <th>relationship</th>
									      </tr>
									    </thead>
									   
									    <tbody>
									    <%
									    	for(DependentStructure e : employee.getDependent()) {
									    %>
									      <tr>
									        <td><%=e.getDname()%></td>
									        <td><%=e.getSex()%></td>
									        <td><%=e.getBdate()%></td>
									        <td><%=e.getRelationship()%></td>
									      </tr>
									     <%
									     	}
									     %>
									    </tbody>
									 </table>
									 <%
									 	if(employee.getDependent().isEmpty()){
									 %>
									 	<p>No Dependents available </p>   	
									 <%
   										 	}
   										 %>
									</div>
									</div>
							    </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<br>
		<br>
		
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Project details</div>
						<div class="card-body">
							<div class="content_box">
							    <div class="right_bar ">
							        <div class="tab-content ">
									<div class="tab-pane fade show active" id="lorem" role="tabpanel">
									<table class="table table-bordered">
									    <thead>
									      <tr>
									        <th>Project Number</th>
									        <th>Project Name</th>
									        <th>Project Location</th>
									        <th>Department name</th>
									        <th>Number of hours</th>
									      </tr>
									    </thead>
									   
									    <tbody>
									    <%
									    	for(ProjectStructure p : listProjects) {
									    %>
									      <tr>
									        <td><%= p.getPnumber() %></td>
									        <td><%= p.getPname() %></td>
									        <td><%= p.getPlocation() %></td>
									        <td><%= p.getDname() %></td>
									        <td><%= p.getHours() %></td>
									      </tr>
									     <% }%>
									    </tbody>
									 </table>
									  <%if(listProjects.isEmpty()){ %>
									 	<p>No Projects available </p>   	
									 <% }%>
									</div>
									</div>
							    </div>
							 </div>
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
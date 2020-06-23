<%@ page import= "com.project.structure.EmployeeStructure"%>
<%@ page import= "com.project.structure.DependentStructure"%>
<%@ page import= "java.util.List"%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<%
	List<EmployeeStructure> listEmployee = (List<EmployeeStructure>)request.getAttribute("listEmployee");
%>
<head></head>
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
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/login">Add Employee</a>
					<li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
					</li>
				</ul>

			</div>
		</div>
	</nav>
	<div>
		<br><br>
	</div>
	
		<main class="my-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Employee List</div>
						<div class="card-body">
							<div class="content_box">
						    <div class="right_bar ">
						        <div class="tab-content ">
								<div class="tab-pane fade show active" id="lorem" role="tabpanel">
								<table class="table table-bordered">
								    <thead>
								      <tr>
								        <th>First Name</th>
								        <th>Last Name</th>
								        <th>Date of Birth</th>
								        <th>SSN</th>
								        <th>Department</th>
								        <th>Action</th>
								      </tr>
								    </thead>
								   
								    <tbody>
								    <%
								    	for(EmployeeStructure e : listEmployee) {
								    %>
								      <tr>
								        <td><%= e.getFname() %></td>
								        <td><%= e.getLname() %></td>
								        <td><%= e.getBdate() %></td>
								        <td><%= e.getSsn() %></td>
								        <td><%= e.getDname() %></td>
								        <td>
						                    <a href="Dependent?ssn=<%= e.getSsn() %>"  class="btn btn-default">Dependents</a>
						                    &nbsp;&nbsp;&nbsp;&nbsp;
						                    <a href="Project?ssn=<%= e.getSsn() %>"  class="btn btn-default">Projects</a>
						                    &nbsp;&nbsp;&nbsp;&nbsp;
						                    <a href="Report?ssn=<%= e.getSsn() %>"  class="btn btn-default">Report</a>
						                </td>
								      </tr>
								     <% }%>
								    </tbody>
								 </table>
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
</body>


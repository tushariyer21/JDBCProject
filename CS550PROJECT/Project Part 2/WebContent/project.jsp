<%@ page import= "com.project.structure.ProjectStructure"%>
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
	List<ProjectStructure> listProjects = (List<ProjectStructure>)request.getAttribute("listProjects");
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
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/employee?action=get"">List Employee</a>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/Projects?ssn=<%=request.getParameter("ssn")%>">Add Project</a>
					<li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
					</li>
				</ul>

			</div>
		</div>
	</nav>
	<div>
		<br><br>
	</div>
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
</body>



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
	List<DependentStructure> listDependent = (List<DependentStructure>)request.getAttribute("listDependent");
%>
<head>
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
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/employee?action=get">List Employee</a>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/AddDependent?action=get&ssn=<%=request.getParameter("ssn")%>">Add Dependent</a>
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
			        <th>Dependent Name</th>
			        <th>dependent sex</th>
			        <th>dependent birthday</th>
			        <th>relationship</th>
			      </tr>
			    </thead>
			   
			    <tbody>
			    <%
			    	for(DependentStructure e : listDependent) {
			    %>
			      <tr>
			        <td><%= e.getDname() %></td>
			        <td><%= e.getSex() %></td>
			        <td><%= e.getBdate() %></td>
			        <td><%= e.getRelationship() %></td>
			      </tr>
			     <% }%>
			    </tbody>
			 </table>
			 <%if(listDependent.isEmpty()){ %>
			 	<p>No Dependents available </p>   	
			 <% }%>
			</div>
			</div>
	    </div>
	</div>
</body>

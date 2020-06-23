<%@ page import= "com.project.structure.Department"%>
<%@ page import= "com.project.structure.ManagerStructure"%>
<%@ page import= "java.util.List"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles/css/addEmployee.css">
<!------ Include the above in your HEAD tag ---------->

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">



<link rel="icon" href="Favicon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<title>Employee Management</title>
</head>
<body>
	<%
		List<Department> listDepartment = (List<Department>)request.getAttribute("listDepartment");
	%>
	<%
		List<ManagerStructure> listManager = (List<ManagerStructure>)request.getAttribute("listManager");
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
						<div class="card-header">Add Employee</div>
						<div class="card-body">
							<form name="my-form" action="employee" method="post">
								<div class="form-group row">
									<label for="first_name"
										class="col-md-4 col-form-label text-md-right">First
										Name</label>
									<div class="col-md-6">
										<input type="text" id="first_name" class="form-control"
											name="fname" required="required">
									</div>
								</div>

								<div class="form-group row">
									<label for="middle_initial"
										class="col-md-4 col-form-label text-md-right">Middle
										Initial</label>
									<div class="col-md-6">
										<input type="text" id="middle_initial" class="form-control"
											name="minit">
									</div>
								</div>

								<div class="form-group row">
									<label for="last_name"
										class="col-md-4 col-form-label text-md-right">Last
										Name</label>
									<div class="col-md-6">
										<input type="text" id="last_name" class="form-control"
											name="lname" required="required">
									</div>
								</div>

								<div class="form-group row">
									<label for="sex" class="col-md-4 col-form-label text-md-right">Sex</label>
									<div class="col-md-6">
										<select class="form-control" name="sex">
											<option value="M">Male</option>
											<option value="F">Female</option>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label for="dob" class="col-md-4 col-form-label text-md-right">Date
										of birth</label>
									<div class="col-md-6">
										<input type="date" id="dob" class="form-control" name="bdate" required="required">
									</div>
								</div>

								<div class="form-group row">
									<label for="ssn_number"
										class="col-md-4 col-form-label text-md-right"><abbr
										title="Social Security Number">SSN</abbr> Number</label>
									<div class="col-md-6">
										<input type="number" id="ssn_number" class="form-control"
											name="ssn" min="100000000" max="999999999" required="required">
									</div>
								</div>
								
								<div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail Address</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email_address" class="form-control" name="email" required="required">
                                    </div>
                                </div>

								<div class="form-group row">
									<label for="present_address"
										class="col-md-4 col-form-label text-md-right">Present
										Address</label>
									<div class="col-md-6">
										<input type="text" id="present_address" class="form-control" name ="address">
									</div>
								</div>
								
								<div class="panel-group driving-license-settings" id="accordion">
								    <div class="panel panel-default">
								        <div class="form-group row panel-heading">
								        	<label class="col-md-4"></label>
								             <h4 class="col-md-6 panel-title">
									            <div class="checkbox">
									                <label class="col-form-label text-md-right" data-toggle="collapse" data-target="#collapseOne">
									                    <input type="checkbox" id="dependent_checkbox" name="dependent_present" value= "have_dependent" onclick="checkForm()"/> I have Dependent
									                </label>
									            </div>
											</h4>
								        </div>
								        
								        <div id="collapseOne" class="panel-collapse collapse in">
								            <div class="panel-body">
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
												
								            </div>
								        </div>
								    </div>
								</div>
								
								<div class="collapse" id="collapseExample">
									
								</div>

								<div class="form-group row">
									<label for="salary"
										class="col-md-4 col-form-label text-md-right">Salary</label>
									<div class="col-md-6">
										<input type="number" id="salary" class="form-control"
											name="salary" required="required">
									</div>
								</div>

								<div class="form-group row">
									<label for="manager"
										class="col-md-4 col-form-label text-md-right">Manager</label>
									<div class="col-md-6">
										<select class="form-control" name="mgrssn">
											<%
												for(ManagerStructure m : listManager) {
											%>
											 <option value="<%=m.getSsn()%>"><%=m.getFname()%> <%=m.getLname()%></option>
											<% }%>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label for="department"
										class="col-md-4 col-form-label text-md-right">Department</label>
									<div class="col-md-6">
										<select class="form-control" name="dno">
											<%for(Department ld : listDepartment) {	%>
											 <option value="<%=ld.getId()%>"><%=ld.getDname()%></option>
											<% }%>
										</select>
									</div>
								</div>

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
	
	<script>
	  function checkForm(){
	    if(document.getElementById("dependent_checkbox").checked) {
	    	document.getElementById("dependent_name").required = true;
	    	document.getElementById("relationship").required = true;
	    } else {
	    	document.getElementById("dependent_name").required = false;
	    	document.getElementById("relationship").required = false;
	    }
	  }
	</script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
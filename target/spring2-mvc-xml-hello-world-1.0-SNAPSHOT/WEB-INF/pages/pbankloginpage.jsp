<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible"
		  content="ie=edge">
	<title>Blogen Admin Area</title>
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/css/bootstrap.css">
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<%--<a href="/ssl-login.html">This is Link</a>
<h2>${msg}</h2>--%>

<!--HEADER-->
<header id="main-header" class="py-2 bg-primary text-white mb-3">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1><i class="fa fa-user"></i>PBank</h1>
			</div>
		</div>
	</div>
</header>

<!--ACTIONS-->
<selection id="action" class="py-4  bg-light">
	<div class="container mb-4">
		<div class="row">
		</div>
	</div>
</selection>
<!--LOGIN-->
<section id="posts">
	<div class="container">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<div class="card">
					<div class="card-header">
						<h4>ALTITUDE Login</h4>
					</div>

					<div class="card-body">
						<form action="/success">

							<div class="form-group">
								<label for="userName">Login ID</label>
								<input type="password" id="userName" class="form-control">
							</div>

							<div class="form-group">
								<label for="password">Enter Password</label>
								<input type="password" id="password" name="password" class="form-control">
							</div>
							<input type="hidden" id="productPrice" name="productPrice" class="form-control" value="10">
							<input type="submit" class="btn btn-primary btn-block" value="Login">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--FOOTER-->
<footer id="main-footer" class="bg-dark text-white mt-5 p-5">
	<div class="container">
		<div class="row">
			<div class="col">
				<p class="lead text-center">
					Copyright &COPY; 2020 Blogen
				</p>
			</div>
		</div>
	</div>
</footer>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/jslib/navbar-fixed.js"></script>
</body>
</html>
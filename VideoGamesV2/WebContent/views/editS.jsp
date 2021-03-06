<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
	
  <title>VideoGames Stadia</title>

  <!-- Bootstrap core CSS -->
  <link href="https://augustobrigadaw.000webhostapp.com/resources2/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="https://augustobrigadaw.000webhostapp.com/resources2/css/shop-homepage.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">CodeLupo</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../VideoGamesV2/SociosInicio">Socios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../VideoGamesV2/Prestamos">Prestamos</a>
          </li>
          

        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">
  <br />

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Stadia</h1>
        <!-- Aqui las vainas de a�adir -->
	 
      </div>

        <div class="row">
        <form action="../VideoGamesV2/EditarFS" method="POST">
        <table>
        	<tr>
          		<td>&nbsp</td>
          		<td>NOMBRE &nbsp</td>
          		<td>APELLIDOS &nbsp</td>
          		<td>CUENTA &nbsp</td>         							
          	</tr>
		<c:forEach items="${socios}" var="v" varStatus="status">

	      	<tr>
	        	<td><input type="hidden" name="dni" value="${v.dni}"/>&nbsp</td>
	          	<td><input type="text" name="name" value="${v.name}" />&nbsp</td>
	          	<td><input type="text" name="surname" value="${v.surname}" />&nbsp</td>
	          	<td><input type="text" name="cuenta" value="${v.cuenta}" />&nbsp</td>
	          	<td><input type="submit" class="btn btn-success" value="Editar"></td>

	      	</tr>

        </c:forEach>

		</table>
          </form>
          </div>
		</div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->


  <!-- Bootstrap core JavaScript -->
  <script src="https://augustobrigadaw.000webhostapp.com/resources2/vendor/jquery/jquery.min.js"></script>
  <script src="https://augustobrigadaw.000webhostapp.com/resources2/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
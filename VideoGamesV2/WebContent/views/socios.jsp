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
            <a class="nav-link" href="../VideoGamesV2/inicio">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="socios.jsp">Socios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
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
        <table>
        	<tr>
          		<td>ID &nbsp</td>
          		<td>NOMBRE &nbsp</td>
          		<td>GENERO &nbsp</td>         							
          	</tr>
		<c:forEach items="${socios}" var="v" varStatus="status">

	      	<tr>
	        	<td>${v.dni}&nbsp</td>
	          	<td>${v.name}&nbsp</td>
	          	<td>${v.surname}&nbsp</td>
	          	<td>${v.cuenta}&nbsp</td>
	          	<td><a href = "<c:url value = "../VideoGamesV2/prestar?id=${v.dni}"/>" class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>Prestar</a>&nbsp</td>
				<td><a href = "<c:url value = "../VideoGamesV2/eliminar?id=${v.dni}"/>" class="btn btn-danger"><i class="glyphicon glyphicon-edit"></i>Danger</a></td>	
					
	      	</tr>

        </c:forEach>
		</table>
          
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

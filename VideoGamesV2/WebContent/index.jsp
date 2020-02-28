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
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="login">Login</a>
          </li>

        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Stadia</h1>
        <div class="list-group">
                <a href="/Fruteria/lista/0" class="list-group-item">inicio</a>
           <a href="../buscarCategoria/Fruta" class="list-group-item">Shooters</a>
          <a href="../buscarCategoria/Hortaliza" class="list-group-item">Estrategia </a>
          <a href="../buscarCategoria/Legumbre" class="list-group-item">Rol </a>
        </div>
	 <!-- paginación -->

           <c:set var="ind" value="0" scope="page" />
           <c:set var="ind2" value="0" scope="page" />
	       <c:forEach items="${listaVegetales}" var="item" varStatus="status2">
         
           <c:if test="${status2.index %6 == 0}">
          
              <a href="/Fruteria/lista/${ind}">${ind+1}</a> 
              <c:set var="ind" value="${ind + 1}" scope="page"/>
              <c:set var="ind2" value="0" scope="page"/>
          </c:if>
          <c:set var="ind2" value="${ind2 + 1}" scope="page"/>
       </c:forEach>
       <!-- fin paginación -->
      </div>
      
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
        <div id="carouselExampleIndicators" 
        class="carousel slide my-4" data-ride="carousel" data-interval="1000">
          <ol class="carousel-indicators">
          <c:forEach items="${listaCarousel}" var="v" varStatus="status">
          	<c:if test="${status.index==0}">
          		<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          	</c:if>
            <c:if test="${status.index>0}">
            	<li data-target="#carouselExampleIndicators" data-slide-to="${status.index}"></li>
            </c:if>
          
           </c:forEach>
          </ol>
          <div class="carousel-inner" role="listbox">
          <c:forEach items="${listaCarousel}" var="v" varStatus="status">
          	
          	<c:if test="${status.index==0}">
	          	<div class="carousel-item active">
	              	<img class="d-block img-fluid" src="${v.imagen}" alt="First slide">
	            </div>
          	</c:if>

          	<c:if test="${status.index>0}">
	          	<div class="carousel-item">
	              <img class="d-block img-fluid" src="${v.imagen}" alt="Second slide">
	            </div>
          	</c:if>
          </c:forEach>
       
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
		<c:forEach items="${listaVegetal}" var="v">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="${urlPublic}/img/${v.imagen}" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="/Fruteria/carritoVegetal/${v.id}">${v.nombre}</a>
                </h4>
                <h4 class="card-title">
                  ${v.categoria}
                </h4>
                <h5 class="card-title">
                  ${v.procedencia}
                </h5>
                <h5>${v.precio}$</h5>
                <p class="card-text"></p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
          </c:forEach>

          
          
          </div>
		</div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="https://augustobrigadaw.000webhostapp.com/resources2/vendor/jquery/jquery.min.js"></script>
  <script src="https://augustobrigadaw.000webhostapp.com/resources2/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>


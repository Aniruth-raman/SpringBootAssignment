<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <title>User Dashboard</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
      <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
      <jsp:include page="header.jsp" />
      <!--  http://localhost:8080/SpringMVCDemo/greet  -->
      <div class="container">
        <h1>Welcome ${sessionScope.username }</h1>
      </div>
      <div class="container">
        <jsp:include page="booksList.jsp" />
      </div>
      <div class="container">
        <h1>Search Books</h1>

        <!-- Search by Author -->
        <form action="${pageContext.request.contextPath}/books/search/author" method="GET">
          <label for="author">Search by Author:</label>
          <input type="text" id="author" name="author" />
          <button type="submit">Search</button>
        </form>

        <!-- Search by Title -->
        <form action="${pageContext.request.contextPath}/books/search/title" method="GET">
          <label for="title">Search by Title:</label>
          <input type="text" id="title" name="title" />
          <button type="submit">Search</button>
        </form>

        <!-- Search by Publication -->
        <form action="${pageContext.request.contextPath}/books/search/publication" method="GET">
          <label for="publication">Search by Publication:</label>
          <input type="text" id="publication" name="publication" />
          <button type="submit">Search</button>
        </form>

        <!-- Search by ID -->
        <form action="${pageContext.request.contextPath}/books/search/id" method="GET">
          <label for="id">Search by ID:</label>
          <input type="text" id="id" name="id" />
          <button type="submit">Search</button>
        </form>

        <!-- Search by Price Range -->
        <form action="${pageContext.request.contextPath}/books/search/priceRange" method="GET">
          <label for="minPrice">Min Price:</label>
          <input type="number" id="minPrice" name="minPrice" />
          <label for="maxPrice">Max Price:</label>
          <input type="number" id="maxPrice" name="maxPrice" />
          <button type="submit">Search</button>
        </form>

        <!-- Sort by Price -->
        <form action="${pageContext.request.contextPath}/books/sortByPriceASC" method="GET">
          <button type="submit">Sort by Price Ascending</button>
        </form>
      </div>
      <div class="container">
        <jsp:include page="add-to-favourites.jsp" />
      </div>
      <div class="container">
        <jsp:include page="read-later.jsp" />
      </div>
    </body>

    </html>
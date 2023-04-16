<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8" />
    <title>Magic Of Book - User</title>
  </head>

  <body>
    <h1>Magic Of Book - User</h1>

    <form action="${pageContext.request.contextPath}/api/user/login" method="post">
      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required />

      <label for="password">Password:</label>
      <input type="password" name="password" id="password" required />

      <button type="submit">Login</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/logout" method="post">
      <button type="submit">Logout</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/register" method="post">
      <label for="name">Name:</label>
      <input type="text" name="name" id="name" required />

      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required />

      <label for="password">Password:</label>
      <input type="password" name="password" id="password" required />

      <button type="submit">Register</button>
    </form>

    <h2>List of Books</h2>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Author</th>
          <th>Publication</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${books}" var="book">
          <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publication}</td>
            <td>${book.price}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <form action="${pageContext.request.contextPath}/api/user/books/author" method="get">
      <label for="authorName">Search by Author Name:</label>
      <input type="text" name="authorName" id="authorName" required />

      <button type="submit">Search</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/books/title" method="get">
      <label for="titleName">Search by Title Name:</label>
      <input type="text" name="titleName" id="titleName" required />

      <button type="submit">Search</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/books/publication" method="get">
      <label for="publicationName">Search by Publication Name:</label>
      <input type="text" name="publicationName" id="publicationName" required />

      <button type="submit">Search</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/books/id" method="get">
      <label for="bookId">Search by Book ID:</label>
      <input type="text" name="bookId" id="bookId" required />

      <button type="submit">Search</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/books/price" method="get">
      <label for="minPrice">Minimum Price:</label>
      <input type="number" name="minPrice" id="minPrice" required />

      <label for="maxPrice">Maximum Price:</label>
      <input type="number" name="maxPrice" id="maxPrice" required />

      <button type="submit">Search</button>
    </form>

    <form action="${pageContext.request.contextPath}/api/user/books/sort/price" method="get">
      <button type="submit">Sort by Price</button>
    </form>

    <h2>Favorites</h2>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Author</th>
          <th>Publication</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${favorites}" var="book">
          <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publication}</td>
            <td>${book.price}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <form action="${pageContext.request.contextPath}/api/user/favorites/add" method="post">
      <label for="bookId">Add to Favorites:</label>
      <input type="text" name="bookId" id="bookId" required />

      <button type="submit">Add</button>
    </form>

    <h2>Read Later</h2>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Author</th>
          <th>Publication</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${readLater}" var="book">
          <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publication}</td>
            <td>${book.price}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <form action="${pageContext.request.contextPath}/api/user/read-later/add" method="post">
      <label for="bookId">Add to Read Later:</label>
      <input type="text" name="bookId" id="bookId" required />

      <button type="submit">Add</button>
    </form>
  </body>

  </html>
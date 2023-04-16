<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>List of Books!</h1>
<table>
  <thead>
    <tr>
      <th>ID</th>
      <th>Title</th>
      <th>Author</th>
      <th>Publication</th>
      <th>Price</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${books}" var="book">
      <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.authorName}</td>
        <td>${book.publication}</td>
        <td>${book.price}</td>
        <c:choose>
          <c:when test="${sessionScope.admin != null}">
            <td>
              <form action="${pageContext.request.contextPath}/admin/book/edit/${book.id}" method="get">
                <button>Edit</button>
              </form>
              <form action="${pageContext.request.contextPath}/admin/book/delete/${book.id}" method="post">
                <input type="hidden" name="_method" value="DELETE" />
                <button>Delete</button>
              </form>
            </td>
          </c:when>
          <c:when test="${sessionScope.admin == null}">
            <td>
              <c:choose>
                <c:when test="${favourites.contains(book)}">
                  <button disabled="disabled">Added to Favourites</button>
                </c:when>
                <c:otherwise>
                  <form action="${pageContext.request.contextPath}/books/add-to-favorites/${book.id}" method="post">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <button type="submit">Add to Favourites</button>
                  </form>
                </c:otherwise>
              </c:choose>
              <c:choose>
                <c:when test="${readlater.contains(book)}">
                  <button disabled="disabled">Read Later</button>
                </c:when>
                <c:otherwise>
                  <form action="${pageContext.request.contextPath}/books/read-later/${book.id}" method="post">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <button type="submit">Read Later</button>
                  </form>
                </c:otherwise>
              </c:choose>
            </td>
          </c:when>
        </c:choose>
      </tr>
    </c:forEach>
  </tbody>
</table>
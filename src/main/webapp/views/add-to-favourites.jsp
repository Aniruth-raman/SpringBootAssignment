<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h1>User Favourites!</h1>
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
        <c:forEach items="${favourites}" var="book">
          <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.authorName}</td>
            <td>${book.publication}</td>
            <td>${book.price}</td>
            <c:choose>
              <c:when test="$${not empty sessionScope.admin}">
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
              <c:otherwise>
                <td>
                  <form action="${pageContext.request.contextPath}/books/remove-from-favorites/${book.id}"
                    method="post">
                    <button>Remove from Favourites</button>
                  </form>
                </td>
              </c:otherwise>
            </c:choose>
          </tr>
        </c:forEach>
      </tbody>
    </table>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h1>Search List of Books!</h1>
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
            <td>${book.authorName}</td>
            <td>${book.publication}</td>
            <td>${book.price}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
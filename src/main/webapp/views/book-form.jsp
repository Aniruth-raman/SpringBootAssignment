<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Add/Update Book</title>
            </head>

            <body>

                <h1>Add/Update Book</h1>

                <form:form method="post" action="${pageContext.request.contextPath}/admin/book/save"
                    modelAttribute="Book">
                    <c:choose>
                        <c:when test="${Book.id != 0}">
                            <label for="id">ID:</label>
                            <form:input path="id" id="id" readonly="true" value="${Book.id}" />
                        </c:when>
                        <c:otherwise>
                            <form:hidden path="id" />
                        </c:otherwise>
                    </c:choose>

                    <label for="title">Title:</label>
                    <form:input path="title" id="title" required="" value="${Book.title}" />

                    <label for="authorName">Author Name:</label>
                    <form:input path="authorName" id="authorName" required="" value="${Book.authorName}" />

                    <label for="publication">Publication:</label>
                    <form:input path="publication" id="publication" required="" value="${Book.publication}" />

                    <label for="price">Price:</label>
                    <form:input path="price" id="price" required="" value="${Book.price}" />

                    <label for="imageUrl">Image URL:</label>
                    <form:input path="imageUrl" id="imageUrl" value="${Book.imageUrl}" />

                    <label for="description">Description:</label>
                    <form:textarea path="description" id="description" value="${Book.description}" />

                    <button type="submit">Save</button>
                </form:form>

            </body>

            </html>
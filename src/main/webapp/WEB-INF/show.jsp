<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Example</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
    <h1>Books Details about ${showBook.title}</h1>

    <p>Description:
        <c:out value="${showBook.description}" />
    </p>
    <p>Language:
        <c:out value="${showBook.language}" />
    </p>
    <p>Number of pages:
        <c:out value="${showBook.numberOfPages}" />
    </p>
    <a href="/books/${showBook.id}/edit">Edit Book</a> | <a href="/books/${showBook.id}/delete">Delete Book</a>
    <!-- <form action="/books/${show.Book.id}/delete" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form> -->

</body>

</html>
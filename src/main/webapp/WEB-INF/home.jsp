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
    <div class="container">
        <h1>Hello World!</h1>
        <h3>${book.title}</h3>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                    <th scope="col">Language</th>
                    <th scope="col">Pages</th>
                    <th scope="col">Actions</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allBooks }' var='book'>
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.description}</td>
                        <td>${book.language}</td>
                        <td>${book.numberOfPages}</td>
                        <td><a href="/books/${book.id}">View Details</a>| <a href="/books/${book.id}/edit">Edit</a> | <a
                                href="/books/${book.id}/delete">Delete</a></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
        <a href="/books/new">New Book</a>
    </div>
</body>

</html>
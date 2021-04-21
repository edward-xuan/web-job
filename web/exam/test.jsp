<%--
  Created by IntelliJ IDEA.
  User: lgq
  Date: 2021/4/21
  Time: 下午3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="#">
    <c:forEach items="${exams}" var="exams">
        <h1>题${exams.id}</h1>
        <p>${exams.question}</p>
        <p>${exams.options}</p>
        <p>${exams.answer}</p>
        <select name="${exams.id}">
            <option value ="A">A</option>
            <option value ="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
        </select>
    </c:forEach>

    <input type="submit" value="提交">
</form>

</body>
</html>

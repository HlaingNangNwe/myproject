<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="com.nang.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Success</title>
</head>
<body>
<h1>Select Test  Success</h1>
  Select Clinic
    <select name="clinic">
        <c:forEach items="${cList}" var="c">
            <option value="${c.cid}">${c.cname}</option>
        </c:forEach>
    </select>
			
</body>
</html>
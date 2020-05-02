<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="index.jsp" %> 
   <%@ page import="com.nang.controller.*" %>
   <%@ page import="com.nang.model.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<body>
<form action="AppointmentServlet">
Date<%= new java.util.Date() %><br><br>
 Time<input type="time" name="time"><br><br>
 Select Patient
    <select name="Patient">
        <c:forEach items="${patientList}" var="p">
            <option value="${p.id}">${p.name}</option>
        </c:forEach>
    </select>
    Select Clinic
    <select name="clinic">
        <c:forEach items="${cList}" var="c">
            <option value="${c.cid}">${c.cname}</option>
        </c:forEach>
    </select>
    <br/><br/>
	<input type="submit" value="Submit" />
</form>

</body>
</body>
</html>
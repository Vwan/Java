<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="login">
<!--<s:textfield name="user.username" label="username"/>
<s:password name="user.password" label="password"/>-->
<s:textfield name="users["one"].username" label="username"/>
<s:password name="user["one"].password" label="password"/>
<s:submit name="login"/>
</s:form>
</body>
</html>
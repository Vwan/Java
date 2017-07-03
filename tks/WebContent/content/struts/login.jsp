<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="WebContent/js/loginregister.js"></script>
</head>
<body>
<s:form action="login" validate="false">
<s:textfield name="user.UserName" label="username"/>
<s:password name="user.Password" label="password"/>
<s:submit name="login" value="login"/>
</s:form>
</body>
</html>
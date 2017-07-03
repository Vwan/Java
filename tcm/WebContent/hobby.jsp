<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hp.data.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String hobby; %>
The friends who share the same hobby of 
<%=hobby=request.getParameter("hobby") %> are:
<%= request.getAttribute("friends") %>

<%
//out.println(hobby);
	List<String> friends = new Friends().getFriends(hobby);
	for(String f:friends){
		out.println(f);
	}
	
%>

</body>
</html>
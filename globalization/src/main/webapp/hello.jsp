<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Hello JSP Include</title>
</head>
<body>
<font size="20">
	We are going to REUSE some existing JSP now<br>
	
<%--	**********************************************<br>
	Directive Include:The include directive does the include at transla­tion time, only once.<br>
	<%@ include file="DirectiveInclude.jsp" %><br>
	This should be displayed After Directive Include<br>
--%>

	
<%--	**********************************************<br>
	Action Include: the response of the included page into the original page at runtime.<br>
	<jsp:include page="ActionInclude.jsp" flush="false">
		<jsp:param name="action" value="action include"/>
	</jsp:include>
	<br>
	This should be displayed After Action Include<br>
 --%>	

<%--
 **********************************************<br>
	Action Forward:<br>
	<jsp:forward page="ActionForward.jsp">
		<jsp:param name="action" value="action forward"/>
	</jsp:forward>
	<br>
	This should be displayed After Action Include<br>
	**********************************************<br>
 --%>
 
<%--
	**********************************************<br>
	<%@ taglib prefix="c" tagdir="/WEB-INF/tags" %>
	<c:mytag>
	    <h1>Hello World</h1>
	</c:mytag>
	**********************************************<br>
--%>


	**********************************************<br>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:import url="http://www.bing.com" />
	**********************************************<br>

 </font>
</body>
</html>
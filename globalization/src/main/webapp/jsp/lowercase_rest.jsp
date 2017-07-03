    <!--pageEncoding="UTF-8"
    the turkey character is lower cased properly if without this line
    -->
<%@ page language="java"  contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.*,com.g11n.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form method="POST" action="/globalization/lowercase">
<jsp:useBean id="lang" class="com.g11n.bean.Locales" scope="page"/>
<!--<%lang.getLang();%>-->
    Source: <input name="source" value="A  B  C  Ç  D  E  F  G  Ğ  H  J  K  L  M  N  O  Ö  P  R  S  Ş  T  U  Ü  V  Y  Z  İ I"></input>
    Locale: <select name="lang" >
    ${lang.lang.size()}
        <c:forEach var="item" items="${lang.lang}">
            <option value="${item}">tr_TR</option><!--${item}</option>-->
        </c:forEach>
    </select>
    <input name="submit" type="SUBMIT" value="Convert to LowerCase"/>
</form>
    The lower case result is:</br>
    <pre>Source:<b><%=request.getParameter("source") %></pre></b>
    <pre>Target:<b>${lowercase}</pre></b> <!-- get attribute via EL --><!-- <%=request.getAttribute("lowercase") %>  get attribute via java expression-->

</body>
</html>
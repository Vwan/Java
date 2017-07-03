<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
            <s:form action="createProduct" method="post">
                <s:textfield name="product.name" label="name"/>
                 <s:textfield name="product.desc" label="desc"/>
                   <s:submit value="Add"></s:submit>

            </s:form>

  </body>
    </html>
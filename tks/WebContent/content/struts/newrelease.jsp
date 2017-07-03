<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
            <s:form action="createRelease" method="post">
                <s:textfield name="release.name" label="name"/>
                 <s:textfield name="release.desc" label="desc"/>
               <s:textfield name="release.product.name" label="product"/>
               <s:textfield name="release.language.langCode" label="langCode"/>

                   <s:submit value="Add"></s:submit>
            </s:form>

  </body>
    </html>
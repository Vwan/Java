<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
            <s:form action="createLanguage" method="post">
                <s:textfield name="language.langCode" label="langCode"/>
                 <s:textfield name="language.langName" label="langName"/>
                   <s:submit value="Add"></s:submit>

            </s:form>

  </body>
    </html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
            <s:form action="deleteTask" method="post">
                <s:textfield name="task.Summary" label="summary"/>
                 <s:textfield name="task.Description" label="description"/>
               <s:textfield name="task.status.name" label="status"/>
                   <s:submit value="Add"></s:submit>
            </s:form>

  </body>
    </html>
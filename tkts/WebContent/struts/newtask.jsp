<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TKTS</title>
    <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
            <s:form role="form" action="createTask" method="post">
            <div class="form-group">
               <label for="name">Summary: </label> <s:textfield name="task.Summary" class="form-control" placeholder="Enter a task summary"/></br>
               <label for="name">Description: </label>  <s:textfield name="task.Description" label="description"  class="form-control"  placeholder="Enter task description"> </s:textfield>
               <label for="name">Status: </label><s:textfield name="task.status.name" label="status" class="form-control"  ></s:textfield>
               <label for="name">Release: </label><s:textfield name="task.release.name" label="Release" class="form-control" ></s:textfield>
           <!--    <label for="name">Languages: </label><s:textfield name="task.release.name" label="Languages" class="form-control" ></s:textfield>
               <select multiple class="form-control">
                           <option>CN</option>
                           <option>FR</option>
                       </select>
                       -->
               <s:submit value="Add" class="form-control" ></s:submit>
               </div>
            </s:form>


  </body>
    </html>
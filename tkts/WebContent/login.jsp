<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>

    <title>Insert title here</title>
</head>
<body>
<div class="vertical-center">
    <div class="container">
        <div class="col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" id="logindev">

            <form id="newTask" role="form" class="form-horizontal" method="post" action="login">
                <div class="form-group">
                <label class="col-sm-2 control-label" for="name">User Name:</label>
                <div class="col-sm-6">
                    <input name="user.name" type="text" class="form-control" placeholder="Enter a name" required="">
                </div>

                <label class="col-sm-2 control-label" for="password" >Password: </label>
                <div class="col-sm-6">
                    <input name="user.password" type="text" class="form-control" placeholder="Enter a password" required="">
                </div>
                <div class="col-sm-10">
                    <input type="submit" value="Login" class="btn btn-primary btn-sm" data-loading-text="Adding..." ></input>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
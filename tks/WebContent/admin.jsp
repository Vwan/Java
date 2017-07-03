    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page pageEncoding="UTF-8" %>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
        <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags
        -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>TKS</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/jquery-ui.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/customize.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/dataTables.jqueryui.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <!-- <link href="dashboard.css" rel="stylesheet">-->
        </head>
<body>
        <div class="page-header-fixed">

        <!-- Start Header Bar -->
        <div id="header">
        <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" href="/tks/index.jsp">TKS</a>
            </div>
            <!-- Start Section for right side Logout and Settings, Search -->
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
                </form>
                <li><a href="#"></span> Logout</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Setting</a></li>
            </ul>
            <!-- End Section for right side Logout and Settings, Search -->
        <div id="navbar">
        <!-- <nav class="nav navbar-nav pull-xs-left">-->
            <h5>
                <!-- Start Product List to select -->
                <ul class="navbar-nav nav">

              <!--      <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Product <b class="caret"></b></a>
                     <ul class="dropdown-menu multi-level">
                    <li id ="product-list" class="dropdown-menu multi-level">
                    <li><a href="/tks/content/user/user.jsp">User</a></li>
                     </ul>
                    </li>
-->
                <!-- End Product List to select -->
                <!-- start Admin List to select -->
                <li class="dropdown">
                     <a href="#" id="admin-panel-left" class="dropdown-toggle" data-toggle="dropdown">Administration
                     <b class="caret"></b>
                    </a>
                   <ul class="dropdown-menu multi-level">
                    <li><a href="#" class="user-li">User</a></li>
                    <li class="divider"></li>
                    <li><a href="#" class="product-li" >Product</a></li>
                    <li><a href="#" class="release-li">Release</a></li>
                    <li><a href="#" class="lang-li">Languages</a></li>
                    <li class="divider"></li>
                        <!-- Task Status -->
                    <li class="span2"><a href="#" class="taskstatus-li">Task Status</a>
                        <ul class="dropdown-menu">
                        <li class="span2"><a href="#">Task Status</a></li>
                        </ul>
                    </li>
                </ul>
                </li>
                <!-- End Admin List to select -->
                <li><a href="#">Dashboard</a></li>
        </ul>
            </h5>
        </div>
        </div>
        </nav>
        </div>
        <!--<button type="button" class="navbar-toggler hidden-sm-up" data-toggle="collapse" data-target="#navbar"
        aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
            </button>-->
        </div>

        <!-- End Header Bar-->

        <div class="container-fluid" id="left-panel">
        <div class="row">
        <!-- Start Left Side Bar-->
        <h5 class="text-success">
            <div class="col-md-2 sidebar">
                <ul id="left-panel-ul" class="nav nav-sidebar">
                <li class="active"><a href="#" class="user-li">User <span class="sr-only">(current)</span></a></li>
                <li><a href="#" class="product-li">Product</a></li>
                <li><a href="#" class="release-li">Release</a></li>
                <li><a href="#" class="lang-li">Languages</a></li>
                <li><a href="#" class="taskstatus-li">Task Status</a></li>
                </ul>
            </div>

            <!-- End Left Side Bar-->

            <!-- Start Right Side Section -->
             <div class="col-md-10" id="right-panel">

            </div>
        </h5>
        </div>
        </div>
        </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/tks/actionHandler.js"></script>
        <script text="text/javascript">
        var table;
        $(document).ready(
            <!-- Load Header -->
            //function(){$('#header').load("content/header.html");},
        $("#right-panel").load("/tks/content/user/user.jsp")

        )
        <!-- load product management page when clicking Admin->Product-->
        $(".product-li").click(function(){
        $("#right-panel").load("/tks/content/product/product.jsp");
        }
        )
        <!-- load release management page when clicking Admin->Product-->
        $(".release-li").click(function(){
        $("#right-panel").load("/tks/content/release/release.jsp");
        }
        )
        <!-- load user management page when clicking Admin->Product-->
        $(".user-li").click(function(){
        $("#right-panel").load("/tks/content/user/user.jsp");
        }
        )
        <!-- load lang management page when clicking Admin->Product-->
        $(".lang-li").click(function(){
        $("#right-panel").load("/tks/content/lang/lang.jsp");
        }
        )
        <!-- load task status management page when clicking Admin->Product-->
        $(".taskstatus-li").click(function(){
        $("#right-panel").load("/tks/content/taskStatus/taskStatus.jsp");
        }
        )

        <!-- $(document).ready(function(){ $('#task-form').load("content/task/task-form-new.html"); });-->
        <!-- Invoke modal -->
        $("#new").click(function () {
        $(".modal-view").dialog({modal:true});
        });
        <!-- New Task -->
        $(function(){
        $("#task_form").submit(
        function() {
        var formInput=$(this).serialize();
        console.log( formInput );
        $.getJSON('/tks/task/create.action', formInput,function(data) {
        $('#statusID').text(''+data.entity.id + '');
        $('#statusName').text(''+data.entity.name + '');
        $('#statusDescription').text(''+data.entity.description + '');
        });
        return false;
        }

        );
        <!-- $(function () { window.close();});-->
        });


        </script>
        </body>
        </html>

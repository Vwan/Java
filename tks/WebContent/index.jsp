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

    <link type="text/css" href="<%=request.getContextPath() %>/css/jquery.multiselect.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/select.dataTables.min.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/buttons.dataTables.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <!-- <link href="dashboard.css" rel="stylesheet">-->
        </head>
<body>

        <div class="container-fluid">
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
                <li ><a href="#"></span> Logout</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Setting</a></li>
            </ul>
            <!-- End Section for right side Logout and Settings, Search -->
        <div id="navbar">
        <!-- <nav class="nav navbar-nav pull-xs-left">-->
            <h4>
                <!-- Start Product List to select -->
                <div class="navbar-nav nav">
                    <li><a href="/tks/admin.jsp">Administration</a></li>
                    <!-- End Admin List to select -->
                    <li><a href="#">Dashbaord</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Product <b class="caret"></b></a>
                        <ul id="product-list" class="dropdown-menu multi-level"/>
                    </li>
                    <!-- End Product List to select -->
                    <!-- start Admin List to select -->


        </li>
        </div>
            </h4>
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


       <!-- <ul class="container-fluid" id="left-panel">-->
        <div class="container-fluid">
        <!-- Start Left Side Bar-->
            <div class="row">
           <!-- <li class="col-sm-3 col-md-2 sidebar">-->

            <div class="col-md-2" id="left-panel">
                <ul id="left-panel-ul" class="nav nav-sidebar">
<h5>
                    <li>
                        <a href="#release-list" class="nav-sidebar collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-list"></i>
                        Releases
                        <div class="pull-right glyphicon glyphicon-chevron-down"></div>
                        </a>
                        <ul id="release-list" class="nav nav-list collapse in secondmenu" style="height: 0px;">
                        </ul>
                        </li>
        </h5>
      <!--  <li><a href="#">Reports</a></li>
        <li><a href="#">Analytics</a></li>
        <li><a href="#">Export</a></li>-->
                </ul>
        </div>
        <!-- End Left Side Bar-->

        <!-- Start Right Side Section -->
        <!-- Start Overview section -->
        <div class="col-md-10" id="right-panel">
        <div class="panel panel-success">
        <div class="panel-heading">
        <h5 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion"
        href="#collapse_overview">
        <h5>Overview</h5>
        </a>
        </h5>
        </div>
        <div id="collapse_overview" class="panel-collapse collapse">
        <div class="panel-body">
        <div class="row placeholders">
        <div class="col-xs-6 col-sm-3 placeholder">
        <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200"
        height="200" class="img-fluid" alt="Generic placeholder thumbnail">
        <h5>Label</h5>
        <span class="text-muted">Something else</span>
        </div>
        <div class="col-xs-6 col-sm-3 placeholder">
        <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200"
        height="200" class="img-fluid" alt="Generic placeholder thumbnail">
        <h5>Label</h5>
        <span class="text-muted">Something else</span>
        </div>
        </div>
        </div>
        </div>
        </div>
        <!-- End Overview Section -->
        <!-- Start All Tasks Section -->
        <div class="panel panel-success">
        <div class="panel-heading">
        <h5 class="panel-title">

        <a data-toggle="collapse" data-parent="#accordion"
        href="#collapse_alltasks">
        <div class="row">

            <div class="col col-xs-6 text-left">
            <h5>All Tasks</h5>
            </div>

            <div class="col col-xs-6 text-right">
            <a id="btnNew" href="#new-entity-modal" role="button" class="btn" data-toggle="modal" title="Click to add more"><i class="glyphicon glyphicon-plus-sign"></i></a>
            <a id="btnEdit" href="#edit-entity-modal" role="button" class="btn" data-toggle="modal" title="Click to edit selected row"><i class="glyphicon glyphicon-edit"></i></a>
            <a id="btnDelete" href="#confirmDeleteModal" role="button" class="btn" ><i class="glyphicon glyphicon-trash"></i></a>
             <a id="btnRefreshTasks" role="button" class="btn" ><i class="glyphicon glyphicon-refresh"></i></a>

        </div>
        </div>
        </a>
        </h5>
        </div>
        <div id="collapse_alltasks" class="panel-collapse collapse in">
        <div class="panel-body">
        <!-- Task DataTable -->
        <div class="table-responsive">
        <!-- <table class="table table-striped table-hover table-responsive">-->
        <table id="list" class="table table-striped table-bordered table-list" data-toggle="table" data-click-to-select="true" data-select-item-name="radioName">
        <thead>
        <tr>
        <th></th>
        <th></th>
        <th class="hidden-xs"></th>
        <th>ID</th>
        <th>Summary</th>
        <th>Description</th>
        <th>Status</th>
        <th>Release</th>
        <th class="hidden-xs">Owner</th>
        <th>Languages</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
        <th></th>
        <th></th>
        <th class="hidden-xs"></th>
        <th>ID</th>
        <th>Summary</th>
        <th>Description</th>
        <th>Status</th>
        <th>Release</th>
        <th class="hidden-xs">Owner</th>
        <th>Languages</th>
        </tr>
        </tfoot>
        </table>
        </div>
        <!-- end All Tasks section -->
        </div>
        </div>
        </div>

        </div>
        </div>

        </div>
        <!-- End Right Panel Section -->

        <!-- Start New Modal for Task Progress -->
        <div id="modal-view" class="modal-view-add">

        <div class="modal fade" id="new-progress-modal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true"        xmlns="http://www.w3.org/1999/html">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" >Task Progress</h4>
        </div>
        <form id="new-progress-form" role="form" class="form-horizontal" method="post">
        <div class="modal-body">
        <!-- Text input-->
        <div class="form-group">
        <label class="col-md-4 control-label" for="details">Task ID</label>
        <div class="col-md-4">
        <input id="task.id" name="task.id" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">Task ID</span>
        </div>
        </div>
        <!-- Text input-->
        <div class="form-group">
        <label class="col-md-4 control-label" for="details">Details</label>
        <div class="col-md-4">
        <input id="details" name="details" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">Enter some details</span>
        </div>
        </div>
        <!-- Textarea -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="notes">Notes</label>
        <div class="col-md-4">
        <textarea class="form-control" id="notes" name="notes"></textarea>
        <span class=="help-block">Enter some notes</span>
        </div>
        </div>

        <!-- Text input-->
        </div>
        <div class="modal-footer">

        <div class="col-md-6">
        <input type="submit" value="Submit" class="btn btn-default"/>
        <input type="submit" value="Close" class="btn btn-default" data-dismiss="modal"/>
        </div>
        result: <label class="entity-id"/>
        <label class="result"/>

        </div>
        </form>

        </div>
        </div>
        </div><!-- /.modal-content -->
        </div><!-- /.modal -->
        </div>
        </div>



        <!-- End New Modal for Task-->

        <!-- Start New Modal for Task-->
        <div id="modal-view" class="modal-view-add">

        <div class="modal fade" id="new-entity-modal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true"        xmlns="http://www.w3.org/1999/html">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="">Status</h4>
        </div>
        <form id="new-form" role="form" class="form-horizontal" method="post">
        <div class="modal-body">
        <!-- Text input-->
        <div class="form-group">
        <label class="col-md-4 control-label" for="releaseid">Status</label>
        <div class="col-md-4" id="status-new">
        <select id ="sele-new-status" title="Basic example" multiple="single" list="statusListSelected"  name="statusListSelected" value="statusListSelected" listKey="id" listValue="label" emptyOption="true">
        <option value="New" name="name">New</option>
        </select>
        </div>
        </div>
        <!-- Text input-->
        <div class="form-group">
        <label class="col-md-4 control-label" for="Summary">Summary</label>
        <div class="col-md-4">
        <input id="Summary" name="summary" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">Enter a summary</span>
        </div>
        </div>
        <!-- Textarea -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="Description">Description</label>
        <div class="col-md-4">
        <textarea class="form-control" id="Description" name="description"></textarea>
        <span class=="help-block">Enter detailed description</span>
        </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
        <label class="col-md-4 control-label" for="releaseid">Release</label>
        <div class="col-md-4">
        <input id="releaseid" name="release.name" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">Release</span>
        </div>
        </div>
        <!-- Text input-->
        <!-- Languages -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="language.code">Languages</label>
        <div class="col-md-4" id="languagesInForm">
        <!--<select id ="seleInForm" title="Basic example" multiple="multiple" list="languages"  name="listSelected" value="listSelected" listKey="id" listValue="label" emptyOption="true">
        <!-- <option value="cn" name="code">CHN</option>
        <option value="jp" name="code">JPN</option>
        <option value="fr" name="code">FRA</option>
        </select>-->
        </div>
        </div>
        <div class="modal-footer">

        <div class="col-md-6">
        <input type="submit" value="Submit" class="btn btn-default"/>
        <input type="submit" value="Close" class="btn btn-default" data-dismiss="modal"/>
        </div>
        result: <label class="entity-id"/>
        <label class="result"/>

        </div>
        </div>
        </form>
        </div><!-- /.modal-content -->
        </div><!-- /.modal -->
        </div>
        </div>



        <!-- End New Modal for Task Progress-->

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/dataTables.select.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/dataTables.buttons.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.multiselect.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.multiselect.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap-multiselect.js"></script>
    <script src="<%=request.getContextPath() %>/js/tks/app.js"></script>
        <script src="<%=request.getContextPath() %>/js/tks/task.js"></script>
        <script text="text/javascript">


        </script>
        </body>
        </html>

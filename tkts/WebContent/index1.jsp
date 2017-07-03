<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TKTS</title>
    <link type="text/css" href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/jquery-ui.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/customize.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/dataTables.jqueryui.min.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>

                        <a href="newproduct.jsp" role="button" class="btn">Product</a>
                        <a href="status/new.jsp" role="button" class="btn">Status</a>
                        <a href="lang/new.jsp" role="button" class="btn">Language</a>
                        <a href="newtask.jsp" role="button" class="btn">task</a>
                        <a href="newrelease.jsp" role="button" class="btn">Release</a></br>

                </h1>
            </div>
            <div class="panel-group" id="panel-384998">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-384998" href="#panel-element-360815">Dashboard</a>
                    </div>
                    <div id="panel-element-360815" class="panel-collapse collapse">
                        <div class="panel-body">
                            Anim pariatur cliche...
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-384998" href="#panel-element-375502"></a><a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-384998" href="http://www.layoutit.com/build#panel-element-360815">Tasks</a>
                    </div>
                    <div id="panel-element-375502" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="view">
                            <div class="modal fade" id="myModalContainerNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New task</h4>
                                        </div>
                                        <div class="modal-footer">

                                            <form id="newTask" role="form" class="form-horizontal">
                                                <div class="form-group">
                                                <label class="col-sm-2 control-label" for="name">Summary:</label>
                                                                        <div class="col-sm-10">
                                                                            <input name="entity.summary" type="text" class="form-control" placeholder="Enter a name">
                                                                        </div>
                                                                        <div class="col-sm-10">
                                                                            <label class="col-sm-2 control-label" for="description" >Description: </label>
                                                                            <input name="entity.description" type="text" class="form-control" placeholder="Enter a description">
                                                                        </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="name">Release:</label>
                                                    <div class="col-sm-10">
                                                        <input name="entity.release.id" type="text" class="form-control" placeholder="select a release">
                                                    </div>
                                                    <input type="submit" value="Add" class="form-control" ></input>

                                                </div>
                                            </form>

                                            Result: </br>
                                        ID: <label id="taskID"/>
                                        Name: <label id="taskName"/>
                                        Description: <label id="taskDesc"/>

                                    </div>
                                </div>
                            </div>
                            </div>
                                    </div>
                                    </div>

                                    <!-- Edit -->
                            <div class="view">
                            <div class="modal fade" id="myModalContainerEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New task</h4>
                                        </div>
                                        <div class="modal-footer">

                                            <form id="updateTask" role="form" class="form-horizontal"><!-- action="updatetask" method="post">-->
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="id">ID:</label>
                                                    <div class="col-sm-10">
                                                        <input name="entity.id" type="text" class="form-control">
                                                    </div>
                                                    <label class="col-sm-2 control-label" for="name">Summary:</label>
                                                                            <div class="col-sm-10">
                                                                                <input name="entity.summary" type="text" class="form-control" placeholder="Enter a name">
                                                                            </div>
                                                                            <div class="col-sm-10">
                                                                                <label class="col-sm-2 control-label" for="description" >Description: </label>
                                                                                <input name="entity.description" type="text" class="form-control" placeholder="Enter a description">
                                                                            </div>
                                                    <input type="submit" value="Edit" class="form-control" ></input>

                                                </div>
                                            </form>

                                            Result: </br>
                                        ID: <label id="taskID"/>
                                        Name: <label id="taskName"/>
                                        Description: <label id="taskDesc"/>

                                    </div>
                                </div>
                            </div>
                            </div>
                                    </div>
                                    </div>


                                    <!-- -->
                                    <!-- Delete -->
                            <div class="view">
                            <div class="modal fade" id="myModalContainerDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New task</h4>
                                        </div>
                                        <div class="modal-footer">

                                            <form id="deleteTask" role="form" class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="id">ID:</label>
                                                    <div class="col-sm-10">
                                                        <input name="entity.id" type="text" class="form-control">
                                                    </div>
                                                    <label class="col-sm-2 control-label" for="name">Summary:</label>
                                                    <div class="col-sm-10">
                                                        <input name="entity.summary" type="text" class="form-control" placeholder="Enter a name">
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <label class="col-sm-2 control-label" for="description" >Description: </label>
                                                        <input name="entity.description" type="text" class="form-control" placeholder="Enter a description">
                                                    </div>
                                                    <input type="submit" value="Delete" class="form-control" ></input>

                                                </div>
                                            </form>

                                            Result: </br>
                                        ID: <label id="taskID"/>
                                        Name: <label id="taskName"/>
                                        Description: <label id="taskDesc"/>

                                    </div>
                                </div>
                            </div>
                            </div>
                                    </div>
                                    </div>
                                    <!-- -->
                            <div class="col-md-10 col-md-offset-1">
                            <div class="panel panel-default panel-table">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col col-xs-6">
                                            <h3 class="panel-title">All Tasks</h3>
                                        </div>
                                        <div class="col col-xs-6 text-right">
                                            <!-- <button id="createNew" type="button" class="btn btn-sm btn-primary btn-create">Create New</button>-->
                                            <a id="New" href="#myModalContainerNew" role="button" class="btn" data-toggle="modal">New</a>
                                            <a id="Edit" href="#myModalContainerEdit" role="button" class="btn" data-toggle="modal">Edit</a>
                                            <a id="Delete" href="#myModalContainerDelete" role="button" class="btn" data-toggle="modal">Delete</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table id="list" class="display" ><!--class="table table-striped table-bordered table-list">-->
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th class="hidden-xs">ID</th>
                                                <th>Summary</th>
                                                <th>Description</th>
                                                <th>Release</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                 <th></th>
                                                <th class="hidden-xs">ID</th>
                                                <th>Summary</th>
                                                <th>Description</th>
                                                <th>Release</th>
                                            </tr>
                                        </tfoot>

                                    </table>

                                </div>

                            </div>

                            </div></div></div>
                        </div>
                    </div>
                </div>
            </div>
            <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                    </button> <a class="navbar-brand" href="#">TKTS</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Home</a>
                        </li>
                        <li>
                            <a href="#">Admin</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Project Links<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="https://my.pronq.com/myaccount/?idpId=onehp-idp.hp.com#/myProducts">AGM</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">One more separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-default">
                            Submit
                        </button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
        </div>
    </div>
</div>


<script text="text/javascript">
var appName="tkts"
$(function(){
    $("#newTask").submit(function()
    {
        var formInput=$(this).serialize();
        console.log( formInput );
        $.getJSON('/tks/task/create.action', formInput,function(data) {
            $('#taskName').text('result i ' + data.success+'<br>summary i '+data.entity.summary + '<br>description i '+data.entity.desc + '');
            $('#taskID').text(''+data.entity.id + '');
            $('#taskName').text(''+data.entity.summary + '');
            $('#taskDesc').text(''+data.entity.desc + '');
        });
        return false;
    });
});
$(function(){
    $("#updateTask").submit(function()
    {
        var formInput=$(this).serialize();
        console.log( formInput );
        $.getJSON('/tks/task/update.action', formInput,function(data) {
            $('#taskName').text('result i ' + data.success+'<br>summary i '+data.entity.summary + '<br>description i '+data.entity.desc + '');
            $('#taskID').text(''+data.entity.id + '');
            $('#taskName').text(''+data.entity.summary + '');
            $('#taskDesc').text(''+data.entity.desc + '');
        });
        return false;
    });
});

$(function(){
    $("#deleteTask").submit(function()
    {
        var formInput=$(this).serialize();
        console.log( formInput );
        $.getJSON('/tks/task/delete.action', formInput,function(data) {
            $('#taskName').text('result i ' + data.success+'<br>summary i '+data.entity.name + '<br>description i '+data.entity.desc + '');
            $('#taskID').text(''+data.entity.id + '');
            $('#taskName').text(''+data.entity.summary + '');
            $('#taskDesc').text(''+data.entity.desc + '');
        });
        return false;
    });
});

$("#New").click(function () {
    $("#myModalContainerNew").dialog({modal:true});
});
$("#Edit").click(function () {
    $("#myModalContainerEdit").dialog({modal:true});
});
$("#Delete").click(function () {
    $("#myModalContainerDelete").dialog({modal:true});
});
function format ( d ) {
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>SubTask name:</td>'+
        '<td>'+d.name+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>Extension number:</td>'+
        '<td>'+d.extn+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>Extra info:</td>'+
        '<td>And any further details here (images etc)...</td>'+
        '</tr>'+
        '</table>';
}

$(document).ready(
    function (){
        $("#list").dataTable({
            "ajax": {
                "dataType": 'json',
                "contentType": "application/json; charset=utf-8",
                "type": "POST",
                "url":"/tks/task/listAll",
                "dataSrc": function (json) {
                    return $.parseJSON(JSON.stringify(json.entity));
                }
            },
            "columnDefs": [ { targets: [0,1,2] }],
            "columns": [
                        {
                            "className":      'details-control',
                            "orderable":      false,
                            "data":           null,
                            "defaultContent": ''
                        },
                { "data": "id" },
                { "data": "summary" },
                { "data": "description" },
                { "data": "release.id" }
            ],
            "order": [[ 0, "desc" ]],
            "bLengthChange":true,
            "bFilter": true,
            "bAutoWidth": true
        });
    });

    // Add event listener for opening and closing details
    $('#list tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );

        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );

</script>
</body>
</html>
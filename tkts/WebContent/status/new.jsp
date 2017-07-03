<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
       <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
       <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
       <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
       <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
       <script src="<%=request.getContextPath() %>/js/tks/fillDataTable.js"></script>
       <script src="<%=request.getContextPath() %>/js/tks/actionHandler.js"></script>

<title>New Status</title>
</head>
<body>

<div class="view">
<div class="modal fade" id="myModalContainerNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Status</h4>
</div>
<div class="modal-body">
<form id="newStatus" role="form" class="form-horizontal">

</div>
</form>
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
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Updqte Status</h4>
</div>
<div class="modal-body">
<form id="updateStatus" role="form" class="form-horizontal">

</div>
</form>
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
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Delete Status</h4>
</div>

<div class="modal-body">

<form id="deleteStatus" role="form" class="form-horizontal">
</form>
             <div class="modal-footer">
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
                    <h3 class="panel-title">Status List</h3>
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
                <table id="list" class="table table-striped table-bordered table-list">
                  <thead>
                          <tr>
                          <!--<th><em class="fa fa-cog"></em></th>-->
                                                      <th class="hidden-xs">ID</th>
                                                      <th>Name</th>
                                                      <th>Description</th>

                          </tr>
                      </thead>
                          <tfoot>
                                      <tr>
                                      <!--<th><em class="fa fa-cog"></em></th>-->
                                                                                                <th class="hidden-xs">ID</th>
                                                                                                <th>Name</th>
                                                                                                <th>Description</th>
                                      </tr>
                                  </tfoot>

                </table>

              </div>

            </div>

</div></div></div>


<script text="text/javascript">
    var appName="tkts"
     $(function(){
         $("#newStatus").submit(
                                   function()   {
                                               var formInput=$(this).serialize();
                                                console.log( formInput );
                                               $.getJSON('/tks/status/create.action', formInput,function(data) {
                                               $('#statusName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.description + '');
                                               $('#statusID').text(''+data.entity.id + '');
                                               $('#statusName').text(''+data.entity.name + '');
                                               $('#statusDescription').text(''+data.entity.description + '');
                                                     });
                                                 return false;
                                                  }

                                                  );
          $(function () { window.close();});
         });

         $(function(){
                  $("#updateStatus").submit(function()
                  {
                        var formInput=$(this).serialize();
                         console.log( formInput );
                        $.getJSON('/tks/status/update.action', formInput,function(data) {
                                                                      $('#statusName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.description + '');
                                                                      $('#statusID').text(''+data.entity.id + '');
                                                                      $('#statusName').text(''+data.entity.name + '');
                                                                      $('#statusDescription').text(''+data.entity.description + '');
                              });
                          return false;
                           });
                  });

                  $(function(){
                           $("#deleteStatus").submit(function()
                           {
                                 var formInput=$(this).serialize();
                                  console.log( formInput );
                                            $.getJSON('/tks/status/delete.action', formInput,function(data) {
                                               $('#statusName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.description + '');
                                               $('#statusID').text(''+data.entity.id + '');
                                               $('#statusName').text(''+data.entity.name + '');
                                               $('#statusDescription').text(''+data.entity.description + '');
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
        $(document).ready(fillDataTable("#list","/tks/status/listAll",[
                   { "data": "id" }, { "data": "name" },{ "data": "description" } ], [ { targets: [0,1,2] }]
        ));

        $(document).ready(function(){  $('#newStatus').load("/tks/status/status-form-new.html");  });
        $(document).ready(function(){  $('#updateStatus').load("/tks/status/status-form-update.html");  });
        $(document).ready(function(){  $('#deleteStatus').load("/tks/status/status-form-delete.html");  });
</script>
  </body>
    </html>
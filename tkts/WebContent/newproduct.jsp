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
<title>New Product</title>
</head>
<body>

<div class="view">
<div class="modal fade" id="myModalContainerNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Product</h4>
</div>
<div class="modal-footer">

<form id="newProduct" role="form" class="form-horizontal">
                <div class="form-group">
                  <label class="col-sm-2 control-label" for="name">Name:</label>
                  		<div class="col-sm-10">
                     <input name="entity.name" type="text" class="form-control" placeholder="Enter a name">
                     </div>
                    <div class="col-sm-10">
                     <label class="col-sm-2 control-label" for="description" >Description: </label>
                      <input name="entity.desc" type="text" class="form-control" placeholder="Enter a description">
                      </div>
                      <input type="submit" value="Add" class="form-control" ></input>

                  </div>
</form>

Result: </br>
ID: <label id="productID"/>
Name: <label id="productName"/>
Description: <label id="productDesc"/>

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
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Product</h4>
</div>
<div class="modal-footer">

<form id="updateProduct" role="form" class="form-horizontal"><!-- action="updateProduct" method="post">-->
                <div class="form-group">
                <label class="col-sm-2 control-label" for="id">ID:</label>
                                  		<div class="col-sm-10">
                                     <input name="entity.id" type="text" class="form-control">
                                     </div>
                  <label class="col-sm-2 control-label" for="name">Name:</label>
                  		<div class="col-sm-10">
                     <input name="entity.name" type="text" class="form-control" placeholder="Enter a name">
                     </div>
                    <div class="col-sm-10">
                     <label class="col-sm-2 control-label" for="description" >Description: </label>
                      <input name="entity.desc" type="text" class="form-control" placeholder="Enter a description">
                      </div>
                      <input type="submit" value="Edit" class="form-control" ></input>

                  </div>
</form>

Result: </br>
ID: <label id="productID"/>
Name: <label id="productName"/>
Description: <label id="productDesc"/>

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
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Product</h4>
</div>
<div class="modal-footer">

<form id="deleteProduct" role="form" class="form-horizontal"><!-- action="updateProduct" method="post">-->
                <div class="form-group">
                <label class="col-sm-2 control-label" for="id">ID:</label>
                                  		<div class="col-sm-10">
                                     <input name="entity.id" type="text" class="form-control">
                                     </div>
                  <label class="col-sm-2 control-label" for="name">Name:</label>
                  		<div class="col-sm-10">
                     <input name="entity.name" type="text" class="form-control" placeholder="Enter a name">
                     </div>
                    <div class="col-sm-10">
                     <label class="col-sm-2 control-label" for="description" >Description: </label>
                      <input name="entity.desc" type="text" class="form-control" placeholder="Enter a description">
                      </div>
                      <input type="submit" value="Delete" class="form-control" ></input>

                  </div>
</form>

Result: </br>
ID: <label id="productID"/>
Name: <label id="productName"/>
Description: <label id="productDesc"/>

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
                    <h3 class="panel-title">Product List</h3>
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

                                                      <th class="hidden-xs">ID</th>
                                                      <th>Name</th>
                                                      <th>Description</th>

                          </tr>
                      </thead>
                          <tfoot>
                                      <tr>
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
         $("#newProduct").submit(function()
         {
               var formInput=$(this).serialize();
                console.log( formInput );
               $.getJSON('/tks/product/create.action', formInput,function(data) {
               $('#productName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.desc + '');
               $('#productID').text(''+data.entity.id + '');
               $('#productName').text(''+data.entity.name + '');
               $('#productDesc').text(''+data.entity.desc + '');
                     });
                 return false;
                  });
         });
         $(function(){
                  $("#updateProduct").submit(function()
                  {
                        var formInput=$(this).serialize();
                         console.log( formInput );
                        $.getJSON('/tks/product/update.action', formInput,function(data) {
                        $('#productName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.desc + '');
                        $('#productID').text(''+data.entity.id + '');
                        $('#productName').text(''+data.entity.name + '');
                        $('#productDesc').text(''+data.entity.desc + '');
                              });
                          return false;
                           });
                  });

                  $(function(){
                           $("#deleteProduct").submit(function()
                           {
                                 var formInput=$(this).serialize();
                                  console.log( formInput );
                                 $.getJSON('/tks/product/delete.action', formInput,function(data) {
                                 $('#productName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.desc + '');
                                 $('#productID').text(''+data.entity.id + '');
                                 $('#productName').text(''+data.entity.name + '');
                                 $('#productDesc').text(''+data.entity.desc + '');
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
$(document).ready(
        function (){
            $("#list").dataTable({
                                   "ajax": {
                                           "dataType": 'json',
                                           "contentType": "application/json; charset=utf-8",
                                           "type": "POST",
                                           "url":"/tks/product/listAll",
                                           "dataSrc": function (json) {
                                                 return $.parseJSON(JSON.stringify(json.entity));
                                           }
                                       },
                                       "columnDefs": [ { targets: [0,1,2] }],
                                       "columns": [
                                           { "data": "id" },
                                           { "data": "name" },
                                           { "data": "desc" }
                                       ],
                                       "order": [[ 0, "desc" ]],
                                       "bLengthChange":true,
                                       "bFilter": true,
                                       "bAutoWidth": true
        });
        });
</script>
  </body>
    </html>
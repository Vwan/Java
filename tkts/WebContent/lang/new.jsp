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
<title>New Language</title>
</head>
<body>

<!-- New -->
<div class="view">
<div class="modal fade" id="myModalContainerNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Language</h4>
</div>
<div class="modal-footer">

<form id="newLanguage" role="form" class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label" for="code">LANG CODE:</label>
        <div class="col-sm-10">
            <input name="language.code" type="text" class="form-control" placeholder="Enter a code">
        </div>
        <div class="col-sm-10">
            <label class="col-sm-2 control-label" for="name" >LANG NAME: </label>
            <input name="language.name" type="text" class="form-control" placeholder="Enter full name">
        </div>
        <input type="submit" value="Add" class="form-control" ></input>

    </div>
</form>
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
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Language</h4>
</div>
<div class="modal-footer">

<form id="updateLanguage" role="form" class="form-horizontal" method="post"><!-- action="createLanguage" method="post">-->
</form>
</div>
</div>
</div>
</div>
</div>
</div>

<!-- Delete -->
<div class="view">
<div class="modal fade" id="myModalContainerDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
<h4 class="modal-title" id="myModalLabel" contenteditable="true">Create New Language</h4>
</div>
<div class="modal-footer">

<form id="deleteLanguage" role="form" class="form-horizontal" method="post"><!-- action="createLanguage" method="post">-->
</form>
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
                    <h3 class="panel-title">Language List</h3>
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
                         <!-- <th><em class="fa fa-cog"></em></th>-->
                                                      <th class="hidden-xs">ID</th>
                                                      <th>Name</th>
                                                      <th>Description</th>

                          </tr>
                      </thead>
                          <tfoot>
                                      <tr>
                                     <!-- <th><em class="fa fa-cog"></em></th>-->
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
          $("#newLanguage").submit(function(){
                                 var formInput=$(this).serialize();
                                   console.log( formInput );
                                  $.getJSON('/tks/lang/create.action', formInput,function(data) {
                                  $('#LanguageID').text(''+data.Language.id + '');
                                  $('#LanguageCode').text(''+data.Language.code + '');
                                  $('#LanguageName').text(''+data.Language.name + '');
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

$(document).ready(fillDataTable("#list","/tks/lang/listAll",[
           { "data": "id" }, { "data": "code" },{ "data": "name" } ], [ { targets: [0,1,2] }]
));


        $(document).ready(function(){            $('#updateLanguage').load("/tks/lang/lang_form.html");            });
        $(document).ready(function(){            $('#deleteLanguage').load("/tks/lang/lang_form.html");                   });



</script>
  </body>
    </html>
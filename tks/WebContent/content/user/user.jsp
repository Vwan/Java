    <!DOCTYPE html>
        <html lang="en">
        <%@ page pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>

        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/select.dataTables.min.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/editor.dataTables.min.css" rel="stylesheet"/>
        <link type="text/css" href="<%=request.getContextPath() %>/css/buttons.dataTables.min.css" rel="stylesheet"/>
        <title>User</title>
        </head>

        <body>
<div class="container-fluid">
        <!-- Start Header Bar -->
        <div id="header">

        </div>
        <!-- End Header Bar-->
            <!-- Start Modal - New -->
            <div id="modal-view" class="modal-view-add">
            <div class="modal fade" id="new-entity-modal" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true"        xmlns="http://www.w3.org/1999/html">
            <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="">User</h4>
            </div>
            <form id="new-form" role="form" class="form-horizontal" method="post">
            <div class="modal-body">
            <!-- Name -->
            <div class="form-group">
            <label class="col-md-4 control-label" for="new-name">Name</label>
            <div class="col-md-4">
            <input id="new-name" name="name" type="text" placeholder="" class="form-control input-md" required="">
            <span class="help-block">User Name</span>
            </div>
            </div>
            <!-- Description -->
            <div class="form-group">
            <label class="col-md-4 control-label" for="new-password">Password</label>
            <div class="col-md-4">
            <input id="new-password" name="password" type="text" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Password convention</span>
            </div>
            </div>
            </div>
            <!-- Description -->
            <div class="form-group">
            <label class="col-md-4 control-label" for="new-email">Email</label>
            <div class="col-md-4">
            <input id="new-email" name="email" type="text" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Password convention</span>
            </div>
            </div>


            <div class="modal-footer">

            <div class="col-md-6">
            <input type="submit" value="Submit" class="btn btn-default"/>
            <input type="submit" value="Close" class="btn btn-default" data-dismiss="modal"/>
            </div>
            <label class="entity-id"/>
            <label class="result"/></br>

            </div>
            </form>
            </div><!-- /.modal-content -->
            </div><!-- /.modal -->
            </div>
            </div>
            <!-- End Modal - New -->
        <!-- Start Modal - Assign to Product -->
        <div id="modal-view" class="modal-view-add">
        <div class="modal fade" id="assign-product-entity-modal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true"        xmlns="http://www.w3.org/1999/html">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" >Assign User to Product</h4>
        </div>
        <form id="assign-product-form" role="form" class="form-horizontal" method="post">
        <div class="modal-body">
        <!-- Name -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="new-name">User ID</label>
        <div class="col-md-4">
        <input id="user-id" name="name" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">User ID</span>
        </div>
        </div>
        <!-- Description -->
            <!-- Product -->
            <div class="form-group">
            <label class="col-md-4 control-label" for="product..name">Product</label>
            <div class="col-md-4" id="productInForm">

            </div>
            </div>
            </div>

        <div class="modal-footer">

        <div class="col-md-6">
        <input type="submit" value="Submit" class="btn btn-default"/>
        <input type="submit" value="Close" class="btn btn-default" data-dismiss="modal"/>
        </div>
        <label class="entity-id"/>
        <label class="result"/></br>

        </div>
        </form>
        </div><!-- /.modal-content -->
        </div><!-- /.modal -->
        </div>
        </div>
        <!-- End Modal - Assign to Product -->
        <!-- Start Modal - Edit -->
        <div id="modal-view-add" class="modal-view-add">
        <div class="modal fade" id="edit-entity-modal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true"        xmlns="http://www.w3.org/1999/html">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="confirmDeleteModalLabel">User</h4>
        </div>
        <form id="edit-form" role="form" class="form-horizontal" method="post">
        <div class="modal-body">
        <!-- ID -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="id">ID</label>
        <div class="col-md-4">
        <input id="entity-id" name="id" type="text" class="form-control input-md"><!-- disabled="true">-->
        <span class="user-id">ID</span>
        </div>
        </div>
        <!-- Name -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="edit-name">Name</label>
        <div class="col-md-4">
        <input id="edit-name" name="name" type="text" placeholder="Enter a Name" class="form-control input-md" required="">
        <span class="help-block">Name</span>
        </div>
        </div>
        <!-- Description -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="edit-password">Password</label>
        <div class="col-md-4">
        <input id="edit-password" name="password" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">Password convention</span>
        </div>
        </div>
        </div>
        <!-- Description -->
        <div class="form-group">
        <label class="col-md-4 control-label" for="edit-email">Email</label>
        <div class="col-md-4">
        <input id="edit-email" name="email" type="text" placeholder="" class="form-control input-md" required="">
        <span class="help-block">Password convention</span>
        </div>
        </div>
        <div class="modal-footer">

        <div class="col-md-6">
        <input type="submit" value="Submit" class="btn btn-default"/>
        <input type="submit" value="Close" class="btn btn-default" data-dismiss="modal"/>
        </div>
        <label class="result"/>

        </div>
        </form>
        </div><!-- /.modal-content -->
        </div><!-- /.modal -->
        </div>
        </div>
        <!-- End Modal - Edit -->
        <!-- -->
        <!-- Delete --><!-- start: Delete Coupon Modal -->
            <div class="delete-modal">

            <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
            </div>
            <div class="modal-body">
            <p>You are about to delete this record (<label class="id-to-be-deleted"></label>), do you want to proceed?</p>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <button type="button" class="btn btn-danger btn-ok">Delete</button>
            </div>
            </div>
            </div>
            </div>

            </div>
            </div>
            <!-- End Delete Model-->
        <!-- -->
        <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default panel-table">
        <div class="panel-heading">
        <div class="row">
        <div class="col col-xs-6">
        <h3 class="panel-title">User List</h3>
        </div>
        <div class="col col-xs-6 text-right">
            <a id="btnAssignToProduct" href="#assign-product-entity-modal" role="button" class="btn" data-toggle="modal"><i class="glyphicon glyphicon-refresh">Assign to Product</i></a>
            <a id="btnNew" href="#new-entity-modal" role="button" class="btn" data-toggle="modal" title="Click to add more"><i class="glyphicon glyphicon-plus-sign"></i></a>
        <a id="btnEdit" href="#edit-entity-modal" role="button" class="btn" data-toggle="modal" title="Click to edit selected row"><i class="glyphicon glyphicon-edit"></i></a>
            <a id="btnDelete" href="#confirm-delete" role="button"  data-toggle="modal" class="btn" ><i class="glyphicon glyphicon-trash"></i></a>
            <a id="bthRefresh" role="button" class="btn" ><i class="glyphicon glyphicon-refresh"></i></a>
        <!-- <a id="Edit" href="#confirmDeleteModalContainerEdit" role="button" class="btn" data-toggle="modal">Edit</a>
        <a id="Delete" href="#confirmDeleteModalContainerDelete" role="button" class="btn" data-toggle="modal">Delete</a>-->
        </div>
        </div>
        </div>
        <div class="panel-body">
        <table id="list" class="table table-striped table-bordered table-list" data-toggle="table" data-click-to-select="true" data-select-item-name="radioName">
        <thead>
        <tr>
        <!--<th><em class="fa fa-cog"></em></th>-->
        <th></th>
        <th></th>
        <th class="hidden-xs">ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
        <!--<th><em class="fa fa-cog"></em></th>-->
        <th></th>
        <th></th>
        <th class="hidden-xs">ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        </tr>
        </tfoot>

        </table>

        </div>

        </div>

        </div>

</div>

        <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/dataTables.select.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/dataTables.buttons.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/tks/app.js"></script>
        <script src="<%=request.getContextPath() %>/js/tks/user.js"></script>

        </body>
        </html>
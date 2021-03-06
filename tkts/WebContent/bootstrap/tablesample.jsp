<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
<title>New Status</title>
</head>
<body>


                   <div class="col-md-10 col-md-offset-1">

                              <div class="panel panel-default panel-table">
                                <div class="panel-heading">
                                  <div class="row">
                                    <div class="col col-xs-6">
                                      <h3 class="panel-title">Tasks</h3>
                                    </div>
                                    <div class="col col-xs-6 text-right">
                                      <button type="button" class="btn btn-sm btn-primary btn-create" onclick="location='/tks/newtask.jsp'">Create New</button>
                                    </div>
                                  </div>
                                </div>
                                <div class="panel-body">
                                  <table class="table table-striped table-bordered table-list">
                                    <thead>
                                      <tr>
                                          <th><em class="fa fa-cog"></em></th>
                                          <th class="hidden-xs">ID</th>
                                          <th>Summary</th>
                                          <th>Description</th>
                                          <th>Status</th>
                                          <th>Date</th>
                                          <th>Languages</th>
                                          <th></th>
                                          <th></th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                            <tr>
                                              <td align="center">
                                                <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                                                <a class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                              </td>
                                              <td class="hidden-xs">1</td>
                                              <td></td>
                                              <td></td>
                                            </tr>
                                          </tbody>
                                  </table>

                                </div>
                                <div class="panel-footer">
                                  <div class="row">
                                    <div class="col col-xs-4">Page 1 of 5
                                    </div>
                                    <div class="col col-xs-8">
                                      <ul class="pagination hidden-xs pull-right">
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                      </ul>
                                      <ul class="pagination visible-xs pull-right">
                                          <li><a href="#">«</a></li>
                                          <li><a href="#">»</a></li>
                                      </ul>
                                    </div>
                                  </div>
                                </div>
                              </div>

                  </div></div></div>


  </body>
    </html>
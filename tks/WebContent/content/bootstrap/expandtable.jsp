<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/css//bootstrap.css" rel="stylesheet">

       <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
       <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
       <script src="<%=request.getContextPath() %>/js/knockout.js"></script>
       <script src="<%=request.getContextPath() %>/js/knockout.maplping-latest.debug.js"></script>
       <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>


<title>New Status</title>
<style>
.hiddenRow {
    padding: 0 !important;
}
</style>
</head>
</body>
<table class="table table-condensed" style="border-collapse:collapse;">
    <thead>
        <tr>
            <th>#</th>
            <th>Date</th>
            <th>Description</th>
            <th>Credit</th>
            <th>Debit</th>
            <th>Balance</th>
        </tr>
    </thead>
    <tbody>
        <tr data-toggle="collapse" data-target=".demo1">
            <td>1</td>
            <td>05 May 2013</td>
            <td>Credit Account</td>
            <td class="text-success">$150.00</td>
            <td class="text-error"></td>
            <td class="text-success">$150.00</td>
        </tr>
        <tr>
            <td class="hiddenRow">
                <div class="collapse demo1">Demo1</div>
            </td>
            <td class="hiddenRow">
                <div class="collapse demo1">Demo1</div>
            </td>
            <td class="hiddenRow">
                <div class="collapse demo1">Demo1</div>
            </td>
            <td class="hiddenRow">
                <div class="collapse demo1">Demo1</div>
            </td>
            <td class="hiddenRow">
                <div class="collapse demo1">Demo1</div>
            </td>
            <td class="hiddenRow">
                <div class="collapse demo1">Demo1</div>
            </td>
        </tr>
        <tr data-toggle="collapse" data-target="#demo2">
            <td>2</td>
            <td>05 May 2013</td>
            <td>Credit Account</td>
            <td class="text-success">$11.00</td>
            <td class="text-error"></td>
            <td class="text-success">$161.00</td>
        </tr>
        <tr>
            <td colspan="6" class="hiddenRow">
                <div id="demo2" class="collapse">Demo2</div>
            </td>
        </tr>
        <tr data-toggle="collapse" data-target="#demo3">
            <td>3</td>
            <td>05 May 2013</td>
            <td>Credit Account</td>
            <td class="text-success">$500.00</td>
            <td class="text-error"></td>
            <td class="text-success">$6621.00</td>
        </tr>
        <tr>
            <td colspan="6" class="hiddenRow">
                <div id="demo3" class="collapse">Demo3</div>
            </td>
        </tr>
    </tbody>
</table>
<script type="text/javascript">
$('.collapse').on('show.bs.collapse', function () {
    $('.collapse.in').collapse('hide');
});
</script>
</body>
</html>
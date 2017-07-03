    <%@ page pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>Dynamic Table</title>

        <link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
<input type="button" value="insert table" onClick="CreateTable(3,3)" >
<input type="button" value="insert row">
<div class="table-responsive" id="createtable">
<div id="createrow"></div>
<script src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript">
    function CreateTable(rowCount,cellCount)
    {
       // var tableDiv = $("<div class='table-responsive'>");
       // $('#myMenu').append(tableDiv);
        //var table = $("<table class='table table-striped table-bordered table-hover table-condensed small'>");
        var table=$('<table class="table table-striped table-bordered table-list" data-toggle="table" data-click-to-select="true" data-select-item-name="radioName">');
        $("#createtable").append(table);
        /* Table Header */
        html = "<thead>" +
        "    <tr>" +
        "        <th><strong>CN</strong></th>" +
        "        <th><strong>JA</strong></th>" +
        "        <th><strong>FR</strong></th>" +
        "     </tr>" +
        "</thead>";

        var tableHead = $(html);
        table.append(tableHead);

        /* Create Table Rows and Cells */
        for(var i=0;i<rowCount;i++)
        {
            var tr=$("<tr>");
                for(var j=0;j<cellCount;j++)
                {
                var td=$("<td >0</td>");
                td.appendTo(tr);
                }
        tr.appendTo(table);
            }
            $("#createtable").append("</table>");
    }
</script>
</body>
</html>
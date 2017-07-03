<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON Example</title>
<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
    var titleSpan = $(".container #title");
    //title span is now set to the span title node
    titleSpan = $("#title");
    //this does the same as well.
    $(".container").html('<span id="footer">Goodbye</span>');
});

    function gotClick(){
    $("#show").hide();
    $.post("JSONExample",$("form1").serializeArray(),
        function(data,statusText){
        $("#show").height(80)
            .width(240)
            .css("border","1px solid black")
            .css("border-radius","15px")
            .css("background-color","#efef99")
            .css("color","green")
            .css("padding","20px")
            .empty();
            for (var propName in data){
             $("#show").append(propName +"-->" + data[propName] +"<br/>";
            }
            $("#show").show(600);
            },"json");
            }
</script>
</head>
<body>
<div class="container">
<span  id="title">Hello World</span>
</div>
<s:form id="form1">
<s:textfield name="field1" label="field 1"/>
<s:password name="field2" label="field 2"/>
<s:password name="field3" label="field 3"/>
<tr><td colspan="2">
<input type="button" value="submit" onclick="gotClick();"/>
</td></tr>
</s:form>


<s:form action="JSONExampleJSP">
<s:textfield name="user.Id" label="Id"/>
<s:textfield name="user.UserName" label="name"/>
<s:textfield name="user.Password" label="password"/>
<s:textfield name="user.Email" label="email"/>
<s:submit name="submit" value="submit"/>
</s:form>

</body>
</html>
<%@ page language="java"%>
<html>
	<body>
		<form name=form1 action="" method="get">
			<input type="text" name="textParam1" size="50 px" value="國a">
			<br>
			<input type="file" name="fileParam" size="50 px" value="">
			<br>
			<input type="button" value="submit" onclick="submitForm()">
		</form>
		<script type="text/javascript">
			function submitForm(){
				var str ="國a";
				form1.action = "/jsp/gbk.jsp?qryParam1=" +
				 encodeURIComponent(str) + "&qryParam2="+  encodeURIComponent(form1.textParam1.value) ;
				form1.submit();
			}
		</script>
	</body>
</html>
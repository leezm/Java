<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/first.css">


  </head>
   
  <script type="text/javascript" src="js/login.js"></script>
  <script>
  	function showtip(){
  		<% String tip = (String)request.getAttribute("tip");
  			if(tip != null){
  			
  		%>
  		var tip = '<%=request.getAttribute("tip")%>';
  		alert(tip);
  		<% } %>
  		
  	
  	}
  </script>
  <body>
  <div id="father">
  		<div id="top">
  			<jsp:include page="top.jsp"></jsp:include>
  		</div>

  		<div id="load">
  		
	  		<jsp:include page="load.jsp"></jsp:include>
		
  		</div>
  		<div id="down">
  			<jsp:include page="down.jsp"></jsp:include>
  		</div>
  	</div>
  </body>
</html>

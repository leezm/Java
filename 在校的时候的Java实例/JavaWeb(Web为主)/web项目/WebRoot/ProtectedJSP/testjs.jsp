<%@ page language="java" import="java.util.*,com.domain.User" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testjs.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/test.css">

	
  </head>
 
  <script type="text/javascript" src="js/table.js"></script>
  
  <body onload='initialXMLHttpRequest("datatable");'>
 	<%
   		User user = (User)session.getAttribute("user");
   		if(user == null){
   			request.setAttribute("tip", "会话时间结束，请重新登录！");
   			request.getRequestDispatcher("jsp/first.jsp").forward(request,response);
   		}
   	 %>
  	<div id="father">
  		<div id="top">
  			<jsp:include page="top.jsp"></jsp:include>
  		</div>
  		<div id="left">
  			<jsp:include page="left.jsp"></jsp:include>
  		</div>
  		<div id="right">
	  		<jsp:include page="right.jsp"></jsp:include>
		
  		</div>
  		<div id="down">
  			<jsp:include page="down.jsp"></jsp:include>
  		</div>
  	</div>
  
		
  </body>
</html>

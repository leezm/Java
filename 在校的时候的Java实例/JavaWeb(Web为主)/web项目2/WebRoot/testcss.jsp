<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testcss.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
    <div id="menubar" width="220px;">
    	<ul>
    		<li><a href="#">编辑信息</a>
    			<ul>
    				<li><a href="">编辑用户信息</a></li>
    				<li><a href="">编辑教师信息</a></li>
    			</ul>
    		</li>
    		<li><a href="#">查询信息</a></li>
    		<li><a href="#">首页</a></li>
    	</ul>
    
    </div>
  </body>
</html>

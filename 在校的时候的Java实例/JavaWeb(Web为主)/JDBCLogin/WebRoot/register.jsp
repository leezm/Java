<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center>
    <%
    	String tip = (String)request.getAttribute("tip");
    	if(tip != null){    
     %>
     		<%=tip %>
     <%
     	}
      %>
    	
    	<h2>ע��</h2>
    	<form action="RegisterServlet" method="post">
	    	
	    			�û���:
	    				<input type="text" maxlength="30" name="username"/>
	    			��      ��:
	    				<input type="password" maxlength="30" name="password"/>
	    			ȷ���� ��:
	    				<input type="password" maxlength="30" name="repswd"/>
	    		
	    				<input type="submit" value="�ύ"/>
	    			
	    				<input type="reset" value="����"/>
    	</form>
    
    </center>
  </body>
</html>

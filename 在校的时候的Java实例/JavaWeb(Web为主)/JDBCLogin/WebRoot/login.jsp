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
	<script type="text/javascript" src = "code.js"></script>   
	<link rel="stylesheet" type="text/css" href="code.css">  
	
	<style type="text/css">
		div{
			width:500px;
			height:200px;
			border:5px;
			background:green;
		}
	</style>
	
	
	
  </head>
  
  <body onload="createCode();">
    <center>
    <%
    	String tip = (String)request.getAttribute("tip");
    	if(tip != null){    
     %>
     		<%=tip %>
     <%
     	}
      %>
    	<div>
    	<h2>��¼</h2>
    	<form action="JudgeServlet" method="post">
	    			�û���
	    				<input type="text" maxlength="30" name="username"/><br>
	    				
	    			��      �룺
	    				<input type="password" maxlength="30" name="password"/><br>
	    				
	    			��֤�룺
						<input type="text" id="input1" />      
						<input type="text" id="checkCode" class="code" style="width: 55px" /> 
						<a href="#" onclick="createCode()">��һ��</a><br>   
	    	
	    				<input type="submit" id="Button1" onclick="validate();" value="�ύ"/>
	    		
	    				<input type="reset" value="����"/>
	    			
	    				<input type="submit" value="ע��"/>	    	
    	</form>
    	</div>
    </center>
  </body>
</html>

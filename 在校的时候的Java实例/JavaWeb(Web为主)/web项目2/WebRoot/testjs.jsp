<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="json2.js"></script>
	<script type="text/javascript" src="table.js"></script>
    <script type="text/javascript">
  		var xmlHttp = null;
  		var cols = 0;
  		var addIndex = 0;
  		var dataTable = null;
  		
  		function initial(){
  			xmlHttp = new XMLHttpRequest();
  			xmlHttp.onreadystatechange = state_change;
  			xmlHttp.open("POST","http://localhost:8080/54/demoServlet",false);
  			xmlHttp.send(null);
  		}
  		function state_change(){
  			if(xmlHttp.readyState == 4){
				if(xmlHttp.status == 200){
					initialTable();
				}
			}
  		}
		function initialTable(){
			var jsontext = xmlHttp.responseText;
			var jsonobj = JSON.parse(jsontext);
			var columnNames = jsonobj.columnNames;
			var titles = jsonobj.titles;
			var datas = jsonobj.datas;
			
			cols = columnNames.length;
			addIndex = cols - 3;
			
			dataTable = document.getElementById("1");
			
			var tr = document.createElement("tr");
			for(var col = 0; col < cols; col++){
				var th = document.createElement("th");
				th.setAttribute("align","center");
				th.innerHTML = titles[col];
				tr.appendChild(th);
			}
			dataTable.appendChild(tr);
			
			var rows = datas.length;
			
			for(var row = 0; row < rows; row++){
				var otr = document.createElement("tr");
				for(var col = 0; col < cols; col++){
					var otd = document.createElement("td");
					var oinput = document.createElement("input");
					oinput.setAttribute("align","center");
					oinput.setAttribute("name",columnNames[col]);
					if(col < addIndex){
						oinput.setAttribute("type","text");
						oinput.setAttribute("value",datas[row][columnNames[col]]);
					}else{
						oinput.setAttribute("type","checkbox");
						if(col == addIndex){
							oinput.setAttribute("disabled",true);
						}else{
							oinput.setAttribute("onclick","check(this)");
						}
					}
					otd.appendChild(oinput);
					otr.appendChild(otd);
				}
				dataTable.appendChild(otr);
			}
		}
		function check(e){
		var tr = e.parentNode.parentNode;
		var inputs = tr.getElementsByTagName("input");
		var deletenode = inputs[addIndex + 1];
		var updatenode = inputs[addIndex + 2];
		if(e.checked){
			if(e.name=="delete" && updatenode.checked){
				updatenode.checked=false;
			}else if(e.name=="update" && deletenode.checked){
				deletenode.checked=false;		
			}
		}
			
	}
  	</script>
  </head>
  
  <body>
  	<center>
  	<table id="1" align="center" border="1"></table>
		<input type="button" value="OK" onclick="initial();"/> 
		<input type="button" value="添加记录" onclick="addrow();"/>
		<input type="button" value="删除记录" onclick="delerow();"/>
		<input type="button" value="保存记录" onclick="saverecords();"/> 
	</center>
  </body>
</html>

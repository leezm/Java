
var columnNames = null;
var titles = null;
var cols = 0;
var addIndex = 0;
var deleteIndex = 0;
var updateIndex = 0;
var xmlHttp = null;
var dataTable = null;
var datas = null;
var options = null;
var optionNames = null;
function request(e){
	sendRequest(e.id, "search", null);
}
function initialXMLHttpRequest(id){
	xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange=status_change;
	dataTable = document.getElementById(id);
}

var tid = null;
var opersign = null;
function sendRequest(id,oper, jsonarraytext){
	var url = "http://localhost:8080/523-23/demoServlet";
	url += "?id=" + id + "&oper=" + oper;
	opersign = oper;
	tid = id;
	xmlHttp.open("POST", url, true);
	xmlHttp.onreadystatechange = status_change;
	xmlHttp.send(jsonarraytext);
	
}


function status_change(){
	if(xmlHttp.readyState == 4){
		if(xmlHttp.status == 200){
			if(opersign == "edit"){
				alert(xmlHttp.responseText);
				freshTable();
			}else{
			
			var jsonobj = JSON.parse(xmlHttp.responseText);
		
			columnNames = jsonobj.columnNames;
			
			titles = jsonobj.titles;
			datas = jsonobj.datas;
			options = jsonobj.options;
			optionNames = jsonobj.optionNames;
			
			
			cols = columnNames.length;
			
			
			addIndex = cols - 3;
			deleteIndex = addIndex + 1;
			updateIndex = deleteIndex + 1;
			
			clearTable();
			
			var otr = document.createElement("tr");
			
			for(var col = 0; col < cols; col += 1){
				var oth = document.createElement("th");
				oth.innerHTML = titles[col];
				otr.appendChild(oth);
			
			}
			
			dataTable.appendChild(otr);
			
			var rows = datas.length;
			
			for(var row = 0; row < rows; row++){
				var otr = document.createElement("tr");
				for(var col = 0; col < cols; col++){
					var otd = document.createElement("td");
					
					
					if(options.length > 1 && col == addIndex-1){
						
						var select = document.createElement("select");
						
						select.setAttribute("name", columnNames[col]);
						for(var i = 0;i < options.length;i++){
							
							var option = document.createElement("option");
							
							option.value = options[i][optionNames[0]] ;
							
							option.innerHTML = options[i][optionNames[1]] ;
							select.appendChild(option);
							
						}
						
						select.value = datas[row][columnNames[col]];
						select.disabled = true;
						otd.appendChild(select);
					}else{
						
						var oinput = document.createElement("input");
						oinput.setAttribute("align","center");
						oinput.setAttribute("name",columnNames[col]);
						
						if(col < addIndex){
							oinput.setAttribute("type","text");
							oinput.setAttribute("value",datas[row][columnNames[col]]);
							oinput.setAttribute("disabled",true);
						}else{
							oinput.setAttribute("type","checkbox");
							if(col == addIndex){
								oinput.setAttribute("disabled",true);
							}else if(col == deleteIndex){
							
								oinput.setAttribute("onclick","check(this)");
							}else{
							
								oinput.setAttribute("onclick","check(this)");
							}
						}
						otd.appendChild(oinput);
					}
					
					
					otr.appendChild(otd);
				}
				
				dataTable.appendChild(otr);
				
			}
			var inputs = document.getElementsByName("b");
	  		var len = inputs.length;
	  		
	  		for(var i = 0 ;i < len;i++){
	  			
	  			inputs[i].style.display = "block";
	  			
	  		}
	
			}
			
		}
	}
}

function freshTable(){
	
	var adds = document.getElementsByName("add");
	var deletes = document.getElementsByName("delete");
	var updates = document.getElementsByName("update");
	
	for(var row = 0; row < adds.length; row += 1){
		var anode = adds[row];
		if(!anode.checked){
			continue;
		}
		
		var tr = anode.parentNode.parentNode;
		
		var tds = tr.getElementsByTagName("td");
		for(var col = 0; col < addIndex; col += 1){
			var cell = null;
			if(options.length > 1 && col == addIndex - 1){
				cell = tds[col].getElementsByTagName("select")[0];
			}else{
				cell = tds[col].getElementsByTagName("input")[0];
			}
			cell.disabled = true;
			anode.checked = false;
		}
	}
	
	for(var row = 0; row < updates.length; row += 1){
		var unode = updates[row];
		if(!unode.checked){
			continue;
		}
		
		var tr = unode.parentNode.parentNode;
		
		var tds = tr.getElementsByTagName("td");
		for(var col = 0; col < addIndex; col += 1){
			var cell = null;
			if(options.length > 1 && col == addIndex - 1){
				cell = tds[col].getElementsByTagName("select")[0];
			}else{
				cell = tds[col].getElementsByTagName("input")[0];
			}
			cell.disabled = true;
			unode.checked = false;
		}
	}
	
	for(var row = deletes.length - 1; row >= 0; row -= 1){
		
		var dnode = deletes[row];
		
		if(!dnode.checked){
			continue;
		}
	
		dataTable.removeChild(dnode.parentNode.parentNode);
	}

	
}



function check(e){
	var tr = e.parentNode.parentNode;
	var deletenode = null;
	var updatenode = null;
	var inputs = tr.getElementsByTagName("input");
	
	
	if(options.length > 1){
		 deletenode = tr.getElementsByTagName("input")[addIndex];
		 updatenode = tr.getElementsByTagName("input")[addIndex+1];
		 selectnode = tr.getElementsByTagName("select")[0];
		 if(e.checked){
			 if(e.name == "update"){
				 for(var i = 1;i < addIndex-1;i++){
						inputs[i].disabled = false;
					}
					selectnode.disabled = false;
					
			 }
			 if(e.name == "delete"){
				 for(var j = 1;j < addIndex-1;j++){
						inputs[j].disabled = true;
					}
					selectnode.disabled = true;
			 }
			 
				if(e.name == "delete" && updatenode.checked){
					updatenode.checked = false;
				}
				
				if(e.name == "update" && deletenode.checked){	
					deletenode.checked = false;
				}
			
			}
		 if(updatenode.checked == false){
			 for(var i = 1;i < addIndex-1;i++){
					inputs[i].disabled = true;
				}
				selectnode.disabled = true;
		 }
	}else{
		deletenode = tr.getElementsByTagName("input")[addIndex+1];
		updatenode = tr.getElementsByTagName("input")[addIndex+2];
		 if(e.checked){
			 if(e.name == "update"){
				 for(var i = 1;i < addIndex;i++){
						inputs[i].disabled = false;
					}
					
					
			 }
			 if(e.name == "delete"){
				 for(var j = 1;j < addIndex;j++){
						inputs[j].disabled = true;
					}
					selectnode.disabled = true;
			 }
			 
				if(e.name == "delete" && updatenode.checked){
					updatenode.checked = false;
				}
				
				if(e.name == "update" && deletenode.checked){	
					deletenode.checked = false;
				}
			
			}
		 if(updatenode.checked == false){
			 for(var i = 1;i < addIndex;i++){
					inputs[i].disabled = true;
				}
				selectnode.disabled = true;
		 }
	}
	
	
}


function addrow(){
	var tr = document.createElement("tr");
	for(var col = 0; col < cols; col+=1){
		var td = document.createElement("td");
		td.setAttribute("align", "center");
		if(options.length > 1 && col == addIndex - 1){
			var select = document.createElement("select");
			select.setAttribute("name", columnNames[col]);
			for(var i = 0; i < options.length; i+=1){
				var option = document.createElement("option");
				option.setAttribute("value", options[i][optionNames[0]]);
				option.innerHTML = options[i][optionNames[1]];
				select.appendChild(option);
			}
			td.appendChild(select);
			tr.appendChild(td);
		}else{
			var input = document.createElement("input");
			input.setAttribute("name", columnNames[col]);
			if(col < addIndex){
				input.setAttribute("type", "text");
			}else{
				input.setAttribute("type", "checkbox");
				if(col == addIndex){
					
					input.setAttribute("checked", true);
					input.setAttribute("disabled", true);
				}else{
					input.setAttribute("onclick", "check(this);");
				}
			}
			td.appendChild(input);
			tr.appendChild(td);
		}
	}
	dataTable.appendChild(tr);
}

	function clearTable(){
		if(dataTable != null){
			var children = dataTable.getElementsByTagName("tr");
			for(var i = children.length-1; i >= 0; i--){
				dataTable.removeChild(children[i]);
			}
		}
	}
	
function save(){
		var jsontext = "[";
		var trs = dataTable.getElementsByTagName("tr");
		var rows = trs.length;
		
		for(var row = 1; row < rows; row += 1){
			var tr = trs[row];
			var anode = null;
			var dnode = null;
			var unode = null;
			var opercode = 0;
			
			if(options.length > 1){
				var cells = tr.getElementsByTagName("input");
				anode = cells[addIndex - 1];
				dnode = cells[addIndex];
				unode = cells[addIndex + 1];
			}else{
				var cells = tr.getElementsByTagName("input");
				anode = cells[addIndex];
				dnode = cells[addIndex + 1];
				unode = cells[addIndex + 2];
			}
			
			if(!(anode.checked || dnode.checked || unode.checked)){
				continue;
			}
			
			if(anode.checked){
				opercode = 10;
			}else if(dnode.checked){
				opercode = 20;
			}else if(unode.checked){
				opercode = 30;
			}
			
			var tds = tr.getElementsByTagName("td");
			jsontext += "{";
			for(var col = 0; col < addIndex; col += 1){
				
						
				var dcell = null;
				if(options.length > 1 && col == addIndex - 1){
					dcell = tds[col].getElementsByTagName("select")[0];
				}else{
					dcell = tds[col].getElementsByTagName("input")[0];
				}
				jsontext += "\"" + dcell.name + "\":\"" + dcell.value + "\","; 
			}
			jsontext += "\"opercode\":" + opercode + "},";
		}
		jsontext = jsontext.substring(0, jsontext.length - 1) + "]";
		alert(jsontext);
		sendRequest(tid, "edit", jsontext);
	}

/*
function sendRequest(id, oper, msg){
	var url = "http://localhost:8080/54/demoServlet";
	tid = id;
	url = url + "?id=" + id + "&oper=" + oper;
	if(msg == null){
		inited = false;
	}
	xmlHttp.open("POST", url, true);
	xmlHttp.send(msg);
}

function status_change(){
	if(xmlHttp.status == 200){
		if(xmlHttp.statusText == 4){
			if(inited){
				freshTable();
				alert(xmlHttp.responseText);
			}else{
				clearTable();
				initialTable();
				inited = true;
			}
		}
	}
}
*/

function hiden_menu(id){
	
	var menu = document.getElementById(id);
	if(menu.style.display == "none"){
		menu.style.display = "block";
	}else{
		menu.style.display = "none";
	}
	
	 
}
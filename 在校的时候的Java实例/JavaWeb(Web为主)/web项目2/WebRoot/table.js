
var tid = null;
var xmlHttp = null;
var dataTable = null;
var cols = 0;
var addIndex = 0;
var options = null;
var optionNames = null;
var columnNames = null;
var inited = false;

function initialXMLHttpRequest(id){
	xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange=status_change;
	dataTable = document.getElementById(id);
}

function sendRequest(id, oper, msg){
	var url = "http://localhost:8080/54/demoServlet";
	tid = id;
	url = url + "?id=" + id + "&oper=" + oper;
	
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
function initialTable(){
	clearTable();
	var jsonobj = JSON.parse(xmlHttp.responseText);
	columnNames = jsonobj.columnNames;
	var titles = jsonobj.titles;
	var datas = jsonobj.datas;
	options = jsonobj.options;
	optionNames = jsonobj.optionNames;
	cols = columnNames.length;
	addIndex = cols - 3;
	
	var tr = document.createElement("tr");
	for(var col = 0; col < cols; col+=1){
		var th = document.createElement("th");
		th.setAttribute("align", "center");
		th.innerHTML = titles[col];
		tr.appendChild(th);
	}
	dataTable.appendChild(tr);
	
	for(var row = 0; row < datas.length; row+=1){
		tr = document.createElement("tr");
		for(var col = 0; col < cols; col+=1){
			var td = document.createElement("td");
			td.setAttribute("align", "center");
			if(options.length > 1 && col == addIndex - 1){
				var select = document.createElement("select");
				select.setAttribute("name", columnNames[col]);
				for(var i = 0; i < options.length; i+=1){
					var option = document.createElement("option");
					option.value = options[i][optionNames[0]];
					option.innerHTML = options[i][optionNames[1]];
					select.appendChild(option);
				}
				select.value = datas[row][columNames[col]];
				select.disabled = true;
				td.appendChild(select);
			}else{
				var input = document.createElement("input");
				input.setAttribute("name", columnNames[col]);
				if(col < addIndex){
					input.setAttribute("type", "text");
					input.setAttribute("value", datas[row][columnNames[col]]);
					input.disabled = true;
				}else{
					input.setAttribute("type", "checkbox");
					if(col == addIndex){
						input.setAttribute("disabled", true);
					}else{
						input.setAttribute("onclick", "check(this);");
					}
				}
				td.appendChild(input);
			}
			tr.appendChild(td);
		}
		dataTable.appendChild(tr);
	}
}
function saveRecords(){
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
		}else if(opercode){
			opercode = 30;
		}
		
		var tds = tr.getElementsByTagName("td");
		for(var col = 0; col < addIndex; col += 1){
			jsontext += "{";
					
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
	
	sendRequest(tid, "edit", jsontext);
}

function status_change(){
	if(xmlHttp.status == 200){
		if(xmlHttp.statusText == 4){
			
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
			cell.disabled = false;
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
			cell.disabled = false;
			anode.checked = false;
		}
	}
	
	for(var row = deletes.length - 1; row >= 0; row -= 1){
		var dnode = delets[row];
		if(!dnode.checked){
			continue;
		}
		dataTable.removeChild(dnode.parentNode.parentNode);
	}
}

function initialTable(){
	clearTable();
	var jsonobj = JSON.parse(xmlHttp.responseText);
	columnNames = jsonobj.columnNames;
	var titles = jsonobj.titles;
	var datas = jsonobj.datas;
	options = jsonobj.options;
	optionNames = jsonobj.optionNames;
	cols = columnNames.length;
	addIndex = cols - 3;
	
	var tr = document.createElement("tr");
	for(var col = 0; col < cols; col++){
		var th = document.createElement("th");
		th.setAttribute("align", "center");
		th.innerHTML = titles[col];
		tr.appendChild(th);
	}
	dataTable.appendChild(tr);
	
	for(var row = 0; row < datas.length; row++){
		tr = document.createElement("tr");
		for(var col = 0; col < cols; col++){
			var td = document.createElement("td");
			td.setAttribute("align", "center");
			if(options.length > 1 && col == addIndex - 1){
				var select = document.createElement("select");
				select.setAttribute("name", columnNames[col]);
				for(var i = 0; i < options.length; i++){
					var option = document.createElement("option");
					option.value = options[i][optionNames[0]];
					option.innerHTML = options[i][optionNames[1]];
					select.appendChild(option);
				}
				select.value = datas[row][columNames[col]];
				select.disabled = true;
				td.appendChild(select);
			}else{
				var input = document.createElement("input");
				input.setAttribute("name", columnNames[col]);
				if(col < addIndex){
					input.setAttribute("type", "text");
					input.setAttribute("value", datas[row][columnNames[col]]);
					input.disabled = true;
				}else{
					input.setAttribute("type", "checkbox");
					if(col == addIndex){
						input.setAttribute("disabled", true);
					}else{
						input.setAttribute("onclick", "check(this);");
					}
				}
				td.appendChild(input);
			}
			
			tr.appendChild(td);
		}
		dataTable.appendChild(tr);
	}
	
}
function check(e){
	var tr = e.parentNode.parentNode;
	var dnode = null;
	var unode = null;
	if(options.length > 1){
		dnode = tr.getElementsByTagName("input")[addIndex];
		unode = tr.getElementsByTagName("input")[addIndex + 1];
	}else{
		dnode = tr.getElementsByTagName("input")[addIndex + 1];
		unode = tr.getElementsByTagName("input")[addIndex + 2];
	}
	if(e.checked){
		if(e.name == "delete" && unode.checked){
			unode.checked = false;
		}else if(e.name == "update" && dnode.checked){
			dnode.checked = false;
		}
	}
}

function clearTable(){
	if(dataTable != null){
		var children = dataTable.getElementsByTagName("tr");
		for(var i = children.length - 1; i >= 0; i--){
			dataTable.removeChild(children[i]);
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
			for(var i=0; i<options.length; i+=1){
				var option = document.createElement("option");
				option.setAttribute("value", options[col][optionNames[1]]);
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
	



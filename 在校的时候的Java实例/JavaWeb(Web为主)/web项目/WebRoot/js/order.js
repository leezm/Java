	var teachers;
	var examrooms;
	var tcolNames;
	var dataTable;
	var newarray = new Array();
	function timedCount()
	{	
		
		var len = teachers.length;
		
		var old = new Array();
		
		for(var j = 0;j < len;j++){
			old[j] = teachers[j]["teacher_id"];
			
		}
		
  		
  		var n = null;
  		var inputs = document.getElementsByName("i");
  		var lenth = inputs.length;
  		
  		for(var i = 0 ;i < lenth;i++){
  			n = parseInt(Math.random()*old.length);
  			
  			newarray[i] = old[n];
  			inputs[i].value = old[n]+teachers[n]["teacher_name"];
  			removeElement(n,old);
  			
  			
  		}
  		document.getElementById("start").disabled = true;
  		document.getElementById("stop").disabled = false;
  		t=setTimeout("timedCount()",100);
  		
  		
  		
	}
	
	function removeElement(index,array){
		for(var i = index;i < array.length;i++){
			array[i] = array[i+1];
		}
		array.length = array.length-1;
		return array;
	}
	function stopCount()
	{	
		document.getElementById("stop").disabled = true;
  		document.getElementById("start").disabled = false;
		clearTimeout(t);
		
	}
	
	
		
	
	function initialXMLHttpRequest(id){
		xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange=status_change;
		dataTable = document.getElementById(id);
		sendRequest();

	}

	
	function sendRequest(){
		
		var url = "http://localhost:8080/523-24/ControlServlet";
		xmlHttp.open("POST", url, true);
		xmlHttp.onreadystatechange = status_change;
		xmlHttp.send(null);
		
	}


	function status_change(){
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){
				alert(xmlHttp.responseText);
				var jsonobj = JSON.parse(xmlHttp.responseText);
				 teachers = jsonobj.teachers;
				
				 examrooms = jsonobj.examrooms;
			
				clearTable();
				var text = examrooms.length;
				if(text >= 5){
					var k = parseInt(text/5);
					
				for(var i = 0;i < k;i++){
				
					var otr = document.createElement("tr");
				var othfirst = document.createElement("th");
				othfirst.innerHTML = "考场名称";
				othfirst.setAttribute("align","center");
				otr.appendChild(othfirst);
				
				for(var col = 0; col < 5; col += 1){
					var oth = document.createElement("th");
					oth.innerHTML = examrooms[col]["examroom_name"];
					oth.setAttribute("align","center");
					otr.appendChild(oth);
				}
				
				dataTable.appendChild(otr);
				
				for(var i = 0;i < 2;i++){
					var tr = document.createElement("tr");
					var oth = document.createElement("th");
					if(i == 0){
						oth.innerHTML = "组长";
					}else{
						oth.innerHTML = "副组长";
					}
					oth.setAttribute("align","center");
					tr.appendChild(oth);
					for(var j = 0; j < 5; j++){
						var td = document.createElement("td");
						var oinput = document.createElement("input");
						oinput.setAttribute("align","center");
						oinput.setAttribute("name","i");
						oinput.setAttribute("disabled", true);
						td.appendChild(oinput);
						tr.appendChild(td);
					}
					dataTable.appendChild(tr);
				}	
				}
				}
			}		
			
			var cols = text-parseInt(text/5)*5;
			var otr = document.createElement("tr");
			if(cols > 0){
				var othfirst = document.createElement("th");
				othfirst.innerHTML = "考场名称";
				othfirst.setAttribute("align","center");
				otr.appendChild(othfirst);
				
				for(var col = 0; col < cols; col += 1){
					var oth = document.createElement("th");
					oth.innerHTML = examrooms[col+parseInt(text/5)*5]["examroom_name"];
					oth.setAttribute("align","center");
					otr.appendChild(oth);
				}
				
				dataTable.appendChild(otr);
				
				for(var i = 0;i < 2;i++){
					var tr = document.createElement("tr");
					var oth = document.createElement("th");
					if(i == 0){
						oth.innerHTML = "组长";
					}else{
						oth.innerHTML = "副组长";
					}
					oth.setAttribute("align","center");
					tr.appendChild(oth);
					for(var j = 0; j < cols; j++){
						var td = document.createElement("td");
						var oinput = document.createElement("input");
						oinput.setAttribute("align","center");
						oinput.setAttribute("name","i");
						oinput.setAttribute("disabled", true);
						td.appendChild(oinput);
						tr.appendChild(td);
					}
					dataTable.appendChild(tr);
				}	
				}
			
		}	
		
	}
	function clearTable(){
		if(dataTable != null){
			var children = dataTable.getElementsByTagName("tr");
			for(var i = children.length-1; i >= 0; i--){
				dataTable.removeChild(children[i]);
			}
		}
	}
	/*function save(){
		alert("in");
		var jsontext = "[";
		var trs = dataTable.getElementsByTagName("tr");
		for(var j = 0;j <2;j++){
			var tr = trs[j+1];
			var tds = tr.getElementsByTagName("td");
			var date = 2015;
			alert("in2");
			for(var i = 0;i < 5;i++){
				var dcell = null;
				alert("in3");
				dcell = tds[i].getElementsByTagName("input")[0];
				jsontext += "\"" + "examroom_id" + "\":\"" + examroom[i]["examroom_id"] + "\","; 
				jsontext += "\"" + "teacher_id" + "\":\"" + dcell.value + "\","; 
				
				jsontext += "\"date\":" + date + "},";
			}
		}
		jsontext = jsontext.substring(0, jsontext.length - 1) + "]";
		alert(jsontext);
		sendRequest(jsontext);
	}
	*/
	function show2(){
		
		
		
		var jsontext = "[";
		
		
		for(var i = 0;i < examrooms.length;i++){
			
			var myDate = new Date();
			var date = myDate.getFullYear()+"/"+(myDate.getMonth()+1)+"/"+(myDate.getDay()+1);
			var j = parseInt(i/5);
			alert(j);
			jsontext += "{";
			jsontext += "\"" + "examroom_id" + "\":\"" + examrooms[i]["examroom_id"] + "\","; 
			jsontext += "\"" + "teacher_id" + "\":\"" + newarray[i+j*5] + "\","; 
			
			jsontext += "\"date\":\"" + date + "\"},";
			
		}
		for(var i = 0;i < examrooms.length;i++){
			
			var myDate = new Date();
			var date = myDate.getFullYear()+"/"+(myDate.getMonth()+1)+"/"+(myDate.getDay()+1);
			var j = parseInt(i/5);
			if(i < 5){
				j = 1;
			}
			jsontext += "{";
			jsontext += "\"" + "examroom_id" + "\":\"" + examrooms[i]["examroom_id"] + "\","; 
			jsontext += "\"" + "teacher_id" + "\":\"" + newarray[i+j*5] + "\","; 
			alert(newarray[i+5*j]);
			jsontext += "\"date\":\"" + date + "\"},";
			
		}
			
			
	
		jsontext = jsontext.substring(0, jsontext.length - 1) + "]";
		alert(jsontext);
		sendRequest2(jsontext);
	}

	

	
	function sendRequest2(jsontext){
		xmlHttp2 = new XMLHttpRequest();
		
		var url = "http://localhost:8080/523-24/ExTeServlet";
		xmlHttp2.open("POST", url, true);
		xmlHttp2.onreadystatechange = success;
		xmlHttp2.send(jsontext);
		
	}
	function success(){
		if(xmlHttp2.readyState == 4){
			if(xmlHttp2.status == 200){
				alert(xmlHttp2.responseText);
				
			}
		}
	}
		
	
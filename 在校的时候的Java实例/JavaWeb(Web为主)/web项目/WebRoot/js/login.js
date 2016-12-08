function check(){
	
	 var user = document.getElementById('user').value;
	 var pwd = document.getElementById('pwd').value;
	if(user == ""){
		alert("用户名不能为空！");return false;
	}else if (pwd == ""){
		
		alert("密码不能为空！");return false;
	}else{
		return true;
	}
}



	
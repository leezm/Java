function check(){
	
	 var user = document.getElementById('user').value;
	 var pwd = document.getElementById('pwd').value;
	if(user == ""){
		alert("�û�������Ϊ�գ�");return false;
	}else if (pwd == ""){
		
		alert("���벻��Ϊ�գ�");return false;
	}else{
		return true;
	}
}



	
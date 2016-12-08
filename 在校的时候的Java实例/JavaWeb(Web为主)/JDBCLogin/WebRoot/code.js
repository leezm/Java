var code ;   

function createCode(){       
	code = "";      
	var codeLength = 4;
	var checkCode = document.getElementById("checkCode");      
	checkCode.value = "";      
	var selectChar = new Array(1,2,3,4,5,6,7,8,9,
							   'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t'
							   ,'u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L',
							   'M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
	      
	for(var i=0;i<codeLength;i++) {      
	   var charIndex = Math.floor(Math.random()*60);      
	  code +=selectChar[charIndex];      
	}      
	if(code.length != codeLength){      
	  createCode();      
	}   
	
	checkCode.value = code;      
}      
      
     
function validate () {      
	var inputCode = document.getElementById("input1").value.toUpperCase();      
	var codeToUp=code.toUpperCase();  
	
	if(inputCode.length <=0) {      
	  alert("��������֤�룡");  
	  
	  return false;      
	}      
	else if(inputCode != codeToUp ){      
	   alert("�������֤������");      
	   createCode();      
	   return false;      
	}      
	else {      
	  alert("��ȷ��");      
	  return true;      
	}      
      
}
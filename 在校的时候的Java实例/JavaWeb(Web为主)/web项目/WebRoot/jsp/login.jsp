<%@ page language="java" import="java.util.*,com.domain.User" pageEncoding="GB18030"%>
<script>
      var code ; //��ȫ�� ������֤��
      function createCode()
      { 
        code = "";
        var codeLength = 6;//��֤��ĳ���
        var checkCode = document.getElementById("checkCode");
        var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//���к�ѡ�����֤����ַ�����ȻҲ���������ĵ�
         
        for(var i=0;i<codeLength;i++)
        {
       
         
        var charIndex = Math.floor(Math.random()*36);
        code +=selectChar[charIndex];
        
        
        }
 //       alert(code);
        if(checkCode)
        {
          checkCode.className="code";
          checkCode.value = code;
        }
        
      }
      
function check(){
	 var user = document.getElementById('user').value;
	 var pwd = document.getElementById('pwd').value;
	 var inputCode = document.getElementById("input1").value;
          
	if(user == ""){
		alert("�û�������Ϊ�գ�");return false;
	}else if (pwd == ""){
		
		alert("���벻��Ϊ�գ�");return false;
	}else if(inputCode.length <=0)
           {
               alert("��������֤�룡");
               return false;
           }
           else if(inputCode != code )
           {
              alert("��֤���������");
              createCode();//ˢ����֤��
              return false;
           }else{
           		return true;
           }
		
}
</script>
 <center>
 	
  
   <form action="LoginServlet" onsubmit="" method="post" id="form">
  	<table align="center" name="logintable" border="0">
  		<caption>�û���¼</caption>
  		<tr>
  		<td>�û���</td>
  		<td><input  type="text" id="user" name="username" ></td>
  		</tr>
  		<tr>
  		<td>����</td>
  		<td><input  type="password" id="pwd" name="pwd"></td>
  		</tr>
  		<tr>
  		<td>��ɫ</td>
  		<td><select name="select" size="1"><option value="0">����Ա</option><option value="1">��λԱ</option><option value="2">ѧ��</option></select></td>
  		</tr>
  		<td>��֤��</td>
  		<td><input  type="text"  onclick="createCode()" id="input1" /></td>
     	<td><input type="text"  id="checkCode" class="unchanged" style="width: 80px"/></td>
  	</table>
   
   	<input name="Button" type="submit" class="btn_grey" value="��¼">
   	<input name="Reset" type="reset" class="btn_grey" value="����">
   	
   	  
   </form> 
 </center>
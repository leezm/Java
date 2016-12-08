<%@ page language="java" import="java.util.*,com.domain.User" pageEncoding="GB18030"%>
<script>
      var code ; //在全局 定义验证码
      function createCode()
      { 
        code = "";
        var codeLength = 6;//验证码的长度
        var checkCode = document.getElementById("checkCode");
        var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的
         
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
		alert("用户名不能为空！");return false;
	}else if (pwd == ""){
		
		alert("密码不能为空！");return false;
	}else if(inputCode.length <=0)
           {
               alert("请输入验证码！");
               return false;
           }
           else if(inputCode != code )
           {
              alert("验证码输入错误！");
              createCode();//刷新验证码
              return false;
           }else{
           		return true;
           }
		
}
</script>
 <center>
 	
  
   <form action="LoginServlet" onsubmit="" method="post" id="form">
  	<table align="center" name="logintable" border="0">
  		<caption>用户登录</caption>
  		<tr>
  		<td>用户名</td>
  		<td><input  type="text" id="user" name="username" ></td>
  		</tr>
  		<tr>
  		<td>密码</td>
  		<td><input  type="password" id="pwd" name="pwd"></td>
  		</tr>
  		<tr>
  		<td>角色</td>
  		<td><select name="select" size="1"><option value="0">管理员</option><option value="1">派位员</option><option value="2">学生</option></select></td>
  		</tr>
  		<td>验证码</td>
  		<td><input  type="text"  onclick="createCode()" id="input1" /></td>
     	<td><input type="text"  id="checkCode" class="unchanged" style="width: 80px"/></td>
  	</table>
   
   	<input name="Button" type="submit" class="btn_grey" value="登录">
   	<input name="Reset" type="reset" class="btn_grey" value="重置">
   	
   	  
   </form> 
 </center>
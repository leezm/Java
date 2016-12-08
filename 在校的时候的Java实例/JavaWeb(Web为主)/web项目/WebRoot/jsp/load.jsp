<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
 <form action="LoadTable" enctype="multipart/form-data" method="post">
 	<table align="center" border="0">
 	<tr>
 	<td>
 	上传数据表
 	</td>
 	<td>
 	  <select size="1"><option value="0">角色表</option><option value="1">用户表</option><option value="3">教师等级表</option><option value="4">教师表</option><option value="5">考题表</option></select>
 	</td>
 	</tr>
      <tr>
      <td>
      	上传文件
      </td>
      <td>
       <input type="file" name="file1"><br/>
      </td>
      </tr>
       <tr>
       <td>
       <input type="submit" value="提交">
       </td>
       </tr>
        
        
        
        </table>
    </form>
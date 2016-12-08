<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<ul>
  				<li onclick="hiden_menu('edit')">编辑信息</li>
  					<ul id="edit">
  						<li id="user" onclick="request(this)">编辑用户信息</li>
  						<li id="teacher" onclick="request(this)">编辑教师信息</li>
  						<li id="examroom" onclick="request(this)">编辑考场信息</li>
  						<li id="question" onclick="request(this)">编辑考题信息</li>
  						<li id="role" onclick="request(this)">编辑角色信息</li>
  						<li id="grade" onclick="request(this)">编辑教师等级信息</li>
  					</ul>
  				
  				<li  onclick="hiden_menu('search')">查询信息</li>
  					<ul id="search">
  						<li id="user" onclick="request(this)">查询用户信息</li>
  						<li id="teacher" onclick="request(this)">查询教师信息</li>
  						<li id="examroom" onclick="request(this)">查询考场信息</li>
  						
  					</ul>
  				
  				<li onclick="hiden_menu('file')">文件处理</li>
  					<ul id="file">
  						<li><a href="jsp/loadtable.jsp">上传文件</a></li>
  						<li><a href="ListFileServlet">下载文件</a></li>
  						
  						
  					</ul>
  				
  				
</ul>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<ul>
  				<li onclick="hiden_menu('edit')">�༭��Ϣ</li>
  					<ul id="edit">
  						<li id="user" onclick="request(this)">�༭�û���Ϣ</li>
  						<li id="teacher" onclick="request(this)">�༭��ʦ��Ϣ</li>
  						<li id="examroom" onclick="request(this)">�༭������Ϣ</li>
  						<li id="question" onclick="request(this)">�༭������Ϣ</li>
  						<li id="role" onclick="request(this)">�༭��ɫ��Ϣ</li>
  						<li id="grade" onclick="request(this)">�༭��ʦ�ȼ���Ϣ</li>
  					</ul>
  				
  				<li  onclick="hiden_menu('search')">��ѯ��Ϣ</li>
  					<ul id="search">
  						<li id="user" onclick="request(this)">��ѯ�û���Ϣ</li>
  						<li id="teacher" onclick="request(this)">��ѯ��ʦ��Ϣ</li>
  						<li id="examroom" onclick="request(this)">��ѯ������Ϣ</li>
  						
  					</ul>
  				
  				<li onclick="hiden_menu('file')">�ļ�����</li>
  					<ul id="file">
  						<li><a href="jsp/loadtable.jsp">�ϴ��ļ�</a></li>
  						<li><a href="ListFileServlet">�����ļ�</a></li>
  						
  						
  					</ul>
  				
  				
</ul>
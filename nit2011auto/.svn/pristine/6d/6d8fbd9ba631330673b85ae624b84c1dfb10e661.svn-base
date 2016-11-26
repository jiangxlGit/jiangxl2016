<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8" />
		<title>欢迎录入</title>
		<link type="text/css" rel="stylesheet" href="<%=path%>/recorded/css/recorded.css" />
	</head>

	<body>
	
		<form action="<%=path%>/recorded/recorded.jsp" method="post">
			<div class="form">
				<div id="recorded-content">
					<div id="recorded">录入个人信息</div>
					<div class="fix"></div>
					<div class="inp"><input type="text" placeholder="请输入用户名" /></div>
					<div class="inp"><input type="text" placeholder="请输入家庭地址" /></div>
					<div class="inp"><input type="text" placeholder="请输入工作地址" /></div>
					<div class="inp"><input type="text" placeholder="电话号码" /></div>
					<div id="toRecorded" class="toRecorded"><strong>立即录入</strong></div>
				</div>
			</div>
		</form>
		
		<script src="<%=path%>/common/js/jquery-2.2.4.min.js"></script>
		<script>
			$(document).ready(function() {
				
				$("#toRecorded").bind('click',function(){
					doRecorded(this);
				});
				 //回车提交事件
				$("body").keydown(function() {
				    if (event.keyCode == "13") {//keyCode=13是回车键
				        doRecorded($("#toRecorded"));
				        $("#toRecorded").submit();
				    }
				});
				
			});
			
			function doRecorded(obj){
				alert("录入成功");
			}
			
		</script>
		
	</body>

</html>
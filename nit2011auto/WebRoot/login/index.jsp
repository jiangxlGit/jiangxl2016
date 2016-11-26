<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8" />
		<title>欢迎登录</title>
		<link type="text/css" rel="stylesheet" href="<%=path%>/login/css/index.css" />
	</head>

	<body>
	
		<form id="toLogin" action="<%=path%>/recorded/recorded.jsp" method="post">
			<div class="form">
				<div id="landing">登陆</div>
				<div id="registered">注册</div>
				<div class="fix"></div>
				<div id="landing-content">
					<div id="photo"><img src="img/photo.jpg" /></div>
					<div class="inp"><input id="username" type="text" placeholder="用户名" /></div>
					<div class="inp"><input id="password" type="password" placeholder="密码" /></div>
					<div id="login" class="login"><strong>登  录</strong></div>
					<div id="bottom"><span id="registeredtxt">立即注册</span><span id="forgotpassword">忘记密码</span></div>
				</div>
				<div id="registered-content">
					<div class="inp"><input type="text" placeholder="请输入用户名" /></div>
					<div class="inp"><input type="password" placeholder="请输入密码" /></div>
					<div class="inp"><input type="password" placeholder="请再次输入密码" /></div>
					<div class="inp"><input type="text" placeholder="电子邮箱" /></div>
					<div class="login"><strong>立即注册</strong></div>
				</div>
			</div>
		</form>
		
		<script src="<%=path%>/common/js/jquery-2.2.4.min.js"></script>
		<script>
			$(document).ready(function() {
				
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered").click(function() {
					$("#landing").removeClass("border-btn");
					$("#landing-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$(this).addClass("border-btn");
					
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
				})
				
				 //回车提交事件
				$("body").keydown(function() {
				    if (event.keyCode == "13") {//keyCode=13是回车键
				        $("#toLogin").submit();
				    }
				});  
				
				$("#login").bind('click',function(){
					dologin(this);
				});
				
			});
			
			function dologin(obj){
				
				var username = $("#username").val();
				var password = $("#password").val();
				
				$.ajax({
					
					type:"post",
					async:false,
					url:"/nit2011auto/login.do?method=loginToInputData",
					data:{
						"username":username,
						"password":password
						},
					
					success:function(result){
						if(result == "true"){
							showLoading(true);
					        $("#toLogin").submit();
						} else {
							alert("登录失败");
						}
					},
					error:function(e){
						alert("登录失败!");
					}
				})
				
			}
			
			function showLoading(flag){
				if(flag){
					$('#login').html('<strong>登录中</strong>');
					
				}else{
					$('#login').html('<strong>登    录</strong>');
				}
			}
			
		</script>
		
	</body>

</html>
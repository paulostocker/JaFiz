<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import" href="header.html">
<script type="text/javascript">
function logintest(){
	$.get("Usuario&ind=1", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
     	alert(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
  	});
}
</script>
</head>
<body>
		<form class="login" id="loginForm" action="Usuario&id=3" method="post" style="text-align:center;margin-top:10%;height:400px;">
			<div class="intro">J·Fiz!</div>
			<font class="intro" style="font-size:28px;">Suas tarefas sempre organizadas</font>
			<br><br>

			<i class="fa fa-envelope-o" aria-hidden="true" style="width:15px"></i>
			<input class="form-control" placeholder="E-mail" type="text" id="login" name="email" value="${param.email}" required/><br>
			<div id="loginerror" style="display:none">Email ou Senha incorretos!</div>
			
			<div style="border-right: 8px solid #6BB9F0;" data-toggle="tooltip" title="" data-placement="right" id="ficha_151" data-original-title="Aguardando Preenchimento">
				<i class="fa fa-lock" aria-hidden="true" style="width:15px"></i>
				<input class="form-control" placeholder="Senha" type="password" id="pass" name="pass" required/><br>
			</div>
			<div class="tooltip"></div>
			
			<button type="submit" class="btn btn-sm btn-success">Entrar</button>
			<a href="cadastrar.html" class="btn btn-sm btn-primary">Cadastrar</a>
			<input type="button" onclick="logintest();" value="check login"/>
		</form>
</body>
</html>
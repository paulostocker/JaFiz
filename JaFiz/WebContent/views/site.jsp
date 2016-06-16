<%@ page import="java.util.List" %>
<%@ page import="br.com.jafiz.models.Atividade" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="import" href="./header.html">
</head>
<script type="text/javascript">
function change(obj, url){
	$('.active').attr('class','');
	obj.attr('class','active');
	$('#telas').attr('src',url);
	
}
</script>

<body><!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" id="intro" style="font-size:42px;color:#FFF" href="#">JáFiz!</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active" onclick="change($(this),'Atividade?ind=5');"><a>Atividades</a></li>
            <li onclick="change($(this),'Atividade?ind=1');"><a>Cadastrar Atividade</a></li>
            <li onclick="change($(this),'Usuario?ind=5');"><a>Usuários</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Atividades <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li onclick="change($(this),'Atividade?ind=1');"><a>Cadastrar Atividade</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
           	<li><a href="UserLogout"><i class="fa fa-user" aria-hidden="true" style="font-size:18px"></i> Perfil</a></li>
           	<li><a href="Usuario?ind=9"><i class="fa fa-power-off" aria-hidden="true" style="font-size:18px"></i> Sair</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <br><br><br>
    <div>
		<iframe id="telas" width="100%" height="900" style="border:0;" src="Atividade?ind=5"></iframe>
    </div>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="br.com.jafiz.models.Usuario" %>
<%@ page import="br.com.jafiz.controllers.UsuarioController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import" href="./header.html">
</head>
<body>

		<form class="login" action="Atividade" method="post" style="text-align:center;margin-top:5%;height:400px;">
			<input type="hidden" name="ind" value="1"/>
			<br><br>
			
			<i class="fa fa-user" aria-hidden="true" style="width:15px"></i>
			<select class="form-control" name="cdn_usuario">
			<option value>Selecionar Usuário</option>
<% 
Usuario usu = new Usuario();
UsuarioController c_usu = new UsuarioController();
//allUsers
List<Usuario> listaUsuario = c_usu.allUsers(usu);

for(Usuario u:listaUsuario){
%>
<option value="<%=u.getId()%>"> <%=u.getNome() %></option>
<%
}
%>	</select>
	<br>
				
			<i class="fa fa-bars" aria-hidden="true" style="width:15px"></i>
			<input class="form-control" placeholder="Nome da Atividade" type="text" name="nom_atividade" required/><br>
			
			<i class="fa fa-clock-o" aria-hidden="true" style="width:15px"></i>
			<input class="form-control" placeholder="Tempo Estimado" type="text" name="qtd_tempo_estipulado" required/><br>
			
			<i class="fa fa-bars" aria-hidden="true" style="width:15px"></i>
			<textarea rows="5" cols="10" class="form-control" placeholder="Descrição da Atividade" name="des_atividade" required></textarea>
			<div class="tooltip"></div><br>
			
			<button type="submit" class="btn btn-sm btn-success">Cadastrar</button>
		</form>
</body>
</html>
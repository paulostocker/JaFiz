<%@ page import="java.util.List" %>
<%@ page import="br.com.jafiz.models.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import" href="header.html">
</head>
<body>

<table class="table table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>Nome</th>
      <th>Email</th>
      <th>Data de Nascimento</th>
    </tr>
  </thead>
  <tbody>
<br><br>
<% 
List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listall");

for(Usuario u:listaUsuario){
%>
<tr>
   <td><%=u.getId() %></td>
   <td><%=u.getNome() %></td>
   <td><%=u.getEmail() %></td>
   <td><%=u.getDatnsc() %></td>
</tr>
<%
}
%>
  </tbody>
</table>


</body>
</html>
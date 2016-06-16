<%@ page import="java.util.List" %>
<%@ page import="br.com.jafiz.models.Atividade" %>
<%@ page import="br.com.jafiz.controllers.AtividadeController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="import" href="./header.html">
    <script type="text/javascript">
    	function open(url){
    		$('#dialog').attr('src',url);
    		$('#dialog').dialog({width:100,height:100});
    	}
    </script>
</head>
<body>
    <div>
    	<i class="fa fa-user" aria-hidden="true" style="font-size:26px" onclick="open('Atividade?ind=1')"></i>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>#</th>
		      <th>Nome</th>
		      <th>Descrição</th>
		      <th>Tempo Estipulado</th>
		    </tr>
		  </thead>
		  <tbody>
		<% 

        HttpSession ver_session = request.getSession();
		Integer useridE = (Integer) ver_session.getAttribute("id");
		
    	Atividade atv = new Atividade();
    	atv.setCdn_usuario(useridE);
    	AtividadeController c_atv = new AtividadeController();
    	List<Atividade> listaAtividade = c_atv.byUser(atv);
		
		for(Atividade u:listaAtividade){
			

		String x = Integer.toString(u.getQtd_tempo_estipulado());
		Integer cdn_atividade = u.getCdn_atividade();
		while(x.length() < 4){
			x = "0"+x;
		}
		x = x.substring(0, 2) + ":" + x.substring(2, 4);
		%>
		<tr>
		   <td><%=cdn_atividade%></td>
		   <td><%=u.getNom_atividade() %></td>
		   <td><%=u.getDes_atividade() %></td>
		   <td><%=x%></td>
		   <td width="5%"><a href="Atividade?ind=3&cdn_atividade=<%=cdn_atividade%>">
		  <i class="fa fa-times" aria-hidden="true" style="width:15px"></i>
		   </a></td>
		</tr>
		<%
		}
		%>
		  </tbody>
		</table>

    
    </div>
    <iframe id="dialog" src="Atividade?ind=1" style="display:none;"></iframe>
</body>
</html>
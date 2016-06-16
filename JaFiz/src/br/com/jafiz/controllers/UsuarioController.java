package br.com.jafiz.controllers;

import br.com.jafiz.models.Usuario;
import br.com.jafiz.database.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioController {
	private Connection dbcon = DBConnection.getConnection();
	
	public void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
	         System.out.println("NOVO LOGIN --- email: "+email+ " - senha: "+senha);
	      try{
	         PreparedStatement ps = dbcon.prepareStatement("select * from usuario where email=? and senha=md5(?)");
	         ps.setString(1, email);
	         ps.setString(2, senha);
	         ResultSet result = ps.executeQuery();
	         result.next();
	         
	         Integer id = result.getInt("id");
	         String nome = result.getString("nome");
	         System.out.println("NOVO LOGIN --- ID: "+id+ " - NOME: "+nome);

	         HttpSession session = request.getSession();  
	         session.setAttribute("email",email);  
	         session.setAttribute("nome",nome);  
	         session.setAttribute("id",id);  
	         session.setAttribute("login",true);  
			 
	         dbcon.close();
	         
	         RequestDispatcher rs = request.getRequestDispatcher("views/site.jsp");
	         rs.include(request, response);
	      }catch(Exception e)
	      {
	          e.printStackTrace();
	           System.out.println("Erro - "+e.getMessage());
	           System.out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("index.html");
	           rs.include(request, response);
	      }
		
	}
	
	public void Create (Usuario usuario){
        String sql = "INSERT INTO usuario (nome, email, senha, dat_nascimento) VALUES (?, ?, md5(?), date(?))";
        try{
        	
            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getDatnsc());
            
            ps.executeQuery();
            ps.close();
            System.out.println("Usuario cadastrado: "+usuario.getEmail());
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
        	 if(e.getMessage().indexOf("email") > 0)
        		 System.out.println("E-mail já possui cadastrado!");
         }
	}
	
	public void Update (Usuario usuario){
        String sql = "UPDATE USUARIO SET nome = ?, senha = ?, dat_nascimento = ? WHERE id = ?";
        try{
        	
            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getDatnsc());
            ps.setInt(4, usuario.getId());
            
            ps.executeQuery();
            ps.close();
            System.out.println("Alterado com sucesso: "+usuario.getEmail());
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }
	}
	
	public List<Usuario> byPK(Usuario usuario){
		List<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT * FOM USUARIO WHERE id = ?";
        try{

            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
 
			ResultSet result = ps.executeQuery(sql);
			Usuario usu = new Usuario();
			usu.setId(result.getInt("int"));
			usu.setNome(result.getString("nome"));
			usu.setEmail(result.getString("email"));
			usu.setDatnsc(result.getString("dat_nascimento"));
			
			lista.add(usu);
			
            ps.close();
            System.out.println("Informações acessadas com sucesso: "+usuario.getEmail());
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }
        return lista;
	}
			
	public void Delete (Usuario usuario){
        String sql = "DELETE FROM USUARIO WHERE id = ?";
        try{
        	
            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            
            ps.executeQuery();
            ps.close();
            System.out.println("Deletado com sucesso: "+usuario.getEmail());
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }	
	}
	public List<Usuario> allUsers(Usuario usuario){
		String sql = "SELECT * FROM USUARIO";
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement ps = dbcon.prepareStatement(sql);
			ResultSet results = ps.executeQuery();
			while(results.next()){
				Usuario usu = new Usuario();
				usu.setId(results.getInt("id"));
				usu.setNome(results.getString("nome"));
				usu.setEmail(results.getString("email"));
				usu.setDatnsc(results.getString("dat_nascimento"));
				lista.add(usu);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
		}
		return lista;
	}
}

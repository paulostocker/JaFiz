package br.com.jafiz.controllers;


import br.com.jafiz.models.Atividade;
import br.com.jafiz.database.DBConnection;

//import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AtividadeController {


	private Connection dbcon = DBConnection.getConnection();
	private Boolean rt_oper = false;
	
	public Boolean Create (Atividade atividade){
        String sql = "INSERT INTO atividade (cdn_usuario, nom_atividade, qtd_tempo_estipulado, qtd_tempo_realizado, perc_tempo_utilizado, des_atividade, ind_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setInt(1, atividade.getCdn_usuario());
            ps.setString(2, atividade.getNom_atividade());
            ps.setInt(3, atividade.getQtd_tempo_estipulado());
            ps.setInt(4, atividade.getQtd_tempo_realizado());
            ps.setDouble(5, atividade.getPerc_tempo_utilizado());
            ps.setString(6, atividade.getDes_atividade());
            ps.setInt(7, atividade.getInd_status());
            
            ps.executeQuery();
            ps.close();
            System.out.println("Atividade cadastrada: "+atividade.getNom_atividade());
            rt_oper = true;
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }
         return rt_oper;
	}
	
	public Boolean Update (Atividade atividade){
        String sql = "UPDATE atividade SET nom_atividade = ?, des_atividade = ?, qtd_tempo_estipulado = ? WHERE id = ?";
        try{
        	
            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setString(1, atividade.getNom_atividade());
            ps.setString(2, atividade.getDes_atividade());
            ps.setInt(3, atividade.getQtd_tempo_estipulado());
            ps.setInt(4, atividade.getCdn_atividade());
            
            ps.executeQuery();
            ps.close();
            System.out.println("Alterado com sucesso: "+atividade.getNom_atividade());
            rt_oper = true;
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }
        return rt_oper;
	}
			
	public Boolean Delete (Atividade atividade){
        String sql = "DELETE FROM atividade WHERE cdn_atividade = ?";
        try{
        	
            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setInt(1, atividade.getCdn_atividade());
            
            int deleted = ps.executeUpdate();
            ps.close();
            rt_oper = true;
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }	
         return rt_oper;
	}
	
	public List<Atividade> byUser(Atividade atividade){
		List<Atividade> lista = new ArrayList<Atividade>();
        String sql = "SELECT * FROM atividade WHERE cdn_usuario = ?";
        try{

            PreparedStatement ps = dbcon.prepareStatement(sql);
            ps.setInt(1, atividade.getCdn_usuario());
 
			ResultSet results = ps.executeQuery();

			while(results.next()){
				Atividade atv = new Atividade();
				atv.setCdn_atividade(results.getInt("cdn_atividade"));
				atv.setNom_atividade(results.getString("nom_atividade"));
				atv.setDes_atividade(results.getString("des_Atividade"));
				atv.setQtd_tempo_estipulado(results.getInt("qtd_tempo_estipulado"));
				atv.setPerc_tempo_utilizado(results.getDouble("perc_tempo_utilizado"));
				atv.setInd_status(results.getInt("ind_status"));
			
				lista.add(atv);
			}
			
            ps.close();
            System.out.println("Informações acessadas com sucesso!");
         }catch(SQLException e)
         {
             e.printStackTrace();
    		 System.out.println("Erro - "+e.getMessage());
         }
        return lista;
	}
	
	public List<Atividade> allUsers(Atividade atividade){
		String sql = "SELECT * FROM atividade";
		List<Atividade> lista = new ArrayList<Atividade>();
		try {
			PreparedStatement ps = dbcon.prepareStatement(sql);
			ResultSet results = ps.executeQuery();
			while(results.next()){
				Atividade atv = new Atividade();
				atv.setCdn_atividade(results.getInt("cdn_atividade"));
				atv.setNom_atividade(results.getString("nom_atividade"));
				atv.setDes_atividade(results.getString("des_Atividade"));
				atv.setQtd_tempo_estipulado(results.getInt("qtd_tempo_estipulado"));
				atv.setPerc_tempo_utilizado(results.getDouble("perc_tempo_utilizado"));
				atv.setInd_status(results.getInt("ind_status"));
				lista.add(atv);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
		}
		return lista;
	}
}

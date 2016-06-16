package br.com.jafiz.models;

/**
 *
 * @author Paulo Stocker - STK
 */

public class Atividade{
	
	private Integer cdn_usuario;
	private Integer cdn_atividade;
	private String nom_atividade;
	private String des_atividade;
	private Integer qtd_tempo_estipulado;	
	private Integer qtd_tempo_realizado;
	private Double perc_tempo_utilizado;
	private Integer ind_status;
	
	public Atividade(){

	}
	  
	public void setInd_status(Integer ind_status) {
		this.ind_status = ind_status;
	}

	public Integer getCdn_usuario() {
		return cdn_usuario;
	}
	
	public void setCdn_usuario(Integer cdn_usuario) {
		this.cdn_usuario = cdn_usuario;
	}
	
	public Integer getCdn_atividade() {
		return cdn_atividade;
	}
	
	public void setCdn_atividade(Integer cdn_atividade) {
		this.cdn_atividade = cdn_atividade;
	}

	public Integer getQtd_tempo_estipulado() {
		return qtd_tempo_estipulado;
	}
	
	public void setQtd_tempo_estipulado(Integer qtd_tempo_estipulado) {
		this.qtd_tempo_estipulado = qtd_tempo_estipulado;
	}
	public String getNom_atividade() {
		return nom_atividade;
	}
	
	public void setNom_atividade(String nom_atividade) {
		this.nom_atividade = nom_atividade;
	}
	
	public String getDes_atividade() {
		return des_atividade;
	}
	
	public void setDes_atividade(String des_atividade) {
		this.des_atividade = des_atividade;
	}
	
	public Integer getQtd_tempo_realizado() {
		return qtd_tempo_realizado;
	}
	
	public void setQtd_tempo_realizado(Integer qtd_tempo_realizado) {
		this.qtd_tempo_realizado = qtd_tempo_realizado;
	}
	
	public Double getPerc_tempo_utilizado() {
		return perc_tempo_utilizado;
	}

	public void setPerc_tempo_utilizado(Double perc_tempo_utilizado) {
		this.perc_tempo_utilizado = perc_tempo_utilizado;
	}

	public Integer getInd_status() {
		return ind_status;
	}
	    
}
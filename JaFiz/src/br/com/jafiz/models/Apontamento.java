package br.com.jafiz.models;

/**
 *
 * @author Paulo Stocker - STK
 */

public class Apontamento {

	  private Integer cdn_apontamento;
	  private Integer cdn_atividade;
	  private String des_apontamento;
	  private Float hor_inicio;
	  private Float hor_fim;
	  private Float hor_total;
	  
	public Integer getCdn_apontamento() {
		return cdn_apontamento;
	}
	
	public void setCdn_apontamento(Integer cdn_apontamento) {
		this.cdn_apontamento = cdn_apontamento;
	}
	
	public Integer getCdn_atividade() {
		return cdn_atividade;
	}
	
	public void setCdn_atividade(Integer cdn_atividade) {
		this.cdn_atividade = cdn_atividade;
	}
	
	public String getDes_apontamento() {
		return des_apontamento;
	}
	
	public void setDes_apontamento(String des_apontamento) {
		this.des_apontamento = des_apontamento;
	}
	
	public Float getHor_inicio() {
		return hor_inicio;
	}
	
	public void setHor_inicio(Float hor_inicio) {
		this.hor_inicio = hor_inicio;
	}
	
	public Float getHor_fim() {
		return hor_fim;
	}
	
	public void setHor_fim(Float hor_fim) {
		this.hor_fim = hor_fim;
	}
	
	public Float getHor_total() {
		return hor_total;
	}
	
	public void setHor_total(Float hor_total) {
		this.hor_total = hor_total;
	}
	  
}

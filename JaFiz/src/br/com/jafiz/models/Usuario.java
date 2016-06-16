package br.com.jafiz.models;

/**
 *
 * @author Paulo Stocker - STK
 */

public class Usuario{

	  private Integer id;
	  private String nome;
	  private String email;
	  private String senha;
	  private String datnasc;

	  public Usuario(){
		  nome = "";
		  email = "";
		  senha = "";
		  datnasc = "";
	  }
	  
	  public String getNome() {
	    return nome;
	  }
	  public void setNome(String novo) {
	    this.nome = novo;
	  }

	  public String getEmail() {
	    return email;
	  }
	  public void setEmail(String novo) {
	    this.email = novo;
	  }

	  public String getSenha() {
	    return senha;
	  }
	  public void setSenha(String novo) {
	    this.senha = novo;
	  }
	  
	  public String getDatnsc() {
		    return datnasc;
	  }
	  public void setDatnsc(String novo) {
	    this.datnasc = novo;
	  }

	  public int getId() {
	    return id;
	  }
	  public void setId(int novo) {
	    this.id = novo;
	  }
	}
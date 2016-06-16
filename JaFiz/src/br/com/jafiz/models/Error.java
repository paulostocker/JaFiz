package br.com.jafiz.models;

import java.util.List;

/**
 *
 * @author Paulo Stocker - STK
 */

public class Error {
	private String s_error;
	private List<Error> Error;

	public Error(){
		this.Error.clear();
	}
	public void setError(String erro){
		this.s_error = erro;
		//this.Error.add(erro);// = erro;
	}
	
	public List<Error> getError(){
		
		return Error;
	}
}

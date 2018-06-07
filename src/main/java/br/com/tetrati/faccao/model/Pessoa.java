package br.com.tetrati.faccao.model;

public enum Pessoa 
{
	FISICA("Física"),
	JURICIA("Jurídica");
	
	private String descricao;
	
	private Pessoa(String descricao) 
	{
		this.descricao = descricao;
	}

	public String getDescricao() 
	{
		return descricao;
	}
}

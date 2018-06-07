package br.com.tetrati.faccao.model;

public enum Roles 
{
	ROLE_USER("Usuário"),
	ROLE_ADMIN("Administrador"),
	ROLE_CONFECCAO("Confecção"),
	ROLE_FACCAO("Facção");
	
	private String descricao;
	
	private Roles(String descricao) 
	{
		this.descricao = descricao;
	}

	public String getDescricao() 
	{
		return descricao;
	}
}

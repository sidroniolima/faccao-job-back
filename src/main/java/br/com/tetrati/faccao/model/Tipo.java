package br.com.tetrati.faccao.model;

public enum Tipo 
{
	CONFECCAO("Confecção", Roles.ROLE_CONFECCAO),
	FACCAO("Facção", Roles.ROLE_FACCAO);
	
	private String descricao;
	private Roles role;
	
	private Tipo(String descricao, Roles role) 
	{
		this.descricao = descricao;
		this.role = role;
	}

	public String getDescricao() 
	{
		return descricao;
	}
	
	public Roles getRole() 
	{
		return role;
	}
}

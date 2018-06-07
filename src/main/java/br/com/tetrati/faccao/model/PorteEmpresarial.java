package br.com.tetrati.faccao.model;

public enum PorteEmpresarial 
{
	PEQUENO("Pequeno"),
	MEDIO("Médio"),
	GRANDE("Grande");
	
	private String descricao;

	private PorteEmpresarial(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
}

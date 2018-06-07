package br.com.tetrati.faccao.model;

public enum StatusJob 
{
	CRIADO("Criado"),
	CONCORRENCIA("Em concorrência"),
	PRODUCAO("Produção"),
	ENTREGUE("Entregue");
	
	private String descricao;

	private StatusJob(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
}

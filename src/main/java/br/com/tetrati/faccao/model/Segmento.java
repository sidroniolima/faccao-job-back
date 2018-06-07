package br.com.tetrati.faccao.model;

public enum Segmento 
{
	LINGERIE("Lengerie"),
	MODA_FITNESS("Moda fitness"),
	MODA_PRAIA("Moda praia"),
	SENSUAL("Sensual"),
	PLUS_SIZE("Plus size");
	
	private String descricao;

	private Segmento(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
}

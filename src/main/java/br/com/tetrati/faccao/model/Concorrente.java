package br.com.tetrati.faccao.model;

import java.time.LocalDate;

public class Concorrente 
{
	private String idFaccao;
	private String nomeFaccao;
	
	private LocalDate prazo;
	private double valor;
	
	public Concorrente(String idFaccao, String nomeFaccao, LocalDate prazo, double valor) 
	{
		this.idFaccao = idFaccao;
		this.nomeFaccao = nomeFaccao;
		this.prazo = prazo;
		this.valor = valor;
	}
	
	public String getIdFaccao() {
		return idFaccao;
	}
	public void setIdFaccao(String idFaccao) {
		this.idFaccao = idFaccao;
	}
	public String getNomeFaccao() {
		return nomeFaccao;
	}
	public void setNomeFaccao(String nomeFaccao) {
		this.nomeFaccao = nomeFaccao;
	}
	public LocalDate getPrazo() {
		return prazo;
	}
	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}

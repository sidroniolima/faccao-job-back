package br.com.tetrati.faccao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.tetrati.faccao.util.JsonDateDeserializer;
import br.com.tetrati.faccao.util.JsonDateSerializer;
import br.com.tetrati.faccao.util.JsonDateTimeDeserializer;
import br.com.tetrati.faccao.util.JsonDateTimeSerializer;

@Document(collection="jobs")
public class Job 
{
	@Id
	private String id;
	
	private StatusJob status;
	
	private LocalDate data;
	private LocalDate dataEntrega;
	
	private String nomeConfeccao;
	
	private List<ItemJob> itens;

	private LocalDate prazoIdeal;	
	private int numeroItens;
	private double valorMinimo;
		
	private List<Concorrente> concorrentes;

	private String nomeFaccaoVencedora;
	private double valorVencedor;
	private LocalDate prazoVencedor;
	
	private String descricao;
	
	public Job() 
	{
		this.itens = new ArrayList<ItemJob>();
		this.concorrentes = new ArrayList<Concorrente>();
		this.data = LocalDate.now();
		this.status = StatusJob.CRIADO;
	}
	
	public Job(LocalDate data, LocalDate prazoIdeal, int numeroItens, double valorMinimo) 
	{
		this();
		this.data = data;
		this.prazoIdeal = prazoIdeal;
		this.numeroItens = numeroItens;
		this.valorMinimo = valorMinimo;
	}
	
	public Job(String nomeConfeccao, LocalDate prazoIdeal, int numeroItens, double valorMinimo,	String descricao) 
	{
		this();
		this.nomeConfeccao = nomeConfeccao;
		this.prazoIdeal = prazoIdeal;
		this.numeroItens = numeroItens;
		this.valorMinimo = valorMinimo;
		this.descricao = descricao;
	}

	public Job(LocalDate criacao, LocalDate prazoIdeal) 
	{
		this();
		this.data = criacao;
		this.prazoIdeal = prazoIdeal;
	}

	public void addItem(ItemJob item)
	{
		itens.add(item);
	}
	
	public void addItem(String descricao, int qtd, double valorUnitario)
	{
		itens.add(new ItemJob(descricao, qtd, valorUnitario));
		this.numeroItens += qtd;
		this.valorMinimo += qtd * valorUnitario;
	}
	
	public void removeItem(String descricao, int qtd, double valorUnitario) 
	{
		ItemJob paraRemover = new ItemJob(descricao, qtd, valorUnitario);
		
		if (this.itens.remove(paraRemover))
		{
			this.numeroItens -= qtd;
			this.valorMinimo -= qtd * valorUnitario;
		} else {
			System.out.println("Não achou");
		}
	}	
	
	public void addConcorrente(Concorrente concorrente)
	{
		concorrentes.add(concorrente);
	}

	public void addConcorrente(String idFaccao, String nomeFaccao, LocalDate prazo, double valor)
	{
		concorrentes.add(new Concorrente(idFaccao, nomeFaccao, prazo, valor));
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public StatusJob getStatus() {
		return status;
	}
	public void setStatus(StatusJob status) {
		this.status = status;
	}

	@JsonProperty("statusDescricao")
	public String getStatusDescricao()
	{
		return this.status.getDescricao();
	}
	
	public String getNomeConfeccao() {
		return nomeConfeccao;
	}
	public void setNomeConfeccao(String nomeConfeccao) {
		this.nomeConfeccao = nomeConfeccao;
	}

	public String getNomeFaccaoVencedora() {
		return nomeFaccaoVencedora;
	}
	public void setNomeFaccaoVencedora(String nomeFaccaoVencedora) {
		this.nomeFaccaoVencedora = nomeFaccaoVencedora;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public List<ItemJob> getItens() {
		return itens;
	}

	public void setItens(List<ItemJob> itens) {
		this.itens = itens;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public LocalDate getPrazoIdeal() {
		return prazoIdeal;
	}

	public void setPrazoIdeal(LocalDate prazoIdeal) {
		this.prazoIdeal = prazoIdeal;
	}

	public int getNumeroItens() {
		return numeroItens;
	}

	public void setNumeroItens(int numeroItens) {
		this.numeroItens = numeroItens;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public List<Concorrente> getConcorrentes() {
		return concorrentes;
	}

	public void setConcorrentes(List<Concorrente> concorrentes) {
		this.concorrentes = concorrentes;
	}

	public double getValorVencedor() {
		return valorVencedor;
	}

	public void setValorVencedor(double valorVencedor) {
		this.valorVencedor = valorVencedor;
	}

	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonDeserialize(using=JsonDateTimeDeserializer.class)
	public LocalDate getPrazoVencedor() {
		return prazoVencedor;
	}

	public void setPrazoVencedor(LocalDate prazoVencedor) {
		this.prazoVencedor = prazoVencedor;
	}
}

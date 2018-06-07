package br.com.tetrati.faccao.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="empresas")
public class Empresa 
{
	@Id
	private String id;
	
	private Tipo tipo;
	
	private String nome;
	private String nomeResponsavel;
	private Pessoa pessoa;
	private String email;
	
	@DBRef
	private Endereco endereco;
	
	private List<Segmento> segmentos;
	
	private int numeroMaquinas;
	private int numeroFuncionarios;
	
	public PorteEmpresarial porte;
	
	private User usuario;

	public Empresa() {	}
	
	public Empresa(String nome, String email, String senha) 
	{
		this.nome = nome;
		this.usuario = new User(email, senha);
	}

	public Empresa(Tipo tipo, 
			String nome, 
			Pessoa pessoa, 
			List<Segmento> segmentos, 
			int numeroMaquinas,
			int numeroFuncionarios, 
			PorteEmpresarial porte) 
	{
		this.tipo = tipo;
		this.nome = nome;
		this.pessoa = pessoa;
		this.segmentos = segmentos;
		this.numeroMaquinas = numeroMaquinas;
		this.numeroFuncionarios = numeroFuncionarios;
		this.porte = porte;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) 
	{
		this.usuario.getRoles().add(tipo.getRole());
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Segmento> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<Segmento> segmentos) {
		this.segmentos = segmentos;
	}

	public int getNumeroMaquinas() {
		return numeroMaquinas;
	}

	public void setNumeroMaquinas(int numeroMaquinas) {
		this.numeroMaquinas = numeroMaquinas;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public PorteEmpresarial getPorte() {
		return porte;
	}

	public void setPorte(PorteEmpresarial porte) {
		this.porte = porte;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}

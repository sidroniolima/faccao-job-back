package br.com.tetrati.faccao.service;

import br.com.tetrati.faccao.model.Empresa;

public interface EmpresaService extends ServiceCrud<Empresa, String>
{
	public Empresa findByUsuarioUsername(String username);
}

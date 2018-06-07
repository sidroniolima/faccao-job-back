package br.com.tetrati.faccao.service;

import br.com.tetrati.faccao.model.Empresa;

public interface UserService
{
	public Empresa findByUsername(String username);
}

package br.com.tetrati.faccao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tetrati.faccao.model.Empresa;
import br.com.tetrati.faccao.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService
{
	private EmpresaRepository empresaRepo;
	
	@Autowired
	public EmpresaServiceImpl(EmpresaRepository empresaRepo) 
	{
		this.empresaRepo = empresaRepo;
	}

	@Override
	public Empresa save(Empresa empresa) 
	{
		return this.empresaRepo.save(empresa);
	}

	@Override
	public void delete(String id) 
	{
		this.empresaRepo.delete(id);
	}

	@Override
	public List<Empresa> listAll() 
	{
		return this.empresaRepo.findAll();
	}

	@Override
	public Empresa findById(String id) 
	{
		return this.empresaRepo.findOne(id);
	}

	@Override
	public Empresa findByUsuarioUsername(String username) 
	{
		return this.empresaRepo.findByUsuarioUsername(username);
	}
}

package br.com.tetrati.faccao.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tetrati.faccao.model.Empresa;
import br.com.tetrati.faccao.service.EmpresaService;

@RestController
public class EmpresaController implements SimpleController<Empresa, String>
{
	private EmpresaService empresaSrvc;
	
	@Autowired
	public EmpresaController(EmpresaService empresaSrvc) 
	{
		this.empresaSrvc = empresaSrvc;
	}

	@Override
	@PostMapping("/api/empresa/pre/create")
	public Empresa create(@RequestBody Empresa empresa) 
	{
		return this.empresaSrvc.save(empresa);
	}
	
	@Override
	public Empresa getById(String id) 
	{
		return empresaSrvc.findById(id);
	}

	@Override
	public List<Empresa> getAll() 
	{
		return empresaSrvc.listAll();
	}

	@Override
	@PreAuthorize("ROLE_ADMIN")
	public void delete(String id) 
	{
		empresaSrvc.delete(id);
	}
	
	@GetMapping("/api/empresa/logada")
	public Empresa empresaLogada(Principal principal)
	{
		return this.empresaSrvc.findByUsuarioUsername(principal.getName());
	}
}

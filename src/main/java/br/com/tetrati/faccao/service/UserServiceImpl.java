package br.com.tetrati.faccao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tetrati.faccao.model.Empresa;
import br.com.tetrati.faccao.repository.EmpresaRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
	private EmpresaRepository empresaRepo;
	
	@Autowired
	public UserServiceImpl(EmpresaRepository empresaRepo) 
	{
		this.empresaRepo = empresaRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		Empresa empresa = this.findByUsername(email);

		if (null == empresa)
		{
			throw new UsernameNotFoundException("E-mail não cadastrado.");
		}
		return new UserDetailsImpl(empresa.getUsuario());
	}

	@Override
	public Empresa findByUsername(String username) 
	{
		return this.empresaRepo.findByUsuarioUsername(username);
	}
}

package br.com.tetrati.faccao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tetrati.faccao.repository.EmpresaRepository;
import br.com.tetrati.faccao.repository.UserRepository;

@Component
public class DbSeeder implements CommandLineRunner 
{
	private UserRepository userRepo;
	private EmpresaRepository empresaRepo;
	
	public DbSeeder(UserRepository userRepo, EmpresaRepository empresaRepo) 
	{
		this.userRepo = userRepo;
		this.empresaRepo = empresaRepo;
	}

	@Override
	public void run(String... arg0) throws Exception 
	{
		//Clear the db
		//this.empresaRepo.deleteAll();
		
	}

}

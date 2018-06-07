package br.com.tetrati.faccao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tetrati.faccao.model.Empresa;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String>
{
	public Empresa findByUsuarioUsername(String userName);
}

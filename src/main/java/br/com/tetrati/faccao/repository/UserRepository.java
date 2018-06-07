package br.com.tetrati.faccao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tetrati.faccao.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>
{
	public User findByUsername(String username);
}

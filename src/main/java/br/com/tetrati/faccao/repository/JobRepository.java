package br.com.tetrati.faccao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tetrati.faccao.model.Job;
import br.com.tetrati.faccao.model.StatusJob;

@Repository
public interface JobRepository extends MongoRepository<Job, String>
{
	public List<Job> findByNomeConfeccao(String confeccao);
	public List<Job> findByStatusIn(List<StatusJob> status);
}

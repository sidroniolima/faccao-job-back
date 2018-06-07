package br.com.tetrati.faccao.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tetrati.faccao.model.Job;
import br.com.tetrati.faccao.model.StatusJob;
import br.com.tetrati.faccao.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService
{
	private JobRepository jobRepo;
	
	@Autowired
	public JobServiceImpl(JobRepository jobRepo) 
	{
		this.jobRepo = jobRepo;
	}

	@Override
	public Job save(Job job) 
	{
		return this.jobRepo.save(job);
	}

	@Override
	public void delete(String id) 
	{
		this.jobRepo.delete(id);
	}

	@Override
	public List<Job> listAll() 
	{
		return this.jobRepo.findAll();
	}

	@Override
	public Job findById(String id) 
	{
		return this.jobRepo.findOne(id);
	}

	@Override
	public List<Job> findByNomeConfeccao(String confeccao) 
	{
		return this.jobRepo.findByNomeConfeccao(confeccao);
	}

	@Override
	public List<Job> listOportunidades() 
	{
		return this.jobRepo.findByStatusIn(Arrays.asList(StatusJob.CRIADO, StatusJob.CONCORRENCIA));
	}
}

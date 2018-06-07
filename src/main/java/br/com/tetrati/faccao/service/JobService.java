package br.com.tetrati.faccao.service;

import java.util.List;

import br.com.tetrati.faccao.model.Job;

public interface JobService extends ServiceCrud<Job, String>
{
	public List<Job> findByNomeConfeccao(String confeccao);
	public List<Job> listOportunidades();
}

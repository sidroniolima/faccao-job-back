package br.com.tetrati.faccao.rest;

import java.security.Principal;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tetrati.faccao.model.Empresa;
import br.com.tetrati.faccao.model.Job;
import br.com.tetrati.faccao.service.EmpresaService;
import br.com.tetrati.faccao.service.JobService;

@RestController
public class JobController implements SimpleController<Job, String>
{
	private JobService jobSrvc;
	private EmpresaService empresaSrvc;
	
	private Principal principal;
	
	@Autowired
	public JobController(JobService jobSrvc, EmpresaService empresaSrvc) 
	{
		this.jobSrvc = jobSrvc;
		this.empresaSrvc = empresaSrvc;
	}

	@Override
	@PostMapping("/api/job/completo")
	public Job create(@RequestBody Job job) 
	{
		return jobSrvc.save(job);
	}
	
	@PostMapping("/api/job")
	public Job create(@RequestBody Job job, Principal principal) 
	{
		Empresa emp = this.empresaSrvc.findByUsuarioUsername(principal.getName());
		job.setNomeConfeccao(emp.getNome());
		return jobSrvc.save(job);
	}

	@Override
	@GetMapping("/api/job/:id")
	public Job getById(@PathParam("id") String id) 
	{
		return this.jobSrvc.findById(id);
	}

	@Override
	@GetMapping("/api/job")
	public List<Job> getAll() 
	{
		return this.jobSrvc.listAll();
	}

	@Override
	@DeleteMapping("/api/job")
	public void delete(String id) 
	{
		this.jobSrvc.delete(id);
	}
	
	@GetMapping("/api/job/confeccao/:confeccao")
	public List<Job> listJobsByConfeccao(@RequestParam("confeccao") String confeccao)
	{
		return this.jobSrvc.findByNomeConfeccao(confeccao);
	}
	
	@GetMapping("/api/job/meus")
	public List<Job> listJobsByConfeccao(Principal principal)
	{
		Empresa emp = this.empresaSrvc.findByUsuarioUsername(principal.getName());
		return this.jobSrvc.findByNomeConfeccao(emp.getNome());
	}
	
	@GetMapping("/api/job/oportunidades")
	public List<Job> listOportunidades()
	{
		return this.jobSrvc.listOportunidades();
	}
}

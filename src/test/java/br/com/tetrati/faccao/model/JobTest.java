package br.com.tetrati.faccao.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

public class JobTest 
{
	private Job job;
	
	@Before
	public void setup()
	{
		job = new Job(LocalDate.now(), LocalDate.now().plus(7, ChronoUnit.DAYS));
	}
	
	@Test
	public void deveCriarOJob() 
	{
		assertEquals("Job criado.", LocalDate.now(), job.getData());
		assertEquals("Job criado.", LocalDate.now().plus(7, ChronoUnit.DAYS), job.getPrazoIdeal());
	}
	
	@Test
	public void deveAdicionarOsItens()
	{
		job.addItem("Calcinha M etampada", 100, 0.25);
		job.addItem("Sutiã G com bojo", 100, 0.25);
		job.addItem("Calcinha G", 100, 0.25);
		job.addItem("Cueca PP", 100, 0.25);
		
		assertEquals("Item inserido", "Calcinha M etampada", job.getItens().get(0).getDescricao());
		assertEquals("Item inserido", "Sutiã G com bojo", job.getItens().get(1).getDescricao());
		assertEquals("Item inserido", "Calcinha G", job.getItens().get(2).getDescricao());
		assertEquals("Item inserido", "Cueca PP", job.getItens().get(3).getDescricao());
		
		assertEquals("Quantidade", 400, job.getNumeroItens());
		assertEquals("Valor", 100, job.getValorMinimo(), 0.00);
	}
	
	@Test
	public void deveRemoverItens()
	{
		job.addItem("Calcinha M estampada", 100, 0.25);
		job.addItem("Sutiã G com bojo", 100, 0.25);
		job.addItem("Calcinha G", 100, 0.25);
		job.addItem("Cueca PP", 100, 0.25);
		
		job.removeItem("Calcinha M estampada", 100, 0.25);
		
		assertEquals("Quantidade", 300, job.getNumeroItens());
		assertEquals("Valor", 75, job.getValorMinimo(), 0.00);
	}
}

package br.com.maikelfenner.javatdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import salario.CalculadoraDeSalario;
import salario.Cargo;
import salario.Funcionario;

public class CalculadoraDeSalarioTest {

	private CalculadoraDeSalario calculadora;
	
	@Before
	public void inicializa() {
		this.calculadora = new CalculadoraDeSalario();
	}
	
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite() {
		Funcionario desenvolvedor = new Funcionario("Maurício", 1500.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(1500 * .9, salario, 0.00001);
	}
	
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite() {
		Funcionario desenvolvedor = new Funcionario("Maurício", 4000.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(4000 * .8, salario, 0.00001);
	}
	
	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite() {
		Funcionario desenvolvedor = new Funcionario("Maurício", 500.0, Cargo.DBA);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(500 * .85, salario, 0.00001);
	}
	
	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAcimaDoLimite() {
		Funcionario desenvolvedor = new Funcionario("Maurício", 2500.0, Cargo.DBA);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(2500 * .75, salario, 0.00001);
	}
}

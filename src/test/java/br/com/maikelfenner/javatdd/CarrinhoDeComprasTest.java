package br.com.maikelfenner.javatdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarrinhoDeComprasTest {

	private CarrinhoDeCompras carrinho;
	
	@Before
	public void inicializa() {
		carrinho = new CarrinhoDeCompras();
	}
	
	@Test
	public void deveRetornarZeroSeCarrinhoVazio() {
		assertEquals(0.0, carrinho.maiorValor(), 0.00001);
	}
	
	@Test
	public void deveRetornarValorDoItemSeCarrinhoCom1Elemento() {
		Item item = new Item("Geladeira", 1, 900.0);
		carrinho.adiciona(item);
		
		assertEquals(1, carrinho.getItens().size());
		assertEquals(item.getValorTotal(), carrinho.maiorValor(), 0.00001);
	}
	
	@Test
	public void deveRetornarValorDoItemSeCarrinhoComMuitosElementos() {
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		carrinho.adiciona(new Item("Fogão", 1, 1500.0));
		carrinho.adiciona(new Item("Máquina de Lavar", 1, 700.0));
		
		assertEquals(1500.0, carrinho.maiorValor(), 0.00001);
	}
}

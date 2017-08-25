package br.com.maikelfenner.javatdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class CarrinhoDeCompras {
	
	private List<Item> itens;
	
	public CarrinhoDeCompras() {
		this.itens = new ArrayList<Item>();
	}
	
	public void adiciona(Item item) {
		this.itens.add(item);
	}
	
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	public double maiorValor() {
		Optional<Double> valor = itens.stream().map(i -> i.getValorTotal()).reduce((a,b) -> a > b ? a : b);
		
		return valor.isPresent() ? valor.get() : 0;
	}
}

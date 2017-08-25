package br.com.maikelfenner.javatdd;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.maikelfenner.javatdd.notafiscal.AcaoAposGerarNota;
import br.com.maikelfenner.javatdd.notafiscal.GeradorDeNotaFiscal;
import br.com.maikelfenner.javatdd.notafiscal.NFDao;
import br.com.maikelfenner.javatdd.notafiscal.NotaFiscal;
import br.com.maikelfenner.javatdd.notafiscal.Pedido;
import br.com.maikelfenner.javatdd.notafiscal.SAP;
import br.com.maikelfenner.javatdd.notafiscal.Tabela;

public class NotaFiscalTest {

	private NFDao dao;
	private SAP sap;
	private Tabela tabela;
	private GeradorDeNotaFiscal gerador;
	
	@Before
	public void inicializa() {
		dao = Mockito.mock(NFDao.class);
		sap = Mockito.mock(SAP.class);
		tabela = Mockito.mock(Tabela.class);
		gerador = new GeradorDeNotaFiscal(Arrays.asList(dao, sap), tabela);
	}
	
	@Test
	public void deveGerarNFComValorDeImpostoDescontado() {		
		Pedido pedido = new Pedido("Maurício", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		assertEquals(940.0, nf.getValor(), 0.00001);
	}
	
	@Test
	public void deveConsultarTabelaParaCalcularValor() {
		Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.2);
		
		List<AcaoAposGerarNota> nenhumaAcao = Collections.emptyList();
		gerador = new GeradorDeNotaFiscal(nenhumaAcao, tabela);

		Pedido pedido = new Pedido("Maurício", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(tabela).paraValor(1000.0);
		assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
	}
	
	@Test
	public void devePersistirNFGerada() {
		Pedido pedido = new Pedido("Maurício", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(dao).executa(nf);
	}
	
	@Test
	public void deveEnviarNFPersistidaParaSAP() {
		Pedido pedido = new Pedido("Maurício", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(sap).executa(nf);
	}
}

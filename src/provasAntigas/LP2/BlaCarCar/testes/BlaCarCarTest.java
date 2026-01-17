package provasAntigas.LP2.BlaCarCar.testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import provasAntigas.LP2.BlaCarCar.BlaCarCar;

public class BlaCarCarTest {
	
	private BlaCarCar bcc;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.bcc = new BlaCarCar();
	}

	@Test
	public void calculaCompatibilidade100Test() {
		this.bcc.cadastrarPassageiro("Pedro", "111.222.333-44", new String[]{"1", "2", "3"});
		this.bcc.cadastrarViagem("Maria", "Carona para Campina Grande", 4, "91234-5678", new String[]{"1", "2", "3"});
		int comp = this.bcc.calcularCompatibilidade("111.222.333-44", 1);
		assertEquals(100, comp);
	}
	
	@Test
	public void calculaCompatibilidade70Test() {
		this.bcc.cadastrarPassageiro("Pedro", "111.222.333-44", new String[]{"1", "2", "4"});
		this.bcc.cadastrarViagem("Maria", "Carona para Campina Grande", 4, "91234-5678", new String[]{"1", "2", "3"});
		int comp = this.bcc.calcularCompatibilidade("111.222.333-44", 1);
		assertEquals(70, comp);
	}
	
	@Test
	public void calculaCompatibilidade30Test() {
		this.bcc.cadastrarPassageiro("Pedro", "111.222.333-44", new String[]{"1", "5", "4"});
		this.bcc.cadastrarViagem("Maria", "Carona para Campina Grande", 4, "91234-5678", new String[]{"1", "2", "3"});
		int comp = this.bcc.calcularCompatibilidade("111.222.333-44", 1);
		assertEquals(30, comp);
	}
	
	@Test
	public void calculaCompatibilidade0Test() {
		this.bcc.cadastrarPassageiro("Pedro", "111.222.333-44", new String[]{"9", "5", "4"});
		this.bcc.cadastrarViagem("Maria", "Carona para Campina Grande", 4, "91234-5678", new String[]{"1", "2", "3"});
		int comp = this.bcc.calcularCompatibilidade("111.222.333-44", 1);
		assertEquals(0, comp);
	}

}
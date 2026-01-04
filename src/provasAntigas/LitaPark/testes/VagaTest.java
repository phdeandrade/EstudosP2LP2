package provasAntigas.LitaPark.testes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import provasAntigas.LitaPark.Vaga;

public class VagaTest {
	
	private Vaga vagaBase;

	@BeforeEach
	public void setUp() {
		this.vagaBase = new Vaga("A", 1);
	}

	@Test
	public void EqualsVagasIguaisTest() {
		Vaga vaga = new Vaga("A", 1);
		assertTrue(vagaBase.equals(vaga));
	}
	
	@Test
	public void EqualsVagasSetorDiferenteTest() {
		Vaga vaga = new Vaga("B", 1);
		assertFalse(vagaBase.equals(vaga));
	}
	
	@Test
	public void EqualsVagasPosicaoDiferenteTest() {
		Vaga vaga = new Vaga("A", 2);
		assertFalse(vagaBase.equals(vaga));
	}
	
	@Test
	public void lancamentoDeExcecaoTest() {
		try {
			Vaga vaga = new Vaga("A", -1);
			fail("Isso deveria lançar uma exceção");
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		}
	}
	
	@Test
	public void estacionarTest() {
		vagaBase.estacionar("ABCDEF", LocalTime.now());
		assertEquals("Localização: A1, Estado: Ocupada", vagaBase.toString());
	}
	
	@Test
	public void liberarVaga() {
		vagaBase.estacionar("ABCDEF", LocalTime.now());
		vagaBase.liberar();
		assertEquals("Localização: A1, Estado: Livre", vagaBase.toString());
	}

}

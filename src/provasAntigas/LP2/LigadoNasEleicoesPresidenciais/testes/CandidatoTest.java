package provasAntigas.LP2.LigadoNasEleicoesPresidenciais.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import provasAntigas.LP2.LigadoNasEleicoesPresidenciais.Candidato;

public class CandidatoTest {
	
	private Candidato candidatoBase;

	@BeforeEach
	public void setUp() throws Exception {
		this.candidatoBase = new Candidato("Lula", "PT", 13);
	}
	
	@Test
	public void construtorIdNull() {
		assertThrows(IllegalArgumentException.class, () -> { new Candidato("Teste", "TST", null); });
	}

	@Test
	public void equalsIdIgualTest() {
		Candidato clone = new Candidato("Teste", "TST", 13);
		assertEquals(true, candidatoBase.equals(clone));
	}
	
	@Test
	public void equalsIdDiferenteTest() {
		Candidato objeto = new Candidato("Teste", "TST", 10);
		assertEquals(false, candidatoBase.equals(objeto));
	}
	
	@Test
	public void toStringTest() {
		String saidaEsperada = "Lula – PT – 13 – 0";
		assertEquals(saidaEsperada, this.candidatoBase.toString());
	}
	
	@Test
	public void adicionarVotoTest() {
		this.candidatoBase.adicionarVoto();
		assertEquals(1, this.candidatoBase.getVotos());
	}
	
	@Test
	public void listarVotos() {
		this.candidatoBase.adicionarVoto();
		String saidaEsperada = "13 – 1";
		assertEquals(saidaEsperada, this.candidatoBase.listarVotos());
	}
	
	@Test
	public void alterarNomeTest() {
		this.candidatoBase.alterarNome("Pedro Henrique");
		assertEquals("Pedro Henrique", this.candidatoBase.getNome());
	}
}
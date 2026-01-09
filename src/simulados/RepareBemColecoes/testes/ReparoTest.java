package simulados.RepareBemColecoes.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simulados.RepareBemColecoes.Reparo;

public class ReparoTest {
	
	public Reparo reparo;

	@BeforeEach
	public void setUp() {
		this.reparo = new Reparo("Substituir", "Substituir peça faltosa", 5.0);
	}

	@Test
	public void reajustarPrecoReparoAumentoTest() {
		this.reparo.ajustePercentual(10.0);
		assertEquals(5.5, this.reparo.getPreco());
	}

	@Test
	public void reajustarPrecoReparoDescontoTest() {
		this.reparo.ajustePercentual(-10.0);
		assertEquals(4.5, this.reparo.getPreco());
	}
	

}

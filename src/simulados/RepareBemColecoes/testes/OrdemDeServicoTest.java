package simulados.RepareBemColecoes.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simulados.RepareBemColecoes.OrdemDeServico;

public class OrdemDeServicoTest {
	
	private OrdemDeServico os;

	@BeforeEach
	public void setUp() {
		this.os = new OrdemDeServico("Pedro", "9123-1234", "Calça");
	}

	@Test
	public void statusInicialTest() {
		assertEquals("Não iniciada", this.os.getStatus());
	}
	
	@Test
	public void alterarStatusEmAndamentoTest() {
		this.os.alterarStatus("Em andamento");
		assertEquals("Em andamento", this.os.getStatus());
	}
	
	@Test
	public void alterarStatusConcluidoTest() {
		this.os.alterarStatus("Concluido");
		assertEquals("Concluido", this.os.getStatus());
	}

}

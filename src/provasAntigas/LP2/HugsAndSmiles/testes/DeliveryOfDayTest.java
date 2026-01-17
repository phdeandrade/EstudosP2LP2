package provasAntigas.LP2.HugsAndSmiles.testes;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import provasAntigas.LP2.HugsAndSmiles.*;

public class DeliveryOfDayTest {
	
	private DeliveryOfDay dod;
	private Cliente[] clientes;
	
	//Considerando apenas 2 clientes, no lugar de 50, como a prova indicava
	@BeforeEach
	public void setUp() {
		this.clientes = new Cliente[]{new Cliente(1, "Pedro", "R. João Julião, num. 288"), 
				new Cliente(2, "Milena", "R. Augusto dos Anjos num. 18")};
		this.dod = new DeliveryOfDay(clientes);
	}
	
	@Test
	public void addDeliveryTest() {
		Delivery d1 = new Delivery("Lenços", "HUGGIES", 1);
		assertEquals(true, this.dod.addDelivery(d1));
	}
	
	@Test
	public void addDeliveryNonClientTest() {
		Delivery d2 = new Delivery("Lenços", "HUGGIES", 3);
		assertEquals(false, this.dod.addDelivery(d2));
	}
 	
	@Test
	public void addDeliveryAtFullCappacityTest() {
		DeliveryOfDay dod2 = new DeliveryOfDay(this.clientes, 2);
		Delivery d1 = new Delivery("Lenços", "HUGGIES", 1);
		Delivery d2 = new Delivery("Lenços", "HUGGIES", 2);
		dod2.addDelivery(d1);
		dod2.addDelivery(d2);
		Delivery d3 = new Delivery("Lenços", "HUGGIES", 2);
		assertEquals(false, dod2.addDelivery(d3));
	}
	
	@Test 
	public void addDeliveryAlreadyAddedCostumerTest() {
		Delivery d1 = new Delivery("Lenços", "HUGGIES", 1);
		this.dod.addDelivery(d1);
		Delivery d2 = new Delivery("Lenços", "HUGGIES", 1);
		assertEquals(true, this.dod.addDelivery(d2));
	}
	
	@Test
	public void listDoDTest() {
		Delivery d1 = new Delivery("Lenços", "HUGGIES", 1);
		Delivery d2 = new Delivery("Lenços", "HUGGIES", 2);
		this.dod.addDelivery(d1);
		this.dod.addDelivery(d2);
		String list = "Delivery [produto=Lenços, fornecedor=HUGGIES, idCliente=1, status=ongoing]\nDelivery [produto=Lenços, fornecedor=HUGGIES, idCliente=2, status=ongoing]\n";
		assertEquals(list, this.dod.listDoD());
	}
	
	@Test
	public void finishDeliveryIllegalArgumentExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> { this.dod.finishDelivery(5); });
	}
	
	@Test
	public void finishDeliveryTest() {
		Delivery d1 = new Delivery("Lenços", "HUGGIES", 1);
		this.dod.addDelivery(d1);
		this.dod.finishDelivery(1);
		String finished = "Delivery [produto=Lenços, fornecedor=HUGGIES, idCliente=1, status=finished]\n";
		assertEquals(finished, this.dod.listFinished());
	}
}
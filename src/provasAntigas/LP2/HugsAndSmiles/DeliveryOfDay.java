package provasAntigas.LP2.HugsAndSmiles;

public class DeliveryOfDay {
	private Cliente[] clientes;
	private Delivery[] entregas;
	private int iEntregas;
	
	public DeliveryOfDay(Cliente[] clientes) {
		this.clientes = clientes;
		this.entregas = new Delivery[6];
		this.iEntregas = 0;
	}
	
	public DeliveryOfDay(Cliente[] clientes, int capacidadeMaxima) {
        this.clientes = clientes;
        this.entregas = new Delivery[capacidadeMaxima]; 
        this.iEntregas = 0;
    }
	
	public boolean addDelivery(Delivery d1) {
		if (this.iEntregas + 1 >= this.entregas.length || ! isClienteAdded(d1.getIdCliente())) {
			return false;
		}
		d1.alterarStatus("ongoing");
		this.entregas[iEntregas] = d1;
		this.iEntregas++;
		return true;
		
	}
	
	public String listDoD() {
		String list = "";
		for (int i = 0; i < this.iEntregas; i++) {
			list += this.entregas[i].toString() + "\n";
		}
		return list;
	}
	
	public String listFinished() {
		String list = "";
		for (int i = 0; i < this.iEntregas; i++) {
			if (this.entregas[i].getStatus().equals("finished")) {
				list += this.entregas[i].toString() + "\n";
			}
		}
		return list;
	}

	public boolean finishDelivery(int pos) {
		if (pos - 1 > this.iEntregas || pos - 1 < 0) {
			throw new IllegalArgumentException("Posição inválida");
		}
		if (this.entregas[pos - 1].getStatus() == "finished") {
			return false; 
		}
		this.entregas[pos - 1].alterarStatus("finished");
		return true;
	}
	
	private boolean isClienteAdded(int idCliente) {
		for (int i = 0; i < this.clientes.length ; i++) {
			if (this.clientes[i].getId() == idCliente ) {
				return true;
			}
		}
		return false;
	}
}

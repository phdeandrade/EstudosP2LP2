package simulados.RepareBemColecoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrdemDeServico {
	private String cliente;
	private String telefone;
	private String pecaRoupa;
	private List<Reparo> reparos;
	private String status;
	
	public OrdemDeServico(String cliente, String telefone, String pecaRoupa) {
		super();
		this.cliente = cliente;
		this.telefone = telefone;
		this.pecaRoupa = pecaRoupa;
		this.reparos = new ArrayList<Reparo>();
		this.status = "Não iniciada";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, pecaRoupa, reparos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemDeServico other = (OrdemDeServico) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(pecaRoupa, other.pecaRoupa)
				&& Objects.equals(reparos, other.reparos);
	}
	
	@Override
	public String toString() {
		return "cliente: " + this.cliente + 
				"; roupa: " + this.pecaRoupa + 
				"; reparos: " + this.reparos.size() + 
				"; total: " + this.getPrecoTotal();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}

	public void alterarStatus(String status) {
		this.status = status;
	}

	public String getCliente() {
		return cliente;
	}

	public String getPecaRoupa() {
		return pecaRoupa;
	}

	public List<Reparo> getReparos() {
		return reparos;
	}
	
	public void adicionarReparo(Reparo novoReparo) {
		if (this.reparos.size() == 10) {
			return;
		}
		this.reparos.add(novoReparo);
	}
	
	public double getPrecoTotal() {
		double precoTotal = 0.0;
		for (Reparo r : this.reparos) {
			precoTotal += r.getPreco();
		}
		return precoTotal;
	}
}

package provasAntigas.HugsAndSmiles;

import java.util.Objects;

public class Delivery {
	private String produto;
	private String fornecedor;
	private int idCliente;
	private String status;
	
	public Delivery(String produto, String fornecedor, int idCliente) {
		super();
		this.produto = produto;
		this.fornecedor = fornecedor;
		this.idCliente = idCliente;
		this.status = "ready";
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, idCliente, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		return Objects.equals(fornecedor, other.fornecedor) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(produto, other.produto);
	}

	@Override
	public String toString() {
		return String.format("Delivery [produto=%s, fornecedor=%s, idCliente=%s, status=%s]", produto, fornecedor,
				idCliente, status);
	}

	public String getStatus() {
		return status;
	}

	public void alterarStatus(String status) {
		this.status = status;
	}

	public String getProduto() {
		return produto;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
}

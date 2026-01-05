package simulados.RepareBemColecoes;

import java.util.Objects;

public class Reparo {
	private String id;
	private String descricao;
	private double preco;
	
	public Reparo(String id, String descricao, double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
	    return "Id: " + this.id + 
	            ", Descrição: " + this.descricao + 
	            String.format(", Preço: R$%.2f", this.preco);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparo other = (Reparo) obj;
		return Objects.equals(id, other.id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getId() {
		return id;
	}
	
	public void ajustePercentual(double valor) {
		double novoPreco = this.preco * (1 + valor / 100);
		this.preco = novoPreco;
	}
	
}

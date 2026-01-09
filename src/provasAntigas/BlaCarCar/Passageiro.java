package provasAntigas.BlaCarCar;

import java.util.Arrays;
import java.util.Objects;

public class Passageiro {
	private String nome;
	private String cpf;
	private String[] pontosFrequentes;
	private String redeSocial;
	
	public Passageiro(String nome, String cpf, String[] pontosFrequentes) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.pontosFrequentes = pontosFrequentes;
		this.redeSocial = "";
	}
	
	public Passageiro(String nome, String cpf, String link, String[] pontosFrequentes) {
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("CPF Inexistente");
		}
		this.nome = nome;
		this.cpf = cpf;
		this.pontosFrequentes = pontosFrequentes;
		this.redeSocial = link;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	@Override
	public String toString() {
		return String.format("Passageiro: Nome: %s; CPF: %s; Pontos Frequentes: %s; Link Rede Social: %s.", nome, cpf,
				Arrays.toString(pontosFrequentes), redeSocial);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getPontosFrequentes() {
		return pontosFrequentes;
	}

	public void setPontosFrequentes(String[] pontosFrequentes) {
		this.pontosFrequentes = pontosFrequentes;
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void alterarLinkRedeSocial(String link) {
		this.redeSocial = link;
	}

	public String getCpf() {
		return cpf;
	}
		
	public int calculaCompatibilidadeRota(Viagem viagem) {
		int quantidade = 0;
		for (String pontoPassageiro : this.getPontosFrequentes()) {
			for (String pontoRota : viagem.getPontosParada()) {
				if (pontoPassageiro.equals(pontoRota)) {
					quantidade += 1;
				}
			}
		}
		if (quantidade == 0) {
			return 0;
		} else if (quantidade == 1) {
			return 30;
		} else if (quantidade == 2) {
			return 70;
		} else {
			return 100;
		}
	}
	
	public void solicitarVaga(Viagem viagem) {
		viagem.adicionarInscrito(this);
	}
}

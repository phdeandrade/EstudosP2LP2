package provasAntigas.LitaPark;

import java.time.LocalTime;
import java.util.Objects;

public class Vaga {
	private String placa;
	private LocalTime hora;
	private String setor;
	private int posicao;
	private boolean ocupada;
	
	public Vaga(String setor, int posicao) {
		super();
		this.setor = setor;
		this.posicao = posicao;
		this.ocupada = false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(posicao, setor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		return posicao == other.posicao && Objects.equals(setor, other.setor);
	}

	@Override
	public String toString() {
		return "Vaga [setor=" + setor + ", posicao=" + posicao + ", ocupada=" + ocupada + "]";
	}

	public String getPlaca() {
		return this.placa;
	}

	public LocalTime getHora() {
		return this.hora;
	}

	public String getSetor() {
		return this.setor;
	}

	public int getPosicao() {
		return this.posicao;
	}

	public boolean isOcupada() {
		return this.ocupada;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
}

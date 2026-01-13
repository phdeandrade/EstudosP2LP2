package provasAntigas.LigadoNasEleicoesPresidenciais;

import java.util.Objects;

public class Candidato {
	private String nome;
	private String partido;
	private int id;
	private int votos;
	
	public Candidato(String nome, String partido, Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("Número de candidato vazio");
		}
		this.nome = nome;
		this.partido = partido;
		this.id = id;
		this.votos = 0;
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
		Candidato other = (Candidato) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return String.format("%s – %s – %d – %s", nome, partido, id, votos);
	}
	
	public void adicionarVoto() {
		this.votos += 1;
	}
	
	public String listarVotos() {
		return String.format("%d – %s", this.id, this.votos);
	}
	
	public void alterarNome(String novoNome) {
		this.nome = novoNome;
	}

	public String getNome() {
		return nome;
	}

	public String getPartido() {
		return partido;
	}

	public int getId() {
		return id;
	}

	public int getVotos() {
		return votos;
	}
	
}

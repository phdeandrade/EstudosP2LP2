package provasAntigas.BlaCarCar;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
	private String motorista;
	private String descricao;
	private int vagas;
	private String contato;
	private String[] pontosParada;
	private List<Passageiro> inscritos;
	private List<Passageiro> confirmados;
	
	public Viagem(String motorista, String descricao, int vagas, String contato, String[] pontosParada) {
		super();
		this.motorista = motorista;
		this.descricao = descricao;
		this.vagas = vagas;
		this.contato = contato;
		this.pontosParada = pontosParada;
		this.inscritos = new ArrayList<Passageiro>();
		this.confirmados = new ArrayList<Passageiro>();
	}
	
	public boolean adicionarInscrito(Passageiro passageiro) {
		if (this.confirmados.size() == vagas) {
			return false;
		}
		this.inscritos.add(passageiro);
		return true;
	}
	
	public void confirmarInscritos(int comp) {
		for (Passageiro inscrito : this.inscritos) {
			if (this.confirmados.size() < this.vagas && 
		            inscrito.calculaCompatibilidadeRota(this) >= comp && 
		            !this.confirmados.contains(inscrito)) {
				this.confirmados.add(inscrito);
			}
		}
	}
	
	public String[] getArrayInscritos() {
		int tamanho = this.inscritos.size();
		String[] inscritos = new String[tamanho];
		for (int i = 0; i < tamanho; i++) {
			Passageiro p = this.inscritos.get(i);
			inscritos[i] = "Nome: " + p.getNome() + "; Link Rede Social: " + p.getRedeSocial() + "; Compatibilidade: " + p.calculaCompatibilidadeRota(this);
		}
		return inscritos;
	}
	
	public String[] getArrayConfirmados() {
		int tamanho = this.confirmados.size();
		String[] confirmados = new String[tamanho];
		for (int i = 0; i < tamanho; i++) {
			Passageiro p = this.confirmados.get(i);
			confirmados[i] = "Nome: " + p.getNome() + "; Link Rede Social: " + p.getRedeSocial() + "; Compatibilidade: " + p.calculaCompatibilidadeRota(this);
		}
		return confirmados;
	}
	
	public String[] getInscritosCompativeis(int comp) {
		List<String> compativeis = new ArrayList<String>();
		for (Passageiro inscrito : this.inscritos ) {
			if (inscrito.calculaCompatibilidadeRota(this) >= comp) {
				String texto = "Nome: " + inscrito.getNome() + "; Link Rede Social: " + inscrito.getRedeSocial() + "; Compatibilidade: " + inscrito.calculaCompatibilidadeRota(this);
				compativeis.add(texto);
			}
		}
		return compativeis.toArray(new String[0]);
	}

	public String getMotorista() {
		return motorista;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getVagas() {
		return vagas;
	}

	public String[] getPontosParada() {
		return pontosParada;
	}
	
	public String getContato() {
		return contato;
	}
	
}

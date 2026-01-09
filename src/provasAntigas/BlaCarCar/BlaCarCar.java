package provasAntigas.BlaCarCar;

import java.util.ArrayList;
import java.util.List;

public class BlaCarCar {
	private List<Passageiro> passageiros;
	private List<Viagem> rotas;
	
	public BlaCarCar() {
		this.passageiros = new ArrayList<Passageiro>();
		this.rotas = new ArrayList<Viagem>();
	}
	
	public int cadastrarViagem(String motorista, String descricao, int vagas, String contato, String[] pontos) {
		Viagem rota = new Viagem(motorista, descricao, vagas, contato, pontos);
		this.rotas.add(rota);
		return this.rotas.indexOf(rota);
	}
	
	public boolean cadastrarPassageiro(String nome, String cpf, String link, String[] pontos) {
		Passageiro novo = new Passageiro(nome, cpf, link, pontos);
		if (this.passageiros.contains(novo)) {
			return false;
		}
		this.passageiros.add(novo);
		return true;
	}
	
	public boolean cadastrarPassageiro(String nome, String cpf, String[] pontos) {
		Passageiro novo = new Passageiro(nome, cpf, pontos);
		if (this.passageiros.contains(novo)) {
			return false;
		}
		this.passageiros.add(novo);
		return true;
	}
	
	public void atualizarLinkPerfil(String cpf, String novoLink) {
		if (buscaPassageiroCPF(cpf) != -1) {
			this.passageiros.get(buscaPassageiroCPF(cpf)).alterarLinkRedeSocial(novoLink);
		}
	}
	
	public String[] listarPassageiros() {
		String[] lista = new String[this.passageiros.size()];
		for (int i = 0; i < this.passageiros.size(); i++) {
			lista[i] = this.passageiros.get(i).toString();
		}
		return lista;
	}
	
	public void solicitarVaga(String cpf, int indexViagem) {
		this.passageiros.get(buscaPassageiroCPF(cpf)).solicitarVaga(this.rotas.get(indexViagem));
	}
	
	public String[] listarPassageirosInscritosViagem(int indexViagem) {
		return this.rotas.get(indexViagem).getArrayInscritos();
	}
	
	public String[] listarPassageirosConfirmadosViagem(int indexViagem) {
		return this.rotas.get(indexViagem).getArrayConfirmados();
	}
	
	public int calcularCompatibilidade(String cpf, int indexViagem) {
		return this.passageiros.get(buscaPassageiroCPF(cpf)).calculaCompatibilidadeRota(this.rotas.get(indexViagem));
	}
	
	public String[] listarPassageirosInscritosCompativeis(int indexViagem, int compatibilidade) {
		return this.rotas.get(indexViagem).getInscritosCompativeis(compatibilidade);
	}
	
	public String[] confirmarPassageiros(int indexViagem, int compatibilidade) {
		this.rotas.get(indexViagem).confirmarInscritos(compatibilidade);
		return this.rotas.get(indexViagem).getArrayConfirmados();
	}
	
	private int buscaPassageiroCPF(String cpf) {
		for (Passageiro passageiro : this.passageiros) {
			if (passageiro.getCpf().equals(cpf)) {
				return this.passageiros.indexOf(passageiro);
			}
		}
		throw new IllegalArgumentException("CPF Inexistente");
	}
}

package simulados.RepareBemColecoes;

import java.util.ArrayList;
import java.util.List;

public class RepareBem {
	private List<Reparo> reparos;
	private List<OrdemDeServico> ordensDeServico;
	
	public RepareBem() {
		this.reparos = new ArrayList<Reparo>();
		this.ordensDeServico = new ArrayList<OrdemDeServico>();
	}
	
	public void cadastrarReparo(String idReparo, String descricao, double preco) {
		if (idReparo.isBlank() || idReparo.isEmpty()) {
			throw new IllegalArgumentException("ID Inexistente");
		}
		Reparo novoReparo = new Reparo(idReparo, descricao, preco);
		if (! this.reparos.contains(novoReparo)) {
			this.reparos.add(novoReparo);
		}
	}
	
	public void reajustarPrecoReparo(String idReparo, double percentual) {
	    if (idReparo.isBlank() || idReparo.isEmpty()) {
	        throw new IllegalArgumentException("ID Inexistente");
	    }
	    int pos = buscaReparoId(idReparo);
	    if (pos == -1) {
	        throw new IllegalArgumentException("Reparo não encontrado"); // Obrigatório lançar exceção
	    }
	    this.reparos.get(pos).ajustePercentual(percentual);
	}
	
	public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
		OrdemDeServico os = new OrdemDeServico(cliente, telefone, roupa);
		if ( ! this.ordensDeServico.contains(os)) {
			this.ordensDeServico.add(os);
		}
		return this.ordensDeServico.indexOf(os) + 1;
	}
	
	public String exibirOrdemDeServico(int idOS) {
		if (idOS <= 0 || idOS > this.ordensDeServico.size()) {
			throw new IllegalArgumentException("ID Inexistente");
		}
		return "#" + idOS + 
				"; " + this.ordensDeServico.get(idOS - 1).toString();
	}
	
	public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
	    if (idOS <= 0 || idOS > this.ordensDeServico.size() || idReparo.isBlank() || idReparo.isEmpty()) {
	        throw new IllegalArgumentException("ID Inexistente");
	    }
	    
	    int pos = buscaReparoId(idReparo);
	    
	    if (pos == -1) {
	        throw new IllegalArgumentException("Reparo não encontrado"); // Obrigatório lançar exceção
	    }
	    
	    this.ordensDeServico.get(idOS - 1).adicionarReparo(this.reparos.get(pos));
	}
	
	public void mudarStatusOrdemDeServico(int idOS, String status) {
		if (idOS <= 0 || idOS > this.ordensDeServico.size()) {
			throw new IllegalArgumentException("ID Inexistente");
		}
		this.ordensDeServico.get(idOS - 1).alterarStatus(status);
	}
	
	public double obtemValorOrdemServico(int idOS) {
		if (idOS <= 0 || idOS > this.ordensDeServico.size()) {
			throw new IllegalArgumentException("ID Inexistente");
		}
		return this.ordensDeServico.get(idOS - 1).getPrecoTotal();
	}
	
	public String listarOrdemDeServico(String status) {
		String lista = "Ordens de Serviço - " + status + "\n";
		for (OrdemDeServico os : this.ordensDeServico) {
			if (os.getStatus().equals(status)) {
				lista += exibirOrdemDeServico(this.ordensDeServico.indexOf(os) + 1) + "\n";
			}
		}
		if (lista.equals("Ordens de Serviço - " + status + "\n")) {
			lista += "Não há ordens de serviço do tipo " + status;
		}
		return lista;
	}
	
	public String listarOrdemDeServico() {
		String lista = "Ordens de Serviço\n";
		for (OrdemDeServico os : this.ordensDeServico) {
			lista += exibirOrdemDeServico(this.ordensDeServico.indexOf(os) + 1) + "\n";
		}
		if (lista.equals("Ordens de Serviço\n")) {
			lista += "Não há ordens de serviço";
		}
		return lista;
	}
	
	private int buscaReparoId(String id) {
		for (int i = 0; i < this.reparos.size(); i++) {
			if (this.reparos.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}

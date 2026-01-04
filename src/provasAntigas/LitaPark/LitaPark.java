package provasAntigas.LitaPark;

import java.time.LocalTime;

public class LitaPark {
	private Vaga[] vagas;
	private double lucro;
	
	public LitaPark(int quantidade) {
		this.vagas = new Vaga[quantidade];
		this.lucro = 0.0;
		for (int i = 0; i < quantidade; i++) {
			this.vagas[i] = new Vaga("A", i + 1);
		}
	}
	
	public LitaPark() {
		this(50);
	}
	
	public boolean estacionarCarroVaga(LocalTime hora, String placa) {
		for (int i = 0; i < this.vagas.length; i++) {
			if (! this.vagas[i].isOcupada()) {
				this.vagas[i].estacionar(placa, hora);
				return true;
			}
		}
		return false;
	}
	
	public double liberarVaga(String placa, LocalTime horaSaida) {
        int i = 0;
        int pos = -1;
        while (i < this.vagas.length) {
            if (this.vagas[i].isOcupada() && this.vagas[i].getPlaca().equals(placa)) {
                pos = i;
                break;
            }
            i++;
        }

        if (pos == -1) return 0.0;

        Vaga vaga = this.vagas[pos];
        int horas = horaSaida.getHour() - vaga.getHora().getHour();
        if (horaSaida.getMinute() > vaga.getHora().getMinute()) {
            horas++;
        }

        double valor = 5.0;
        if (horas > 2) {
            valor += (horas - 2) * 1.0;
        }

        this.lucro += valor;
        this.vagas[pos].liberar();
        return valor;
    }
	
	public String painelVagasLivres() {
		String painel = "Vagas Livres: \n";
		for (int i = 0; i < this.vagas.length; i++) {
			if (!this.vagas[i].isOcupada()) {
				painel += this.vagas[i].toString();
			}
		}
		return painel;
	}
	
	public String localizarCarro(String placa) {
		for (int i = 0; i < this.vagas.length; i++) {
			if (this.vagas[i].getPlaca().equals(placa)) {
				return this.vagas[i].getLocalizacao();
			}
		}
		return "Não encontrado";
	}
	
	public String imprimirLucroTotal() {
		return "Lucro total do LitaPark: \nR$" + this.lucro;
	}
	
}

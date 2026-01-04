package provasAntigas.LitaPark;

import java.time.LocalTime;

public class LitaPark {
	private Vaga[] vagas;
	private int iVagas;
	
	public LitaPark(int quantidade) {
		this.vagas = new Vaga[quantidade];
		this.iVagas = 0;
	}
	
	public LitaPark() {
		this.vagas = new Vaga[50];
		this.iVagas = 0;
	}
	
	public boolean estacionarCarroVaga(LocalTime hora, String placa) {
		if (this.iVagas ++ >= vagas.length ) {
			return false;
		}
		this.vagas[this.iVagas].setHora(hora);
		this.vagas[this.iVagas].setPlaca(placa);
		this.vagas[this.iVagas].setOcupada(true);
		this.iVagas++;
		return true;
	}
	
	public double liberarVaga(String placa) {
		int pos = 0;
		for (int i = 0; i <= this.iVagas; i++) {
			if (this.vagas[i].getPlaca().equals(placa)) {
				pos = i;
			}
		}
		int hora = this.vagas[pos].getHora().getHour();
		int minutos = this.vagas[pos].getHora().getMinute();
		LocalTime fim = LocalTime.of(hora + 1, minutos + 1);
		int intervaloDeTempo = fim.getHour() - this.vagas[pos].getHora().getHour();
		this.vagas[pos].setHora(null);
		this.vagas[pos].setPlaca(null);
		this.vagas[pos].setOcupada(false);
		if (intervaloDeTempo - 2 == 0) {
			return 5.0;
		} else {
			return (intervaloDeTempo - 2) + 5.0;
		}
	}
}

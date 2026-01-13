package provasAntigas.LigadoNasEleicoesPresidenciais;

import java.util.Objects;

public class RegistroVoto {

    private int tituloEleitor;
    private String horaVotacao;

    public RegistroVoto(int tituloEleitor, String horaVotacao) {
            this.tituloEleitor = tituloEleitor;
            this.horaVotacao = horaVotacao;
    }

    public int getTituloEleitor() {
            return tituloEleitor;
    }

    public String getHoraVotacao() {
            return horaVotacao;
    }

	@Override
	public int hashCode() {
		return Objects.hash(tituloEleitor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroVoto other = (RegistroVoto) obj;
		return tituloEleitor == other.tituloEleitor;
	}

	@Override
	public String toString() {
		return String.format("%s – %s", tituloEleitor, horaVotacao);
	}
    
}


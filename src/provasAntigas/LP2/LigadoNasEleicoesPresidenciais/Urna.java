package provasAntigas.LP2.LigadoNasEleicoesPresidenciais;

public class Urna {
    private static final Candidato[] CANDIDATOS = {
            new Candidato("Lola", "PJ", 10),
            new Candidato("Bolsonaro", "PKM", 11),
            new Candidato("Jalkimin", "PSDD", 44),
            new Candidato("Ziro Gomes", "PLP", 20),
            new Candidato("Marília", "PSBV", 25)
    };
    private RegistroVoto[] votos;
    private int iVotos;

    public Urna() {
        this.votos = new RegistroVoto[100];
        this.iVotos = 0;
    }

    public boolean votar(int tituloEleitor, int numeroCandidato, String horaDoVoto) {
        int pos = buscaCandidatoId(numeroCandidato);
        if (pos == -1) {
            throw new IllegalArgumentException("Número de candidato inexistente");
        }
        if (this.iVotos >= 100) {
            return false;
        }
        if (votoJaRegistrado(tituloEleitor)) {
            return false;
        }
        this.votos[this.iVotos] = new RegistroVoto(tituloEleitor, horaDoVoto);
        this.iVotos++;
        CANDIDATOS[pos].adicionarVoto();
        return true;
    }

    public String listarVotos() {
        String lista = "";
        for (int i = 0; i < CANDIDATOS.length; i++) {
            lista += CANDIDATOS[i].listarVotos() + System.lineSeparator();
        }
        return lista;
    }

    public boolean checarUrna() {
        int somaVotosCandidatos = 0;
        for (int i = 0; i < CANDIDATOS.length; i++) {
            somaVotosCandidatos += CANDIDATOS[i].getVotos();
        }
        return (somaVotosCandidatos == this.iVotos);
    }

    private int buscaCandidatoId(int numero) {
        for (int i = 0; i < CANDIDATOS.length; i++) {
            if (CANDIDATOS[i].getId() == numero) {
                return i;
            }
        }
        return -1;
    }

    private boolean votoJaRegistrado(int tituloEleitor) {
        for (int i = 0; i < this.iVotos; i++) {
            if (this.votos[i].getTituloEleitor() == tituloEleitor) {
                return true;
            }
        }
        return false;
    }
}
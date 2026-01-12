package provasAntigas.HugsAndSmiles;

import java.util.Objects;

public class Cliente {
	private int id;
    private String nome;
    private String endereco;
    
    public Cliente(int id, String nome, String end) {
    	this.id = id;
    	this.nome = nome;
    	this.endereco = end;        
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
		Cliente other = (Cliente) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return String.format("Cliente [id=%s, nome=%s, endereco=%s]", id, nome, endereco);
	}

	public int getId() {
    	return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
}

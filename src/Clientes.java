
public class Clientes {
	private String CPF;
	private String localTrabalho;
	private String nome;
	private String email;
	
	public Clientes(String cPF, String localTrabalho, String nome, String email) {
		this.CPF = cPF;
		this.localTrabalho = localTrabalho;
		this.nome = nome;
		this.email = email;
	}
	
	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return CPF;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return this.nome+" - "+this.localTrabalho+" - "+this.email;
	}
	
}

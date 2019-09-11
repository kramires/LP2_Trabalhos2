package Curso;

public class Aluno extends Pessoa {
	
	private long ra;
	
	
	public Aluno(String nome, int idade, String cpf, String sexo, long ra) {
		super(nome, idade, cpf, sexo);
		this.ra = ra;
	}

	public Aluno() {
		super();
		
	}

	public long getRa() {
		return ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}
	
}


public class Operacao {
	
	private RecebeResultado resultado;
	
	public Operacao() {
	}
	
	public RecebeResultado getResultado() {
		return resultado;
	}

	public void setResultado(RecebeResultado resultado) {
		this.resultado = resultado;
	}

	public Operacao(RecebeResultado resultado) {
		this.resultado = resultado;
	}


	public int soma(int n1, int n2) {
		int soma = n1 + n2;
		return soma;
	}
	
	public int diferenca(int n1, int n2) {
		int diferenca = n1 - n2;
		return diferenca;
	}
	
	
	
}

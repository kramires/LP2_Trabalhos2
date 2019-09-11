import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Operacao op = new Operacao();
		RecebeResultado x = new RecebeResultado();
		
		boolean sair = true;
		do 
		{	
			 System.out.println("**********************************************************");
			 System.out.println();
			 System.out.println("                   MENU			 ");
			 System.out.println("               Informe a opcao do menu: ");
			 System.out.println("            Digite 1 - Somar Valores");
			 System.out.println("            Digite 2 - Subtrair Valores");
			 System.out.println("            Digite 3 - Sair");
			 System.out.println();
			 System.out.println("**********************************************************");
		   
		   int opcao = ler.nextInt();
		   int n1;
		   int n2;
		   int resultado;
		   
		   switch(opcao){
		   
			case 1:
				System.out.println("Digite dois números inteiros");
				System.out.println("Digite o primeiro número inteiro");
				n1 = ler.nextInt();
				System.out.println("Digite o segundo número inteiro");
				n2 = ler.nextInt();

				
				if(n1 < 0 || n2 < 0)
					System.out.println("Número inválido");
				
				else {
					resultado = op.soma(n1, n2);
					x.imprime(resultado);
				}
				break;
				
			case 2:
				System.out.println("Digite dois números inteiros");
				System.out.println("Digite o primeiro número inteiro");
				n1 = ler.nextInt();
				System.out.println("Digite o segundo número inteiro");
				n2 = ler.nextInt();
				
				if(n1 < 0 || n2 < 0)
					System.out.println("Número inválido");
				
				else {
					resultado = op.diferenca(n1, n2);
					x.imprime(resultado);
				}
				break;
				
			case 3:
				sair = false;
				break;
		   }
		
		}while(sair);
		System.out.println("Programa Finalizado!!");
	}
}
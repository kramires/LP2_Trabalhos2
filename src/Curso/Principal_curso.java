package Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Principal_curso {

	public static void main(String[] args) {
		
			
			Leitura ler = new Leitura();
			CursoDao c = new CursoDao();
			c.popularLista();
			
			boolean sair = true;
			do 
			{	
				 String menu;
				 menu = "**********************************************************\n" +
				 "                   MENU			 \n" +
				 "               Informe a opcao do menu: \n" +
				 "            Digite 1 - Salvar\n" + 
				 "            Digite 2 - Exibir todos\n" +
				 "            Digite 3 - Remover\n" +
				 "            Digite 4 - Sair\n" +
				 "**********************************************************\n";
				
			   
			   int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			  
			   switch(opcao){
			   
				case 1:
					
					
					boolean manter = true;
					do 
					{	
						
						 menu = "**********************************************************\n" +
						 "                   MENU			 \n" +
						 "               Informe Quem será adicionado: \n" +
						 "            Digite 1 - Professor\n"+
						 "            Digite 2 - Aluno\n" +
						 "            Digite 3 - Sair\n" + 
						 
						 "**********************************************************\n";
						 int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
						switch(op){
						   
						case 1:
							ler.leitura(1, c);
							break;
						case 2: 
							ler.leitura(2, c);
							break;
						case 3:
							manter = false;
							break;
						}
					}while(manter);
					break;
					
				case 2:
					//c.exibirTodos();
					JOptionPane.showMessageDialog(null, c.exibirTodos());
					
					break;
					
				case 3:
					String cpf = JOptionPane.showInputDialog("Digite o CPF da pessoa a ser removida: ");
					c.RemoverPessoa(cpf);
					break;
					
				case 4:
					sair = false;
					break;
			   }
			
			}while(sair);
			JOptionPane.showMessageDialog(null, "Programa Finalizado!!");
		}

	

}

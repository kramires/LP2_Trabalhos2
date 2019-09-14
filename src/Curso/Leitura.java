package Curso;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Leitura {
	
	
	
	String nome;
	int idade;
	String cpf;
	String sexo;
	
	
	public void leitura(int tipo, CursoDao curso) {
		if (tipo == 1) {
			int siape;
			Professor p = new Professor();
			//nome = JOptionPane.showInputDialog("Nome:");
			p.setNome("Pedro");
			//idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
			p.setIdade(40);
			//cpf = JOptionPane.showInputDialog("CPF: ");
			p.setCpf("019382012983");
			//sexo = JOptionPane.showInputDialog("Sexo: ");
			p.setSexo("Masculino");
			//siape = Integer.parseInt(JOptionPane.showInputDialog("SIAPE: "));
			p.setSiape(123);
			//curso.SalvarPessoa(p);
			curso.salvaNoBD(p);
		}
		else {
			Aluno a = new Aluno();
			
			nome = JOptionPane.showInputDialog("Nome:");
			a.setNome(nome);
			idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
			a.setIdade(idade);
			cpf = JOptionPane.showInputDialog("CPF: ");
			a.setCpf(cpf);
			sexo = JOptionPane.showInputDialog("Sexo: ");
			a.setSexo(sexo);
			long ra = Integer.parseInt(JOptionPane.showInputDialog("RA: "));
			a.setRa(ra);
			curso.SalvarPessoa(a);
			
		}
		
	}
	
}

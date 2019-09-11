package Curso;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CursoDao {
	List<Pessoa> pessoas = new ArrayList<>();
	
	public void popularLista() {
		pessoas.add(new Professor("Aurelio", 32, "123", "M", 1234 ));
		pessoas.add(new Professor("Roosevelt", 38, "321", "M", 987 ));
		pessoas.add(new Professor("Diego", 34, "456", "M", 4654 ));
		pessoas.add(new Aluno("Klayton", 35, "047", "M", 908098009));
		pessoas.add(new Aluno("Jesus", 26, "098", "M", 709806679));
		pessoas.add(new Aluno("Deric", 19, "543", "M", 874812191));
	}
	
	public void SalvarPessoa (Pessoa p) {
		pessoas.add(p);
		JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso!!" );
	}
	
	public void RemoverPessoa(String cpf) {
		for(int i = 0; i < pessoas.size(); i++)
			if(pessoas.get(i).getCpf().equals(cpf)) {
				pessoas.remove(i);
			JOptionPane.showMessageDialog(null,"Pessoa removida com sucesso!!" );
		}
	}
	
	public String exibirTodos() {
		
		String p = "";
		for(int i = 0; i < pessoas.size(); i++) {
			
			if(pessoas.get(i) instanceof Aluno) {
				Aluno aa = (Aluno) pessoas.get(i);
			p = p + "Nome: " + aa.getNome() +
					" - CPF: " + aa.getCpf() +
					" - Aluno\n";
			
			}
			else if(pessoas.get(i) instanceof Professor) {
				Professor pp = (Professor) pessoas.get(i);
				 p = p + "Nome: " + pp.getNome() +
						" - CPF: " + pp.getCpf() +
						" - Professsor\n";
				}
			
			}
		return p;
		}
	
	public void salvaNoBD(Professor professor) {
		try {
			DriverManager.getConnection("jdbc:mysql://localhost/lp2" , "root", "");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
			

	}
}


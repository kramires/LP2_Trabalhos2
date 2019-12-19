
package entradasdedados;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.AlunoModel;

public class AlunoEntradaDeDados {

    public AlunoModel entradaAluno() throws SQLException {
        AlunoModel aluno = new AlunoModel();
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setSexo(JOptionPane.showInputDialog("Sexo: ")); 
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));        
        return aluno;
    }

    public long leituraCPF() {
        long cpf = Long.parseLong(JOptionPane.showInputDialog("Entre com o CPF: "));
        return cpf;
    }

}


package dao;

import entradasdedados.AlunoEntradaDeDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;


public class AlunoDAO extends Conexao {

    public void salvarOuAtualizar(AlunoModel aluno) throws SQLException {
        try {
            super.iniciar();
            super.getSessao().saveOrUpdate(aluno);
            super.fechar();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }

    public AlunoModel buscarAlunoPorCPF(long cpf) throws SQLException {
        List<AlunoModel> listaDeAluno = new ArrayList<>();
        try {
            iniciar();
            listaDeAluno = getSessao().createQuery("from PessoaModel where cpf= "+cpf+"").list();
            fechar();
            if(!listaDeAluno.isEmpty()){
            return listaDeAluno.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    
       public List<AlunoModel> buscarTodos() {
        List<AlunoModel> listaDeAlunos = new ArrayList<>();
        try {
            iniciar();
            listaDeAlunos = getSessao().createQuery("from AlunoModel").list();
            fechar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeAlunos;
    }

    public void remover(AlunoModel aluno) throws SQLException {
          try {
            iniciar();
            getSessao().delete(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    } 
    
}

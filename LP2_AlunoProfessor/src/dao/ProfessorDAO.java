package dao;

import entradasdedados.ProfessorEntradaDeDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ProfessorModel;

public class ProfessorDAO extends Conexao {

    public void salvarOuAtualizar(ProfessorModel professor) throws SQLException {
        try {
            super.iniciar();
            super.getSessao().saveOrUpdate(professor);
            super.fechar();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }

    public ProfessorModel buscarProfessorPorCPF(long cpf) throws SQLException {
        List<ProfessorModel> listaDeProfessor = new ArrayList<>();
        try {
            iniciar();
            listaDeProfessor = getSessao().createQuery("from PessoaModel where cpf= " + cpf + "").list();
            fechar();
            if (!listaDeProfessor.isEmpty()) {
                return listaDeProfessor.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }

    public List<ProfessorModel> buscarTodos() {
        List<ProfessorModel> listaDeProfessor = new ArrayList<>();
        try {
            iniciar();
            listaDeProfessor = getSessao().createQuery("from ProfessorModel").list();
            fechar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeProfessor;
    }

    public void remover(ProfessorModel professor) throws SQLException {
        try {
            iniciar();
            getSessao().delete(professor);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }

}

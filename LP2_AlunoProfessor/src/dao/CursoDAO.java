
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CursoModel;

public class CursoDAO extends Conexao{
    public void salvarOuAtualizar(CursoModel curso) {
        try {
            iniciar();
            getSessao().saveOrUpdate(curso);
            fechar();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
    
    public CursoModel buscarPorId(int id) {
        try {
            iniciar();
            CursoModel curso = (CursoModel) getSessao().get(CursoModel.class, id);
            fechar();
            return curso;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    
    public List<CursoModel> buscarTodos() {
        List<CursoModel> listaDeCurso = new ArrayList<>();
        try {
            iniciar();
            listaDeCurso= getSessao().createQuery("from CursoModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeCurso;
    }
    
    public void remover(CursoModel curso) {
        try {
            iniciar();
            getSessao().delete(curso);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }
}

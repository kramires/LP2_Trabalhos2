package entradasdedados;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.ProfessorDAO;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;
import modelo.CursoModel;
import modelo.ProfessorModel;

public class CursoEntradaDeDados {

    public CursoModel entradaCurso() {
        CursoModel curso = new CursoModel();
        ProfessorDAO daoProfessor = new ProfessorDAO();
        ProfessorModel modelProfessor = new ProfessorModel();
        String imprime = "";

        List<ProfessorModel> listaDeProfessores = daoProfessor.buscarTodos();
        for (ProfessorModel professor : listaDeProfessores) {
            imprime = imprime + "Professor: " + "ID: " + professor.getIdpessoa() + " - Nome: " + professor.getNome() + "\n";
        }
        boolean x = false;

        int id = Integer.parseInt(JOptionPane.showInputDialog(imprime + "Entre com ID do Professor: "));
        
        for (ProfessorModel professor : listaDeProfessores) {
            if (professor.getIdpessoa() == id) {
                curso.setProfessor(professor);
                x = true;
            }

        }

        if (x == (true)) {
            curso.setTitulo(JOptionPane.showInputDialog("Digite o Título do Curso: "));
            curso.setDescrição(JOptionPane.showInputDialog("Digite a Descrição do Curso: "));
            curso.setLocal(JOptionPane.showInputDialog("Digite o Local do Curso: "));
            curso.setVagas(parseInt(JOptionPane.showInputDialog("Digite o Nr de Vagas do Curso: ")));
        }
        return curso;
    }

    public CursoModel novaEntradaCurso(CursoModel curso) {
        curso.setTitulo(JOptionPane.showInputDialog("Digite o novo Título do Curso: "));
        curso.setDescrição(JOptionPane.showInputDialog("Digite a nova Descrição do Curso: "));
        curso.setLocal(JOptionPane.showInputDialog("Digite o novo Local do Curso: "));
        curso.setVagas(parseInt(JOptionPane.showInputDialog("Digite o novo Nr de Vagas do Curso: ")));
        return curso;
    }

    public int informarID(String acao) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de quem deseja " + acao + ": "));

        return id;
    }

    public CursoModel CursoAluno() throws SQLException {
        CursoDAO daoCurso = new CursoDAO();
        CursoModel curso = new CursoModel();
        AlunoDAO daoAluno = new AlunoDAO();
        AlunoModel aluno = new AlunoModel();
        String imprimeCurso = "";
        String imprimeAluno = "";

        boolean x = false;

        List<CursoModel> listaDeCursos = new ArrayList<CursoModel>();
        listaDeCursos = daoCurso.buscarTodos();
        for (CursoModel modelCurso : listaDeCursos) {
            imprimeCurso = imprimeCurso + "ID: " + modelCurso.getID() + " - Título do Curso " + modelCurso.getTitulo() + "\n";
        }
        int idCurso = Integer.parseInt(JOptionPane.showInputDialog(imprimeCurso + "Entre com ID do Curso: "));

        List<AlunoModel> listaDeAlunos = new ArrayList<AlunoModel>();
        listaDeAlunos = daoAluno.buscarTodos();

        for (AlunoModel modelAluno : listaDeAlunos) {
            imprimeAluno = imprimeAluno + "CPF: " + modelAluno.getCpf() + " - Nome do Aluno: " + modelAluno.getNome() + "\n";
        }
        long cpf = Long.parseLong(JOptionPane.showInputDialog(imprimeAluno + "Entre com CPF do Aluno: "));
        
        for (AlunoModel modelAluno : listaDeAlunos) {
            if (modelAluno.getCpf() == cpf) {
                curso = daoCurso.buscarPorId(idCurso);
                List<AlunoModel> listaDeAlunos2 = curso.getListaDeAlunos();
                listaDeAlunos2.add(modelAluno);
                
                curso.setListaDeAlunos(listaDeAlunos2);
                daoCurso.salvarOuAtualizar(curso);
            }
        }

        return curso;
    }

}

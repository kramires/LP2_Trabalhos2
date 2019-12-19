
package pkg19_02_lp2_alunoprofessor;

import entradasdedados.AlunoEntradaDeDados;
import dao.AlunoDAO;
import dao.AreaDAO;
import dao.CursoDAO;
import dao.ProfessorDAO;
import entradasdedados.AreaEntradaDeDados;
import entradasdedados.CursoEntradaDeDados;
import entradasdedados.ProfessorEntradaDeDados;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;
import modelo.AreaModel;
import modelo.CursoModel;
import modelo.ProfessorModel;

public class Main {

   
    public static void main(String[] args) throws SQLException {
        AlunoEntradaDeDados entradaAluno = new AlunoEntradaDeDados();
        AreaEntradaDeDados entradaArea = new AreaEntradaDeDados();
        CursoEntradaDeDados entradaCurso = new CursoEntradaDeDados();
        ProfessorEntradaDeDados entradaProfessor = new ProfessorEntradaDeDados();
        
        AlunoDAO daoAluno = new AlunoDAO();
        AreaDAO daoArea = new AreaDAO();
        CursoDAO daoCurso = new CursoDAO();
        ProfessorDAO daoProfessor = new ProfessorDAO();
        
        AreaModel areaModel = new AreaModel();
        AlunoModel alunoModel = new AlunoModel();
        ProfessorModel professorModel = new ProfessorModel();
        CursoModel cursoModel = new CursoModel();
        
        String menu = "0- Sair\n1 - Aluno\n2 - Area\n3 - Professor \n4 - Curso";
        String menuAluno = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Por CPF\n4 - Exibir Todos\n5 - Editar\n6 - Remover";
        String menuArea = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Editar\n5 - Remover\n6 - Exibir Por ID";
        String menuProfessor= "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Por CPF\n4 - Exibir Todos\n5 - Editar\n6 - Remover";
        String menuCurso = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Editar\n5 - Remover\n6 - Exibir Por ID\n7 - Matricular Aluno em Curso\n8 - Exibir Alunos matriculados por curso";
        long  cpf;
        String imprime = "";
       
        String opt = "";
        do {
            String imprimeAluno="";
            String imprimeAlunoCpf="";
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                    opt = JOptionPane.showInputDialog(menuAluno);
                    switch (opt) {
                        case "1":
                            break;
                        case "2":
                            daoAluno.salvarOuAtualizar(entradaAluno.entradaAluno());
                            break;
                        case "3":
                           cpf = entradaAluno.leituraCPF();
                            alunoModel = daoAluno.buscarAlunoPorCPF(cpf);
                            imprimeAlunoCpf = "  Aluno\nNome:  " + alunoModel.getNome() + "\nCPF: " + alunoModel.getCpf() +
                                        "\nIdade: " + alunoModel.getIdade() + "\nSexo: " + alunoModel.getSexo() + "\nRA: " + alunoModel.getRa();
                                JOptionPane.showMessageDialog(null, imprimeAlunoCpf);
                            break;
                        case "4":
                            List<AlunoModel> listaDeAlunos = daoAluno.buscarTodos();
                            for (AlunoModel aluno : listaDeAlunos) {
                                imprimeAluno = imprimeAluno + "Aluno - Nome:  " + aluno.getNome() + " - CPF: " + aluno.getCpf() +
                                        " - Idade: " + aluno.getIdade() + " - Sexo: " + aluno.getSexo() + " - RA: " + aluno.getRa()+ "\n";
                            }
                            JOptionPane.showMessageDialog(null, imprimeAluno);
                            break;
                        case "5":
                            alunoModel = daoAluno.buscarAlunoPorCPF(entradaAluno.leituraCPF());
                            if(alunoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado aluno com o CPF informado");
                            }else{
                                alunoModel = entradaAluno.entradaAluno();
                                daoAluno.salvarOuAtualizar(alunoModel);
                            }
                            break;
                        case "6":
                             alunoModel = daoAluno.buscarAlunoPorCPF(entradaAluno.leituraCPF());
                            if(alunoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoAluno.remover(alunoModel);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "2":
                    opt = JOptionPane.showInputDialog(menuArea);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            daoArea.salvarOuAtualizar(entradaArea.entradaArea());
                            break;
                        case "3":
                            List<AreaModel> listaDeArea = daoArea.buscarTodos();
                            for (AreaModel area : listaDeArea) {
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + area.getDescricao());
                            }
                            break;
                        case "4":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Editar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoArea.salvarOuAtualizar(entradaArea.novaEntradaArea(areaModel));
                            }
                            break;
                        case "5":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Remover"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoArea.remover(areaModel);
                            }
                            break;
                        case "6":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Buscar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + areaModel.getDescricao());
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                    
                case "3":
                       opt = JOptionPane.showInputDialog(menuProfessor);
                    switch (opt) {
                        case "1":
                            break;
                        case "2":
                            daoProfessor.salvarOuAtualizar(entradaProfessor.entradaProfessor());
                            break;
                        case "3":
                           String imprimeProf = "";
                           cpf = entradaProfessor.leituraCPF();
                            professorModel = daoProfessor.buscarProfessorPorCPF(cpf);
                            imprimeProf = "  Professor\nNome:  " + professorModel.getNome() + "\nCPF: " + professorModel.getCpf() +
                                        "\nIdade: " + professorModel.getIdade() + "\nSexo: " + professorModel.getSexo() + "\nSIAPE: " + professorModel.getSiape() + "\nÁrea: " + professorModel.getArea().getDescricao();
                                JOptionPane.showMessageDialog(null, imprimeProf);
                            break;
                        case "4":
                            String imprimeProf2 = "";
                            List<ProfessorModel> listaDeProfessor = daoProfessor.buscarTodos();
                            for (ProfessorModel professor : listaDeProfessor) {
                                imprimeProf2 = imprimeProf2 + "Professor - Nome:  " + professor.getNome() + " - CPF: " + professor.getCpf() +
                                        " - Idade: " + professor.getIdade() + " - Sexo: " 
                                        + professor.getSexo() + " - SIAPE: " + professor.getSiape() + " - Área: " + professor.getArea().getDescricao() + "\n";
                            }
                             JOptionPane.showMessageDialog(null, imprimeProf2);
                            break;
                        case "5":
                            professorModel = daoProfessor.buscarProfessorPorCPF(entradaProfessor.leituraCPF());
                            if(professorModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado professor com o CPF informado");
                            }else{
                                professorModel = entradaProfessor.entradaProfessor();
                                daoProfessor.salvarOuAtualizar(professorModel);
                            }
                            break;
                        case "6":
                            professorModel = daoProfessor.buscarProfessorPorCPF(entradaProfessor.leituraCPF());
                            if(professorModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado professor com com o CPF informado");
                            }else{
                                daoProfessor.remover(professorModel);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "4":
                    opt = JOptionPane.showInputDialog(menuCurso);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            daoCurso.salvarOuAtualizar(entradaCurso.entradaCurso());
                            break;
                        case "3":
                            List<CursoModel> listaDeCurso = daoCurso.buscarTodos();
                            String imprimeCurso = "";
                            for (CursoModel curso : listaDeCurso) {
                                
                                imprimeCurso =  imprimeCurso + "Curso - ID: " + curso.getID()+  " - Título:  " + curso.getTitulo() + " - Descrição: " + curso.getDescrição() +
                                        " - Local: " + curso.getLocal() +
                                        " - Nr de Vagas: " + curso.getVagas() + "Professor: " + curso.getProfessor().getNome() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, imprimeCurso);
                            break;
                        case "4":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Editar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado curso com a ID informado");
                            }else{
                                daoCurso.salvarOuAtualizar(entradaCurso.novaEntradaCurso(cursoModel));
                            }
                            break;
                        case "5":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Remover"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado curso com a ID informado");
                            }else{
                                daoCurso.remover(cursoModel);
                            }
                            break;
                        case "6":
                            String imprimeCurso2 = "";
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Buscar"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado curso com a ID informado");
                            }else{
                                imprimeCurso2 = "  Curso\nTítulo:  " + cursoModel.getTitulo() + "\nDescrição: " + cursoModel.getDescrição() +
                                        "\nLocal: " + cursoModel.getLocal() + "\nNr de Vagas: " + " " + cursoModel.getVagas(); 
                                JOptionPane.showMessageDialog(null, imprimeCurso2);
                            }
                            break;
                        case "7":
                            cursoModel = entradaCurso.CursoAluno();
                            String imprimeCurso3 = "Aluno inserido no Curso: " + cursoModel.getTitulo();
                            JOptionPane.showMessageDialog(null, imprimeCurso3);
                            break;
                        
                        case "8":
                            String imprimeAlunoCurso = "";
                            String imprimeCurso4 = "";
                            List<AlunoModel> listaDeAlunos2 = new ArrayList<AlunoModel>();
                            List<CursoModel> listaDeCursos = new ArrayList<CursoModel>();
                            listaDeCursos = daoCurso.buscarTodos();
                            for (CursoModel modelCurso : listaDeCursos) {
                                imprimeCurso4 = imprimeCurso4 + "ID: " + modelCurso.getID() + " - Título do Curso " + modelCurso.getTitulo() + "\n";
                            }
                            cursoModel = daoCurso.buscarPorId(Integer.parseInt(JOptionPane.showInputDialog(imprimeCurso4 + "Entre com ID do Curso: ")));
                            listaDeAlunos2 = cursoModel.getListaDeAlunos();
                            
                            for (AlunoModel modelAluno : listaDeAlunos2) {
                                imprimeAlunoCurso = imprimeAlunoCurso + "CPF: " + modelAluno.getCpf() + " - Nome do Aluno: " + modelAluno.getNome() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, "Aluno Matriculados no Curso: " 
                            + cursoModel.getTitulo() + "\n" 
                            + imprimeAlunoCurso);

                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
        daoAluno.encerrar();
    }

}

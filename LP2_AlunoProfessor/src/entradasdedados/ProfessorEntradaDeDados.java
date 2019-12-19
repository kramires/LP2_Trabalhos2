package entradasdedados;

import dao.AreaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AreaModel;
import modelo.ProfessorModel;
import entradasdedados.AreaEntradaDeDados;

public class ProfessorEntradaDeDados {

    public ProfessorModel entradaProfessor() throws SQLException {
        AreaDAO daoArea = new AreaDAO();
        AreaModel modelArea = new AreaModel();
        String imprime = "";
        ProfessorModel professor = new ProfessorModel();

        List<AreaModel> listaDeArea = daoArea.buscarTodos();
        for (AreaModel area : listaDeArea) {
            imprime = imprime + "ID: " + area.getId() + " - Descrição da Area: " + area.getDescricao() + "\n";
        }
        boolean x = false;

        int id = Integer.parseInt(JOptionPane.showInputDialog(imprime + "Entre com ID da área do Professor: "));

        for (AreaModel area : listaDeArea) {
            if (area.getId() == id) {
                professor.setArea(area);
                x = true;

            }
            /*else{
                        JOptionPane.showMessageDialog(null, "Essa área não existe");
                    }*/
        }

        if (x == (true)) {

            professor.setNome(JOptionPane.showInputDialog("Nome: "));
            professor.setSexo(JOptionPane.showInputDialog("Sexo: "));
            professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
            professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
            professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("SIAPE: ")));
            return professor;
        }
        return null;
    }

    public Long leituraCPF() {
        long cpf = Long.parseLong(JOptionPane.showInputDialog("Entre com o CPF: "));
        return cpf;
    }

}

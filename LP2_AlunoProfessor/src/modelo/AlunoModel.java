
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
 public class AlunoModel extends PessoaModel implements Serializable{
    
    private int ra;
    
    @ManyToMany(mappedBy = "listaDeAlunos")
    private List<CursoModel> listaDeCursos = new ArrayList<CursoModel>();

    public void setListaDeCursos(List<CursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }
    
    public AlunoModel(String nome, int idade, long cpf, String sexo) {
        super(nome, idade, cpf, sexo);
    }   

    public AlunoModel(AlunoModel aluno) {
        super(aluno.getNome(), aluno.getIdade(), aluno.getCpf(), aluno.getSexo());
    }   

    public AlunoModel() {
        super();
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
    
}

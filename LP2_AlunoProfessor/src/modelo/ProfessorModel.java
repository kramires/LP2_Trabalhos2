
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class ProfessorModel extends PessoaModel implements Serializable{
    private long siape;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idArea", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AreaModel area;
    
    @OneToMany(mappedBy="professor", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<CursoModel> listaDeCursos;

    public List<CursoModel> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<CursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public ProfessorModel() {
    }
    
    public ProfessorModel(String nome, int idade, long cpf, String sexo) {
        super(nome, idade, cpf, sexo);
    }
    public ProfessorModel(ProfessorModel professor) {
        super(professor.getNome(), professor.getIdade(), professor.getCpf(), professor.getSexo());
    } 

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }
    
    
    public long getSiape() {
        return siape;
    }

    public void setSiape(long siape) {
        this.siape = siape;
    }
}

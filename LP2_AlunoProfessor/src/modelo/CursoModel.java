
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "Curso")
public class CursoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 40, nullable = false)
    private String titulo; 
    
    @Column(length = 40, nullable = false)
    private String descrição;
    
    @Column(length = 40, nullable = false)
    private String localizacao;
    
    @Column(length = 5, nullable = false)
    private int vagas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idProfessor", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    //@Cascade(CascadeType.SAVE_UPDATE)
    private ProfessorModel professor;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cursoAluno",
    joinColumns = @JoinColumn(name = "curso_id"),
    inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<AlunoModel> listaDeAlunos = new ArrayList<AlunoModel>();

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }


    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

  
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    public CursoModel() {
    }
    
    public CursoModel(int id, String titulo, String descrição, String localizacao, int vagas) {
        this.id = id;
        this.titulo = titulo;
        this.descrição = descrição;
        this.localizacao = localizacao;
        this.vagas = vagas;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getLocal() {
        return localizacao;
    }

    public void setLocal(String local) {
        this.localizacao = local;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    
    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }
    
}

package ada.tech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;
    @ManyToMany
    private List<Professor> professores;
    @OneToMany(mappedBy = "disciplina")
    private List<Aluno> alunos;

}

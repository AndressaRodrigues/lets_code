package ada.tech.dto;

import ada.tech.model.Aluno;
import ada.tech.model.Curso;
import ada.tech.model.Disciplina;
import ada.tech.model.Professor;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DisciplinaDto {
    private String nome;

    public static DisciplinaDto from (Disciplina disciplina) {;
        final DisciplinaDtoBuilder disciplinaDtoBuilder = new DisciplinaDtoBuilder();
        disciplinaDtoBuilder.nome = disciplina.getNome();
        return disciplinaDtoBuilder.build();
    }
}
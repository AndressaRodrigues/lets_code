package ada.tech.dto;

import ada.tech.model.Professor;
import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessorDto {
    private String nome;
    private String titulo;
    private char sexo;

    public static ProfessorDto from (Professor professor) {
        final ProfessorDto.ProfessorDtoBuilder professorDtoBuilder = new ProfessorDto.ProfessorDtoBuilder();
        professorDtoBuilder.nome = professor.getNome();
        professorDtoBuilder.titulo = professor.getTitulo();
        professorDtoBuilder.sexo = professor.getSexo();
        return professorDtoBuilder.build();
    }

}

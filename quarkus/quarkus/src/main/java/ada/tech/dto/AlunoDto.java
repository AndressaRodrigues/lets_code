package ada.tech.dto;

import ada.tech.model.Aluno;
import ada.tech.model.Disciplina;
import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private String nome;
    private char sexo;


    public static AlunoDto from (Aluno aluno) {
        final AlunoDtoBuilder alunoDtoBuilder = new AlunoDtoBuilder();
        alunoDtoBuilder.nome = aluno.getNome();
        alunoDtoBuilder.sexo = aluno.getSexo();
        return alunoDtoBuilder.build();
    }

    @Override
    public String toString() {
        return "O meu nome é: " + nome;
    }

}

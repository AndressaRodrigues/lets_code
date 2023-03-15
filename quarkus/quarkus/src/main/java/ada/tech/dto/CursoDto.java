package ada.tech.dto;

import ada.tech.model.Curso;
import ada.tech.model.Disciplina;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class CursoDto {
    private String nome;
    private String descricao;
    private int duracao;

    public static CursoDto from (Curso curso) {
        final CursoDtoBuilder cursoDtoBuilder = new CursoDtoBuilder();
        cursoDtoBuilder.nome = curso.getNome();
        cursoDtoBuilder.descricao = curso.getDescricao();
        cursoDtoBuilder.duracao = curso.getDuracao();
        return cursoDtoBuilder.build();
    }
}

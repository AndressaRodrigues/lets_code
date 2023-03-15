package ada.tech.dao;

import ada.tech.dto.CursoDto;
import ada.tech.model.Curso;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class CursoDao implements PanacheRepositoryBase<Curso, Integer> {
    public Curso findCurso(int id) {
        return findById(id);
    }

    public void deleteCurso(int id) {
        deleteById(id);
    }

    public void createCurso(CursoDto cursoDto) {
        Curso curso = new Curso();
        curso.setNome(cursoDto.getNome());
        curso.setDescricao(cursoDto.getDescricao());
        curso.setDuracao(cursoDto.getDuracao());
        persist(curso);
    }

    public void updateCurso(int id, CursoDto cursoDto) {
        String nome = cursoDto.getNome();
        int duracao = cursoDto.getDuracao();
        String descricao = cursoDto.getDescricao();
        update("update Curso c set c.nome = :nome, c.duracao = :duracao, c.descricao = :descricao where c.id = :id",
                Parameters.with("nome", nome).and("duracao", duracao).and("descricao", descricao).and("id", id));
    }

    public List<Curso> findAllCursos() {
        return (List<Curso>) findAll();
    }
}

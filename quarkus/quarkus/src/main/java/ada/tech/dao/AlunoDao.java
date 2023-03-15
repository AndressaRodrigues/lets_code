package ada.tech.dao;

import ada.tech.dto.AlunoDto;
import ada.tech.model.Aluno;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class AlunoDao implements PanacheRepositoryBase<Aluno, Integer> {
    public Aluno findAluno(int id) {
        return findById(id);
    }

    public void deleteAluno(int id) {
        deleteById(id);
    }

    public void createAluno(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDto.getNome());
        aluno.setSexo(alunoDto.getSexo());
        persist(aluno);
    }

    public void updateAluno(int id, AlunoDto alunoDto) {
        String nome = alunoDto.getNome();
        char sexo = alunoDto.getSexo();
        update("update Aluno a set a.nome = :nome, a.sexo = :sexo where a.id = :id",
                Parameters.with("nome", nome).and("sexo", sexo).and("id", id));
    }

    public List<Aluno> findAllAlunos() {
        return (List<Aluno>) findAll();
    }
}

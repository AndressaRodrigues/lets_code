package ada.tech.dao;

import ada.tech.dto.ProfessorDto;
import ada.tech.model.Professor;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;

import java.util.List;

@ApplicationScoped
public class ProfessorDao implements PanacheRepositoryBase<Professor, Integer> {
    public Professor findProfessor(int id) {
        return findById(id);
    }

    public void deleteProfessor(int id) {
        deleteById(id);
    }

    public void createProfessor(ProfessorDto professorDto) {
        Professor professor = new Professor();
        professor.setNome(professorDto.getNome());
        professor.setSexo(professorDto.getSexo());
        professor.setTitulo(professorDto.getTitulo());
        persist(professor);
    }

    public void updateProfessor(int id, ProfessorDto professorDto) {
        String nome = professorDto.getNome();
        char sexo = professorDto.getSexo();
        String titulo = professorDto.getTitulo();
        update("update Professor p set p.nome = :nome, p.sexo = :sexo, p.titulo = :titulo where p.id = :id",
                Parameters.with("nome", nome).and("sexo", sexo).and("titulo", titulo).and("id", id) );
    }

    public List<Professor> findAllProfessores() {
        return findAll().list();
    }
}

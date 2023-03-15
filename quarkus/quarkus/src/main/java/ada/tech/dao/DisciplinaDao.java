package ada.tech.dao;

import ada.tech.dto.DisciplinaDto;
import ada.tech.model.Disciplina;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class DisciplinaDao implements PanacheRepositoryBase<Disciplina, Integer> {
    public Disciplina findDisciplina(int id) {
        return findById(id);
    }

    public void deleteDisciplina(int id) {
        deleteById(id);
    }

    public void createDisciplina(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDto.getNome());
        persist(disciplina);
    }

    public void updateDisciplina(int id, DisciplinaDto disciplinaDto) {
        String nome = disciplinaDto.getNome();
        update("update Disciplina d set d.nome = :nome where d.id = :id",
                Parameters.with("nome", nome).and("id", id));
    }

    public List<Disciplina> findAllDisciplinas() {
        return (List<Disciplina>) findAll();
    }
}

package ada.tech.service;

import ada.tech.dao.DisciplinaDao;
import ada.tech.dto.DisciplinaDto;
import ada.tech.model.Disciplina;

import java.util.List;

public class DisciplinaService {
    DisciplinaDao disciplinaDao = new DisciplinaDao();

    public List<Disciplina> findAllDisciplinas() {
        return disciplinaDao.findAllDisciplinas();
    }

    public Disciplina findDisciplina(int id) {
        return disciplinaDao.findDisciplina(id);
    }

    public void deleteDisciplina(int id) {
        disciplinaDao.deleteDisciplina(id);
    }

    public void createDisciplina(DisciplinaDto disciplinaDto) {
        disciplinaDao.createDisciplina(disciplinaDto);
    }

    public void updateDisciplina(int id, DisciplinaDto disciplinaDto) { disciplinaDao.updateDisciplina(id, disciplinaDto); }
}

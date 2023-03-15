package ada.tech.service;

import ada.tech.dao.ProfessorDao;
import ada.tech.dto.ProfessorDto;
import ada.tech.model.Professor;

import java.util.List;

public class ProfessorService {
    ProfessorDao professorDao = new ProfessorDao();

    public List<Professor> findAllProfessores() {
        return professorDao.findAllProfessores();
    }

    public Professor findProfessor(int id) {
        return professorDao.findProfessor(id);
    }

    public void deleteProfessor(int id) {
        professorDao.deleteProfessor(id);
    }

    public void createProfessor(ProfessorDto professorDto) {
        professorDao.createProfessor(professorDto);
    }

    public void updateProfessor(int id, ProfessorDto professorDto) {
        professorDao.updateProfessor(id, professorDto);
    }
}

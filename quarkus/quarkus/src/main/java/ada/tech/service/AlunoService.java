package ada.tech.service;

import ada.tech.dao.AlunoDao;
import ada.tech.dto.AlunoDto;
import ada.tech.model.Aluno;

import java.util.List;

public class AlunoService {
    AlunoDao alunoDao = new AlunoDao();

    public List<Aluno> findAllAlunos() {
        return alunoDao.findAllAlunos();
    }

    public Aluno findAluno(int id) {
        return alunoDao.findAluno(id);
    }

    public void deleteAluno(int id) {
        alunoDao.deleteAluno(id);
    }

    public void createAluno(AlunoDto alunoDto) {
        alunoDao.createAluno(alunoDto);
    }

    public void updateAluno(int id, AlunoDto alunoDto) {
        alunoDao.updateAluno(id, alunoDto);
    }
}

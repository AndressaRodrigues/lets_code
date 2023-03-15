package ada.tech.service;

import ada.tech.dao.CursoDao;
import ada.tech.dto.CursoDto;
import ada.tech.model.Curso;

import java.util.List;

public class CursoService {
    CursoDao cursoDao = new CursoDao();

    public List<Curso> findAllCursos() {
        return cursoDao.findAllCursos();
    }

    public Curso findCurso(int id) {
        return cursoDao.findCurso(id);
    }

    public void deleteCurso(int id) {
        cursoDao.deleteCurso(id);
    }

    public void createCurso(CursoDto cursoDto) {
        cursoDao.createCurso(cursoDto);
    }

    public void updateCurso(int id, CursoDto cursoDto) { cursoDao.updateCurso(id, cursoDto); }
}

package ada.tech.rest;

import ada.tech.dto.CursoDto;
import ada.tech.service.CursoService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;


@Path("/curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoRest {

    private CursoService cursoService = new CursoService();

    @GET
    public List<CursoDto> buscarCursos() {
        return cursoService.findAllCursos().stream().map(CursoDto::from).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public CursoDto encontrarCurso(@PathParam("id") final int id) {
        return CursoDto.from(cursoService.findCurso(id));
    }

    @POST
    @Transactional
    public void criarCurso(final CursoDto cursoDto) {
        cursoService.createCurso(cursoDto);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void apagarCurso(@PathParam("id") int id) {
        cursoService.deleteCurso(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void atualizarCurso(@PathParam("id") int id, final CursoDto CursoDto) {
        cursoService.updateCurso(id, CursoDto);
    }

}

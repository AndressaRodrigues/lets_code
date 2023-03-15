package ada.tech.rest;

import ada.tech.dto.DisciplinaDto;
import ada.tech.service.DisciplinaService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;


@Path("/disciplina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaRest {

    private DisciplinaService disciplinaService = new DisciplinaService();

    @GET
    public List<DisciplinaDto> buscarDisciplinas() {
        return disciplinaService.findAllDisciplinas().stream().map(DisciplinaDto::from).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public DisciplinaDto encontrarDisciplina(@PathParam("id") final int id) {
        return DisciplinaDto.from(disciplinaService.findDisciplina(id));
    }

    @POST
    @Transactional
    public void criarDisciplina(final DisciplinaDto disciplinaDto) {
        disciplinaService.createDisciplina(disciplinaDto);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void apagarDisciplina(@PathParam("id") int id) {
        disciplinaService.deleteDisciplina(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void atualizarDisciplina(@PathParam("id") int id, final DisciplinaDto disciplinaDto) {
        disciplinaService.updateDisciplina(id, disciplinaDto);
    }

}

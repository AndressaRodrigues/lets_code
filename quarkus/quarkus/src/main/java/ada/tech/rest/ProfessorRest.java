package ada.tech.rest;

import ada.tech.dto.ProfessorDto;
import ada.tech.service.ProfessorService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;


@Path("/Professor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorRest {

    private ProfessorService professorService = new ProfessorService();

    @GET
    public List<ProfessorDto> buscarProfessores() {
        return professorService.findAllProfessores().stream().map(ProfessorDto::from).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public ProfessorDto encontrarProfessor(@PathParam("id") final int id) {;
        return ProfessorDto.from(professorService.findProfessor(id));
    }

    @POST
    @Transactional
    public void criarProfessor(final ProfessorDto professorDto) {
        professorService.createProfessor(professorDto);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void apagarProfessor(@PathParam("id") int id) {
        professorService.deleteProfessor(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void atualizarProfessor(@PathParam("id") int id, final ProfessorDto professorDto) {
        professorService.updateProfessor(id, professorDto);
    }

}

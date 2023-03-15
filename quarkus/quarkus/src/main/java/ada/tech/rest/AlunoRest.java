package ada.tech.rest;

import ada.tech.dto.AlunoDto;
import ada.tech.service.AlunoService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;


@Path("/aluno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoRest {

    private AlunoService alunoService = new AlunoService();

    @GET
    public List<AlunoDto> buscarAlunos() {
        return alunoService.findAllAlunos().stream().map(AlunoDto::from).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public AlunoDto encontrarAluno(@PathParam("id") final int id) {
        return AlunoDto.from(alunoService.findAluno(id));
    }

    @POST
    @Transactional
    public void criarAluno(final AlunoDto alunoDto) {
        alunoService.createAluno(alunoDto);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void apagarAluno(@PathParam("id") int id) {
        alunoService.deleteAluno(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void atualizarAluno(@PathParam("id") int id, final AlunoDto alunoDto) {
        alunoService.updateAluno(id, alunoDto);
    }

}

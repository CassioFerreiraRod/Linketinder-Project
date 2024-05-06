package br.com.linketinder.controller

import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.service.CompetenciaService
import br.com.linketinder.service.VagaService

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import java.util.logging.Level
import java.util.logging.Logger

@Path("/empresas/vagas")
class VagaController {

    private VagaService vagaService = new VagaService()
    private CompetenciaService competenciaService = new CompetenciaService()
    private Map mensagem = [
            resposta: Response.Status.CREATED
    ]

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    Response cadastrarVaga(Vaga vaga) {
        try {
            vagaService.cadastrarVaga(vaga)
            competenciaService.cadastrarVagaCompetencia(vaga.getCompetencias())

            return Response.status(Response.Status.CREATED)
                    .entity(mensagem)
                    .type(MediaType.APPLICATION_JSON)
                    .build()
        } catch (WebApplicationException ex) {
            Logger.getLogger(VagaController.class.getName()).log(Level.SEVERE, null, ex)
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR)
        }
    }
}

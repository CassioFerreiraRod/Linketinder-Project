package br.com.linketinder.controller

import br.com.linketinder.model.entity.Competencia
import br.com.linketinder.service.CompetenciaService

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import java.util.logging.Level
import java.util.logging.Logger

@Path("/competencia")
class CompetenciaController {
    CompetenciaService competenciaService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    Response cadastrarCompetencia(Competencia competencia) {
        try {
            competenciaService.cadastrarCompetencia(competencia)

            Map mensagem = [mensagem: "Cadastro feito com sucesso!"]

            return Response.status(Response.Status.CREATED)
                    .entity(mensagem)
                    .type(MediaType.APPLICATION_JSON)
                    .build()
        } catch (WebApplicationException ex) {
            Logger.getLogger(CompetenciaController.class.getName()).log(Level.SEVERE, null, ex)
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR)
        }
    }
}

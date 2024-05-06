package br.com.linketinder.controller

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.service.CandidatoService
import br.com.linketinder.service.CompetenciaService

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import java.util.logging.Level
import java.util.logging.Logger

@Path("/candidatos")
class CandidatoController {

    private CandidatoService candidatoService = new CandidatoService()
    private CompetenciaService competenciaService = new CompetenciaService()
    private Map mensagem = [
            "status": 201,
            "mensagem": "Cadastro feito com sucesso"
    ]

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    Response cadastrarCandidato(Candidato candidato) {
        try {
            candidatoService.cadastrarCandidato(candidato)
            competenciaService.cadastrarCandidatoCompetencia(candidato.getCompetencias())
            return Response.status(Response.Status.CREATED)
                    .entity(mensagem)
                    .type(MediaType.APPLICATION_JSON)
                    .build()
        } catch (WebApplicationException ex) {
            ex.getMessage()
            Logger.getLogger(CandidatoController.class.getName()).log(Level.SEVERE, null, ex)
            return Response.status(Response.Status.CREATED).build()
        }
    }

}

package br.com.linketinder.controller

import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.service.EmpresaService

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import java.util.logging.Level
import java.util.logging.Logger

@Path("/empresas")
class EmpresaController {

    EmpresaService empresaService = new EmpresaService()

    Map mensagem = [
            resposta: Response.Status.CREATED
    ]

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    Response cadastrarEmpresa(Empresa empresa) {
        try {
            empresaService.cadastrarEmpresa(empresa)

            return Response.status(Response.Status.CREATED)
                    .entity(mensagem)
                    .type(MediaType.APPLICATION_JSON)
                    .build()
        } catch (WebApplicationException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex)
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR)
        }
    }
}

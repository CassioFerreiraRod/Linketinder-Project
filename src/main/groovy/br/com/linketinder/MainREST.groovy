package br.com.linketinder
;

import org.glassfish.jersey.server.ResourceConfig

import javax.ws.rs.ApplicationPath

@ApplicationPath("/usuario")
class MainREST extends ResourceConfig{
    MainREST() {
        packages("br.com.linketinder.controller")
    }
}
import { Candidato } from "../usuario/Candidato";
import { CandidatoStorage } from "../cadastro/CandidatoStorage";
import { EmpresaStorage } from "../cadastro/EmpresaStorage";
import { Empresa } from "../usuario/Empresa";
import { anonimizarNome, anonimizarEmail } from "./deixaDadosEmAnomino"

document.addEventListener("DOMContentLoaded", () => {

    const empresaStorage = new EmpresaStorage();
    const empresas = empresaStorage.getStoredEmpresas();


    preencherDadosPerfil(empresas[0])

    const candidatoStorage = new CandidatoStorage()
    const candidatos = candidatoStorage.getStoredCandidatos()
    listarCandidatos(candidatos)
})

function listarCandidatos(candidatos: Candidato[]): void {

    const candidatosElement = document.getElementById('lista-candidatos')

    if (candidatosElement) {
        candidatosElement.innerHTML += ''
        candidatos.forEach((candidato) => {
            candidatosElement.innerHTML += `
                <div class="mb-3">                
                     <h4>${anonimizarNome(candidato.nome)}</h4>
                     <p>Email: ${anonimizarEmail(candidato.email)}</p>
                     <p>Localização: ${candidato.estado}</p>
                     <p>Competências: ${candidato.competencias.slice(0, -1).join(", ")}</p>
                     <p>Descrição: ${candidato.descricao}</p>                    
                </div>
            `
        })
    }

}

function preencherDadosPerfil(empresa: Empresa): void {
    const nomeElement = document.querySelector('.nome')
    if (nomeElement) {
        nomeElement.textContent = empresa.nome
       
    }

    const emailElement = document.querySelector('.email')

    if (emailElement) {
        emailElement.textContent = empresa.email
    }
    const cnpjElement = document.querySelector('.cnpj')

    if (cnpjElement) {
        cnpjElement.textContent = empresa.cnpj
    }

    const estadoElement = document.querySelectorAll('.pais li')
    if (estadoElement) {
        estadoElement[0].textContent = `${empresa.pais},`
        estadoElement[1].textContent = `${empresa.estado},`
        estadoElement[2].textContent = empresa.cep
    }

    const descricaoElement = document.querySelector('.descricao')

    if (descricaoElement) {
        descricaoElement.textContent = empresa.descricao
    }

    const competenciasElement = document.querySelector('.competencias')

    if (competenciasElement) {
        competenciasElement.innerHTML = ''
    
        
        empresa.competencias.forEach(competencia => {
            
            competenciasElement.innerHTML += `<li class="badge text-bg-secondary text-wrap me-2">${competencia}</li>`
        });
    }
 
}

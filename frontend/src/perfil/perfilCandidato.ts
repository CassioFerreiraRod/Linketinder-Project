import { Candidato } from "../usuario/Candidato";
import { CandidatoStorage } from "../cadastro/CandidatoStorage";
import { EmpresaStorage } from "../cadastro/EmpresaStorage";
import { Empresa } from "../usuario/Empresa";
import { anonimizarNome, anonimizarEmail } from "./deixaDadosEmAnomino"

document.addEventListener("DOMContentLoaded", () => {

    const candidatoStorage = new CandidatoStorage();
    const candidatos = candidatoStorage.getStoredCandidatos();


    preencherDadosPerfil(candidatos[0])

    const empresaStorage = new EmpresaStorage()
    const empresas = empresaStorage.getStoredEmpresas()
    listarEmpresas(empresas)
})

function listarEmpresas(empreas: Empresa[]): void {

    const empresasElement = document.getElementById('lista-empresas')

    if (empresasElement) {
        empresasElement.innerHTML += ''
        empreas.forEach((empresa) => {
            empresasElement.innerHTML += `
                <div>                
                     <h4>${anonimizarNome(empresa.nome)}</h4>
                     <p>Email: ${anonimizarEmail(empresa.email)}</p>
                     <p>Localização: ${empresa.pais}, ${empresa.estado}, ${empresa.cep}</p>
                     <p>Competências: ${empresa.competencias.slice(0, -1).join(", ")}</p>
                     <p>Descrição: ${empresa.descricao}</p>                    
                </div>
            `
        })
    }

}

function preencherDadosPerfil(candidato: Candidato): void {
    const nomeElement = document.querySelectorAll('.nome-idade li')
    if (nomeElement) {
        nomeElement[0].innerHTML = `<h3>${candidato.nome}</h3>`
        nomeElement[1].innerHTML = `<h3>, ${candidato.idade.toString()} anos</h3>`
    }

    const emailElement = document.querySelector('.email')

    if (emailElement) {
        emailElement.textContent = candidato.email
    }
    const cpfElement = document.querySelector('.cpf')

    if (cpfElement) {
        cpfElement.textContent = candidato.cpf
    }

    const estadoElement = document.querySelectorAll('.estado li')
    if (estadoElement) {
        estadoElement[0].textContent = candidato.estado
        estadoElement[1].textContent = `, ${candidato.cep.toString()}`
    }

    const descricaoElement = document.querySelector('.descricao')

    if (descricaoElement) {
        descricaoElement.textContent = candidato.descricao
    }

    const competenciasElement = document.querySelector('.competencias')

    if (competenciasElement) {
        competenciasElement.innerHTML = ''
    
        
        candidato.competencias.forEach(competencia => {
            
            competenciasElement.innerHTML += `<li class="badge text-bg-secondary text-wrap me-2">${competencia}</li>`
        });
    }
 
}

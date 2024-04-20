import { Candidato } from "../model/Candidato";
import { CandidatoStorage } from "../storageDB/CandidatoStorage";
import { EmpresaStorage } from "../storageDB/EmpresaStorage";
import { Empresa } from "../model/Empresa";
import { anonimizarNome, anonimizarEmail } from "../tools/deixaDadosEmAnomino"

document.addEventListener("DOMContentLoaded", () => {

    const empresaStorage = new EmpresaStorage();
    const empresas = empresaStorage.getStoredEmpresas();

    const urlParams = new URLSearchParams(window.location.search);
    const cnpjParam = urlParams.get('cnpj');
    const empresa = empresas.find((e: Empresa) => e.cnpj === cnpjParam);

    if (empresa) {
        preencherDadosPerfil(empresa)
    } else {
        console.error("Empresa nao encontrada");
    }

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
                <div class="mb-3"  style="max-width: 300px;">                
                     <h4>${anonimizarNome(candidato.nome)}</h4>
                     <p>Email: ${anonimizarEmail(candidato.email)}</p>
                     <p>Localização: ${anonimizarNome(candidato.estado)}</p>
                     <p>Competências: ${candidato.competencias.join(", ")}</p>
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
 
}

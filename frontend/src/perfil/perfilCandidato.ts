import { Candidato } from "../model/Candidato";
import { CandidatoStorage } from "../storageDB/CandidatoStorage";
import { anonimizarNome, anonimizarEmail } from "../tools/deixaDadosEmAnomino"
import {Vagas} from "../model/Vagas";
import {VagaStorage} from "../storageDB/VagaStorage";

document.addEventListener("DOMContentLoaded", () => {

    const candidatoStorage = new CandidatoStorage();
    const candidatos = candidatoStorage.getStoredCandidatos()

    const urlParams = new URLSearchParams(window.location.search)
    const cpfParam = urlParams.get('cpf')
    const candidato = candidatos.find((c: Candidato) => c.cpf === cpfParam)

    if (candidato) {
        preencherDadosPerfil(candidato)
    } else {
        console.error("Candidato nao encontrada");
    }

    const vagaStorage = new VagaStorage()
    const vagas = vagaStorage.getStoredVagass()
    listarVagas(vagas)
})

function listarVagas(vagas: Vagas[]): void {

    const vagasElement = document.getElementById('lista-vagas')

    if (vagasElement) {
        vagasElement.innerHTML += ''
        vagas.forEach((vaga) => {
            vagasElement.innerHTML += `
                <div class="card mb-3 mx-4" style="max-width: 300px;">
                    <div class="card-body">
                      <h4 class="card-title">${anonimizarNome(vaga.nomeEmpresa)}</h4>
                      <p class="card-text">Descrição: ${vaga.descricaoVaga}</p>
                      <p class="card-text">Localização: ${anonimizarNome(vaga.cidade)}, ${anonimizarNome(vaga.estado)}</p>
                      <p class="card-text">Competências: ${vaga.competencias.join(", ")}</p>
                    </div>
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
        estadoElement[1].textContent = `, ${candidato.cep}`
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

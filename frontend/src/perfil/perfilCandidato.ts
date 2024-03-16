import {Candidato} from "../usuario/Candidato";
import {CandidatoStorage} from "../cadastro/CandidatoStorage";
import {EmpresaStorage} from "../cadastro/EmpresaStorage";
import {Empresa} from "../usuario/Empresa";
import {anonimizarNome, anonimizarEmail} from "./deixaDadosEmAnomino"

document.addEventListener("DOMContentLoaded", () => {

    const empresaStorage = new EmpresaStorage()
    const empresas = empresaStorage.getStoredEmpresas()
    listarEmpresas(empresas)
})

function listarEmpresas(empreas: Empresa[]):void {
    const empresasElement = document.getElementById('lista-empresas')

    if(empresasElement) {
        empresasElement.innerHTML += ''
        empreas.forEach((empresa) => {
            empresasElement.innerHTML += `
                <div>                
                     <h4>${anonimizarNome(empresa.nome)}</h4>
                     <p>Email: ${anonimizarEmail(empresa.email)}</p>
                     <p>Localização: ${empresa.pais}, ${empresa.estado}, ${empresa.cep}</p>
                     <p>Competências ${empresa.competencias.slice(0, -1).join(", ")}</p>
                     <p>Descrição: ${empresa.descricao}</p>                    
                </div>
            `
        })
    }

}

import {Candidato} from "../usuario/Candidato";
import {CandidatoStorage} from "../cadastro/CandidatoStorage";
import {EmpresaStorage} from "../cadastro/EmpresaStorage";
import {Empresa} from "../usuario/Empresa";

document.addEventListener("DOMContentLoaded", () => {

    const empresaStorage = new EmpresaStorage()
    const empresas = empresaStorage.getStoredEmpresas()
    listarEmpresas(empresas)
})

function listarEmpresas(empreas: Empresa[]) {
    const empresasElement = document.getElementById('lista-empresas')

    if(empresasElement) {
        empresasElement.innerHTML += ''
        empreas.forEach((empresa) => {
            empresasElement.innerHTML += `
                <div>                
                     <h4>${empresa.nome}</h4>
                     <p>${empresa.email}</p>
                     <p>${empresa.pais}, ${empresa.estado}, ${empresa.cep}</p>
                     <p>${empresa.competencias.slice(0, -1)}</p>
                     <p>${empresa.descricao}</p>                    
                </div>
            `
        })
    }

}

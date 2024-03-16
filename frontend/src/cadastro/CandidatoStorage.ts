import {Candidato} from "../usuario/Candidato";

export class CandidatoStorage {
    add(candidato: Candidato ): void {
        let candidatos: Candidato[] = this.getStoredCandidatos()
        candidatos.push(candidato)
        window.localStorage.setItem("candidatos", JSON.stringify(candidatos))
    }

    getStoredCandidatos(): Candidato[] {
        const storage = window.localStorage.getItem("empresas")
        if (storage) {
            return JSON.parse(storage)
        } else {
            return []
        }
    }
}
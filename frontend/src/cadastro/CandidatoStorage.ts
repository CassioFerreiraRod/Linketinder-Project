import {Candidato} from "../usuario/Candidato";

export class CandidatoStorage {
    add(candidato: Candidato ): void {
        let candidatos: Candidato[] = this.verificaStorage()
        candidatos.push(candidato)
        window.localStorage.setItem("empresas", JSON.stringify(candidatos))
    }

    verificaStorage(): Candidato[] {
        const storage = window.localStorage.getItem("empresas")
        if (storage) {
            return JSON.parse(storage)
        } else {
            return []
        }
    }
}
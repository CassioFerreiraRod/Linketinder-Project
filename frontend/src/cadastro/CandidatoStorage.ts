import {Candidato} from "../usuario/Candidato";

export class CandidatoStorage {
    add(candidato: Candidato ): void {
        let candidatos: Candidato[] = this.getStoredCandidatos()
        const candidatoExiste = candidatos.some(candidatoExistente => candidatoExistente.cpf === candidato.cpf);
        if (!candidatoExiste) {
            candidatos.push(candidato)
            window.localStorage.setItem("candidatos", JSON.stringify(candidatos))
        } else {
            alert(`Cpf já cadastrado`);
        }
    }

    getStoredCandidatos(): Candidato[] {
        const storage = window.localStorage.getItem("candidatos")
        if (storage) {
            return JSON.parse(storage)
        } else {
            return []
        }
    }
}
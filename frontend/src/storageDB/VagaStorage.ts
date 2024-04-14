import {Vagas} from "../model/Vagas";

export class VagaStorage {
    add(vaga: Vagas): void {
        let vagas: Vagas[] = this.getStoredVagass()
        const vagaExiste = vagas.some(vagaExistente => vagaExistente.nomeEmpresa === vaga.nomeEmpresa);
        if (!vagaExiste) {
            vagas.push(vaga)
            window.localStorage.setItem("vagas", JSON.stringify(vagas))
        } else {
            console.log(`A vaga da empresa ${vaga.nomeEmpresa} já está na lista.`);
        }
    }

    getStoredVagass(): Vagas[] {
        const storage = window.localStorage.getItem("vagas")
        if (storage) {
            return JSON.parse(storage)
        } else {
            return []
        }
    }
}
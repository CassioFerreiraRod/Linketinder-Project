import {Empresa} from "../usuario/Empresa";

export class EmpresaStorage {
    add(empresa: Empresa): void {
        let empresas: Empresa[] = this.getStoredEmpresas()
        const empresaExiste = empresas.some(empresaExistente => empresaExistente.cnpj === empresa.cnpj);
        if (!empresaExiste) {
            empresas.push(empresa)
            window.localStorage.setItem("empresas", JSON.stringify(empresas))
        } else {
            console.log(`A empresa ${empresa.nome} já está na lista.`);
        }
    }

    getStoredEmpresas(): Empresa[] {
        const storage = window.localStorage.getItem("empresas")
        if (storage) {
            return JSON.parse(storage)
        } else {
            return []
        }
    }
}
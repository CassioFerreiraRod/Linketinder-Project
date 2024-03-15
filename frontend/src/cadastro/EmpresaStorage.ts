import {Empresa} from "../usuario/Empresa";

export class EmpresaStorage {
    add(empresa: Empresa): void {
        let empresas: Empresa[] = this.verificaStorage()
        empresas.push(empresa)
        window.localStorage.setItem("empresas", JSON.stringify(empresas))
    }

    verificaStorage(): Empresa[] {
        const storage = window.localStorage.getItem("empresas")
        if (storage) {
            return JSON.parse(storage)
        } else {
            return []
        }
    }
}
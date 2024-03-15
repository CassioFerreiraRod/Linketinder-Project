import { Usuario } from "./Usuario"

export class Empresa extends Usuario {

    constructor(public nome: string,
                public cnpj:string,
                public email: string,
                public cep: string,
                public estado: string,
                public pais:string,
                public descricao: string,
                public competencias: string[]) {
        super(nome, email, cep, estado, descricao, competencias);
    }

    toString() {
        return {
            nome: this.nome,
            cnpj: this.cnpj,
            email: this.email,
            cep: this.cep,
            estado: this.estado,
            pais: this.pais,
            descricao: this.descricao,
            competencias: this.competencias,
        }
    }
}
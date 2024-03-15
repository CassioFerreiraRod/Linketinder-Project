import { Usuario } from "./Usuario";

export class Candidato extends Usuario{

    constructor(public nome: string,
                public idade:number,
                public cpf:string,
                public email: string,
                public cep: string,
                public estado: string,
                public descricao: string,
                public competencias: string[]) {
        super(nome, email, cep, estado, descricao, competencias);
    }

}
import {Usuario} from "./Usuario"

export class Empresa extends Usuario {

    constructor(
        public nome: string,
        public cnpj: string,
        public email: string,
        public cep: string,
        public estado: string,
        public pais: string,
        public descricao: string,
       ){
        super(nome, email, cep, estado, descricao);

    }

}
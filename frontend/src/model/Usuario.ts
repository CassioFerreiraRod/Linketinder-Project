export abstract class Usuario {
    constructor(
        public nome: string,
        public email: string,
        public cep: string,
        public estado: string,
        public descricao: string,
    ) {
    }

}
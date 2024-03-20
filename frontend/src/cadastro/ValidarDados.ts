export function validarCpf(cpf: string): boolean {
    const regexCpf: RegExp = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/
    return regexCpf.test(cpf)
}

export function validarCnpj(cnpj: string): boolean {
    const regexCnpj: RegExp = /^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/
    return regexCnpj.test(cnpj)
}

export function validarCep(cep: string): boolean {
    const regexCep: RegExp = /^\d{5}\-\d{3}$/
    return regexCep.test(cep)
}

export function validarEmail(email: string): boolean {
    const regexEmail: RegExp = /^\S+@\w+\.\w{2,6}(\.\w{2})?$/
    return regexEmail.test(email)
}
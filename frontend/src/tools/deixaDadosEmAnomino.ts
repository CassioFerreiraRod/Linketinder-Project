export function anonimizarNome(nome: string): string {

    const nomeAnonimo: string = nome.slice(0, 2) + '*'.repeat(nome.length - 2)
    return nomeAnonimo
}
export function anonimizarEmail(email: string): string {
    const partes: string[] = email.split('@');
    const nomeUsuario = partes[0];
    const dominio = partes[1];

    const nomeUsuarioAnonimo = anonimizarNome(nomeUsuario);

    const partesDominio: string[] = dominio.split('.')
    const nomeDominio = partesDominio[0]
    const dominioRestante = partesDominio.slice(1).join('.')
    const nomeDominioAnonimo = anonimizarNome(nomeDominio)

    return `${nomeUsuarioAnonimo}@${nomeDominioAnonimo}.${dominioRestante}`
}
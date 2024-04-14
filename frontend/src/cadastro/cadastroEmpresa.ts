import { Empresa } from "../model/Empresa";
import { EmpresaStorage } from "../storageDB/EmpresaStorage"
import { validarCep, validarCnpj, validarEmail } from "../tools/ValidarDados";

let nome: string
let cnpj: string
let email: string
let cep: string
let estado: string
let pais: string
let descricao: string

const empresaForm: HTMLElement | null = document.forms.namedItem("cadastroEmpresa")
empresaForm?.addEventListener('submit', (event) => {
    event.preventDefault()

    if (nome && cnpj && email && cep && estado && pais && descricao && validarDados()) {

        const empresa: Empresa = new Empresa(
            nome,
            cnpj,
            email,
            cep,
            estado,
            pais,
            descricao,
        )

        const storage: EmpresaStorage = new EmpresaStorage()
        storage.add(empresa)

        const perfilURL: string = `perfilEmpresa.html?cnpj=${empresa.cnpj}`;

        window.location.href = perfilURL;

        alert('Cadastro realizado com sucesso!')
    } else {
        alert('Há campos não preecnchidos ou dados inválidos.')
    }

})

function validarDados(): boolean {
    return validarCep(cep), validarCnpj(cnpj), validarEmail(email)
}


function atulizarFormulario(): void {
    const campos: string[] = ["nome", "cnpj", "email", "cep", "estado", "pais", "descricao"]
    campos.forEach((campo => {
        const entrada: HTMLInputElement = document.getElementById(campo) as HTMLInputElement
        entrada?.addEventListener("change", () => {
            switch (campo) {
                case "nome":
                    nome = entrada.value
                    break;
                case "pais":
                    pais = entrada.value
                    break;
                case "cnpj":
                    cnpj = entrada.value
                    break;
                case "email":
                    email = entrada.value
                    break;
                case "cep":
                    cep = entrada.value
                    break;
                case "estado":
                    estado = entrada.value
                    break;
                case "descricao":
                    descricao = entrada.value
                    break;
                default:
                    break;
            }
        })
    }))
}

atulizarFormulario()
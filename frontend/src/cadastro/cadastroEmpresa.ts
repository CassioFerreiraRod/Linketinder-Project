import { Empresa } from "../usuario/Empresa";
import { EmpresaStorage } from "./EmpresaStorage"
import { validarCep, validarCnpj, validarEmail } from "./ValidarDados";

let nome: string
let cnpj: string
let email: string
let cep: string
let estado: string
let pais: string
let descricao: string
let competencias: string[] = []

const empresaForm: HTMLElement | null = document.forms.namedItem("cadastroEmpresa")
empresaForm?.addEventListener('submit', (event) => {
    event.preventDefault()

    if (nome && cnpj && email && cep && estado && pais && descricao && competencias.length > 0 && validarDados()) {

        const empresa: Empresa = new Empresa(
            nome,
            cnpj,
            email,
            cep,
            estado,
            pais,
            descricao,
            competencias
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
    const campos: string[] = ["nome", "cnpj", "email", "cep", "estado", "pais", "descricao", "competencias"]
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
    const checkboxes: NodeListOf<HTMLInputElement> = document.querySelectorAll<HTMLInputElement>('input[name="competencias"]')
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            if (checkbox.checked) {
                competencias.push(checkbox.value);
            } else {
                competencias = competencias.filter((competencia) => competencia !== checkbox.value)
            }
        })

    })
}

atulizarFormulario()
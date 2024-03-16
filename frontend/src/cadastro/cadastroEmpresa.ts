import {Empresa} from "../usuario/Empresa";
import {EmpresaStorage} from "./EmpresaStorage"

let nome: string
let cnpj:string
let email: string
let cep: string
let estado: string
let pais:string
let descricao: string
let competencias: string[] = []

const empresaForm: HTMLElement | null = document.forms.namedItem("cadastroEmpresa")
empresaForm?.addEventListener('submit', (event) => {
    event.preventDefault()
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
})

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
            const checkboxes: NodeListOf<HTMLInputElement> = document.querySelectorAll<HTMLInputElement>('input[name="competencias"]:checked')
            checkboxes.forEach(checkbox => {
                competencias.push(checkbox.value);
            });
        })
    }))
}

atulizarFormulario()
import {Candidato} from "../usuario/Candidato";
import {CandidatoStorage} from "./CandidatoStorage"

let nome: string
let idade: number
let cpf: string
let email: string
let cep: string
let estado: string
let descricao: string
let competencias: string[] = []

const candidatoForm: HTMLElement | null = document.forms.namedItem("cadastroCandidato")
candidatoForm?.addEventListener('submit', (event) => {
    event.preventDefault()
    const candidato:Candidato = new Candidato(nome,
        idade,
        cpf,
        email,
        cep,
        estado,
        descricao,
        competencias
    )
    const storage:CandidatoStorage = new CandidatoStorage()
    storage.add(candidato)
})

function atulizarFormulario(): void {
    const campos: string[] = ["nome", "idade", "cpf", "email", "cep", "estado", "descricao", "competencias"]
    campos.forEach((campo => {
        const entrada: HTMLInputElement = document.getElementById(campo) as HTMLInputElement
        entrada?.addEventListener("change", () => {
            switch (campo) {
                case "nome":
                    nome = entrada.value
                    break;
                case "idade":
                    idade = parseInt(entrada.value, 10)
                    break;
                case "cpf":
                    cpf = entrada.value
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
                checkbox.addEventListener('change', () => {
                    competencias.push(checkbox.value);
                })

            });
        })
    }))
}

atulizarFormulario()
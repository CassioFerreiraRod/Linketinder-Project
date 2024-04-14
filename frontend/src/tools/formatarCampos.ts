import Cleave from 'cleave.js'

document.addEventListener('DOMContentLoaded', function () {
    const formatarCpf = new Cleave('#cpf', {
        delimiters: ['.', '.', '-'],
        blocks: [3, 3, 3, 2],
        numericOnly: true
    })
})

document.addEventListener('DOMContentLoaded', function () {
    const formatarCnpj = new Cleave('#cnpj', {
        delimiters: ['.', '.', '/', '-'],
        blocks: [2, 3, 3, 4, 2],
        numericOnly: true
    })
})
document.addEventListener('DOMContentLoaded', function () {
    const formatarCep = new Cleave('#cep', {
        delimiter: '-',
        blocks: [5, 2],
        numericOnly: true
    })
})
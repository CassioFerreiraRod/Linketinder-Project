import Chart from 'chart.js/auto';
import { CandidatoStorage } from '../cadastro/CandidatoStorage'
import { Candidato } from '../usuario/Candidato';

const candidatoStorage: CandidatoStorage = new CandidatoStorage()
const candidatos: Candidato[] = candidatoStorage.getStoredCandidatos()
const contagemDeCompetencias: { [key: string]: number } = {}

candidatos.forEach((candidato) => {
    candidato.competencias.forEach((competencia) => {
        contagemDeCompetencias[competencia] = contagemDeCompetencias[competencia] || 0
        contagemDeCompetencias[competencia]++
    })
})

const ctx = document.getElementById('grafico') as HTMLCanvasElement;

const labels = Object.keys(contagemDeCompetencias)

const data = {
    labels: labels,
    datasets: [{
        label: 'Candidatos por Competência',
        data: Object.values(contagemDeCompetencias),
        backgroundColor: 'rgba(153, 102, 255, 0.2)',
        borderColor: '#333333',
        borderWidth: 1
    }]
};

const options = {
    scales: {
        y: {
            beginAtZero: true
        }
    }
};

const myChart = new Chart(ctx, {
    type: 'bar',
    data: data,
    options: options
});
console.log(contagemDeCompetencias);

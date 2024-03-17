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
        label: '# of Votes',
        data: Object.values(contagemDeCompetencias),
        backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: '#555555',
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

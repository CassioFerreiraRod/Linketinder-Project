import br.com.linketinder.service.CompetenciaService

class Main {

    static void main(String[] args) {
//        MenuPrincipal principal = new MenuPrincipal()
//
//        principal.exibirMenu()
        List<String> list = new ArrayList<>()
        list.add("Java")
        list.add("Groovy")

        CompetenciaService competenciaService = new CompetenciaService()
        competenciaService.cadastrarCandidatoCompetencia(list)
    }
}

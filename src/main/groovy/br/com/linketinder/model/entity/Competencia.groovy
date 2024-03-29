package br.com.linketinder.model.entity

class Competencia {
    int id
    String competencia

    Competencia(String competencia) {
        this.competencia = competencia
    }

    Competencia(int id, String competencia) {
        this.id = id
        this.competencia = competencia
    }

    @Override
    public String toString() {
        return """\
Competencia{
    id: $id,
    competencia: $competencia
}"""
    }
}

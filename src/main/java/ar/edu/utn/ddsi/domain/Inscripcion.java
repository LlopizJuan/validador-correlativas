package ar.edu.utn.ddsi.domain;

import java.util.List;


public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribirse;

    public Inscripcion(Alumno alumno, List<Materia> materiasAInscribirse) {
        this.alumno = alumno;
        this.materiasAInscribirse = materiasAInscribirse;
    }

    public Boolean aprobada() {
        return materiasAInscribirse.stream()
                .allMatch(materia -> alumno.getMateriasAprobadas().containsAll(materia.getCorrelativas()));
    }

}
